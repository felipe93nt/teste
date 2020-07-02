package br.com.bradesco.web.ricc.service.business;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;
import br.com.bradesco.data.connector.cws.exception.CWSException;
import br.com.bradesco.data.connector.exception.ConnectorExecutionException;
import br.com.bradesco.web.aq.application.pagination.PaginationAPI;
import br.com.bradesco.web.aq.application.pagination.PaginationRequest;
import br.com.bradesco.web.aq.application.pagination.PaginationResponse;
import br.com.bradesco.web.aq.application.pagination.cws.CWSPaginationAPIAdapterImpl;
import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.aq.application.pagination.exception.PaginationAPIException;
import br.com.bradesco.web.aq.application.pagination.factory.PaginationAPIFactory;
import br.com.bradesco.web.aq.application.session.bean.AWBPaginationDataState;
import br.com.bradesco.web.aq.application.session.bean.AWBPaginationSessionState;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.DateUtil;
import br.com.bradesco.web.ricc.utils.SiteUtil;

public class BaseService {

	@Inject
	@Named("CWSBusinessServiceBaseConnector")
	protected CWSBusinessServiceBaseConnector adapterCWS = null;
	
	protected SiteUtil siteUtil = SiteUtil.getInstance();
	protected DateUtil dateUtil = DateUtil.getCurrentInstance();
	
	protected static final String RESOURCE = "CWS";
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param transacao
	 * @param tipoLista - Tipo do registro que será paginado Ex.: RICCWAASResponseRegistroAreaSaida
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <TRequest, TResponse, TRegistro> TResponse invokeProcessAutoPagination(TRequest request, TResponse response, String transacao, Class<TRegistro> tipoLista) throws ConnectorExecutionException {
		
		List<TResponse> lista = autoPaginate(request, response, transacao);
		List<TRegistro> listCombo = new ArrayList<TRegistro>();
		
		if (!lista.isEmpty()) {
			response = lista.get(0);
		}
		Method m2Response = null;
		Object retornoResponse = null;
		
		for(TResponse item : lista){
			for(Field field : item.getClass().getDeclaredFields()){
				CommareaBlock commarea = field.getAnnotation(CommareaBlock.class);
				try {
					if(commarea != null){
						Method mItem = item.getClass().getMethod("get"+field.getType().getSimpleName());
						Object retornoItem = mItem.invoke(item);
						
						Method mResponse = item.getClass().getMethod("get"+field.getType().getSimpleName());
						retornoResponse = mResponse.invoke(item);
						
						for(Field commAreaField : retornoItem.getClass().getDeclaredFields()){
							CommareaContainer commareaContainer = commAreaField.getAnnotation(CommareaContainer.class);
							if(commareaContainer != null && commareaContainer.type().toString().equals(tipoLista.toString())){
								
								String methodGetName = commAreaField.getName();
					            String methodGetNameCamelCase = "get".concat(methodGetName.substring(0, 1).toUpperCase()
					                                              .concat(methodGetName.substring(1, methodGetName.length())));
					            
					            String methodSetNameCamelCase = "set".concat(methodGetName.substring(0, 1).toUpperCase()
                                        .concat(methodGetName.substring(1, methodGetName.length())));
								
					            Method m2Item = retornoItem.getClass().getMethod(methodGetNameCamelCase);
					            
					            m2Response = retornoResponse.getClass().getMethod(methodSetNameCamelCase, List.class);
					            
	                			listCombo.addAll((List<TRegistro>) m2Item.invoke(retornoItem));
	                		}
						}
					}
				} catch (NoSuchMethodException e) {
					SiteUtil.getInstance().trataExceptionRecebida(e);
				} catch (SecurityException e) {
					SiteUtil.getInstance().trataExceptionRecebida(e);
				} catch (IllegalAccessException e) {
					SiteUtil.getInstance().trataExceptionRecebida(e);
				} catch (IllegalArgumentException e) {
					SiteUtil.getInstance().trataExceptionRecebida(e);
				} catch (InvocationTargetException e) {
					SiteUtil.getInstance().trataExceptionRecebida(e);
				}
				
			}
		}
		
		if(retornoResponse != null && m2Response != null){
			try {
				m2Response.invoke(retornoResponse, listCombo);
				
				response.getClass().getMethod("set"+retornoResponse.getClass().getSimpleName(), retornoResponse.getClass()).invoke(response, retornoResponse);
				
			} catch (IllegalAccessException e) {
				SiteUtil.getInstance().trataExceptionRecebida(e);
			} catch (IllegalArgumentException e) {
				SiteUtil.getInstance().trataExceptionRecebida(e);
			} catch (InvocationTargetException e) {
				SiteUtil.getInstance().trataExceptionRecebida(e);
			} catch (NoSuchMethodException e) {
				SiteUtil.getInstance().trataExceptionRecebida(e);
			} catch (SecurityException e) {
				SiteUtil.getInstance().trataExceptionRecebida(e);
			}
		}
		
		return response;
		
	} 
	
	private <TRequest, TResponse> List<TResponse> autoPaginate(TRequest request, TResponse response, String transactionName) throws ConnectorExecutionException {
        String stateID = UUID.randomUUID().toString().toUpperCase();
        
        return autoPaginate(request, response, transactionName, stateID);
    }
    
    @SuppressWarnings("unchecked")
    private <TRequest, TResponse> List<TResponse> autoPaginate(TRequest request, TResponse response, String transactionName, String stateID) throws ConnectorExecutionException {
        List<TResponse> results = new ArrayList<TResponse>();
        boolean init = false;
        boolean hasMoreData = false;
        
        try {
            Class<TResponse> responseClass = (Class<TResponse>) response.getClass();
            Field[] fields = responseClass.getDeclaredFields();
            Field outputBook = null;
            
            // Percorre todos os campos até encontrar o bloco de transação
            for (int i = 0; i < fields.length; i++) {
            	CommareaBlock annotation = fields[i].getAnnotation(CommareaBlock.class);
                
                // Verifica se é o campo referente ao bloco de transação
                if (annotation != null) {
                    outputBook = fields[i];
                    
                    break;
                }
            }
            
            String methodName = outputBook.getType().getSimpleName();
            String methodNameCamelCase = "set".concat(methodName.substring(0, 1).toUpperCase()
                                              .concat(methodName.substring(1, methodName.length())));          
                
            do {
                HashMap<String, Object> params = new HashMap<String, Object>();
                TResponse currentResponse = (TResponse) responseClass.newInstance();
                Method method = currentResponse.getClass().getMethod(methodNameCamelCase, outputBook.getType());
                
                method.invoke(currentResponse, outputBook.getType().newInstance());
                
                params.put("stateID", stateID);
                params.put("response", currentResponse);
                params.put("transactionName", transactionName);
            
                CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector> apiAdapter =
                                new CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector>(adapterCWS);
                PaginationAPI paginationAPI = PaginationAPIFactory.getInstance().getAPI(RESOURCE, apiAdapter, params);
            
                PaginationRequest<TRequest> paginationRequest = new PaginationRequest<TRequest>(request);
                PaginationResponse<TResponse> paginationResponse = new PaginationResponse<TResponse>();

                // Verifica se o processo já foi iniciado
                if (!init) {
                    init = true;
                    paginationResponse = paginationAPI.init(paginationRequest);
                    AWBPaginationSessionState.setAWBPaginationDataState("CWS", stateID, new AWBPaginationDataState());
                } else {
                    paginationResponse = paginationAPI.next(paginationRequest);
                }

                //atualiza a flag que informa se tem mais dados para frente (a direita)
                hasMoreData = paginationResponse.isHasMoreDataRight();
                results.add(paginationResponse.getResponse());
                
            } while (hasMoreData);
            
        } catch (NoSuchMethodException e) {
            results = new ArrayList<TResponse>();
        } catch (SecurityException e) {
            results = new ArrayList<TResponse>();
        } catch (InstantiationException e) {
            results = new ArrayList<TResponse>();
        } catch (IllegalAccessException e) {
            results = new ArrayList<TResponse>();
        } catch (PaginationAPIException e) {            
            // Verifica se a causa da exception é do tipo CTGServiceException
            if (e.getCause() instanceof InvocationTargetException) {
                InvocationTargetException invocationTargetException = (InvocationTargetException) e.getCause();
                
                // Verifica se é uma exceção do tipo CTGServiceException para obter o código de retorno e mensagem correta
                if (invocationTargetException.getTargetException() instanceof CWSException) {
                	CWSException ctgServiceException = (CWSException) invocationTargetException
                            .getTargetException();
                    
                    BradescoFacesUtils.addErrorModalMessage(ctgServiceException.getMessage());
                    
                } else if(invocationTargetException.getTargetException() instanceof ConnectorExecutionException){
                	ConnectorExecutionException _cee = (ConnectorExecutionException) invocationTargetException.getTargetException();
                	throw new ConnectorExecutionException(_cee);
                }
            }
            BradescoFacesUtils.addErrorModalMessage(e.getMessage());
        } catch (Throwable t) {
        	BradescoFacesUtils.addErrorModalMessage(t.getMessage());
        }
        return results;
    }
	
}
