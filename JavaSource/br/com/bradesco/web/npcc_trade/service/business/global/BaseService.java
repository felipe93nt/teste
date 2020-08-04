/**
 *
 * Nome: BaseService.java
 * 
 * Propósito: Fornecer atributos e metodos base para todos os service.
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 30/09/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.global;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.IConnectorAWB;
import br.com.bradesco.data.connector.baseconnector.exception.CTGServiceException;
import br.com.bradesco.web.aq.application.pagination.PaginationAPI;
import br.com.bradesco.web.aq.application.pagination.PaginationRequest;
import br.com.bradesco.web.aq.application.pagination.PaginationResponse;
import br.com.bradesco.web.aq.application.pagination.cws.CWSPaginationAPIAdapterImpl;
import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.aq.application.pagination.exception.PaginationAPIException;
import br.com.bradesco.web.aq.application.pagination.factory.PaginationAPIFactory;
import br.com.bradesco.web.aq.application.session.bean.AWBPaginationDataState;
import br.com.bradesco.web.aq.application.session.bean.AWBPaginationSessionState;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.web.npcc_trade.service.business.NpccTradeServiceBusinessException;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 *
 * Nome: BaseService.java Propósito:
 * <p>
 * Fornecer atributos e metodos base para todos os service.
 * </p>
 *
 * @author : BRQ <BR>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 30/09/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public abstract class BaseService {

    /**
     * Constante resouce cws
     */
    private final String RESOUCE = "cws";

    /**
     * Messagem de retorno do fluxo mainframe
     */
    private String msgRetorno = null;

    /**
     * Atributo adapter cws.
     */
    @Inject
    @Named("CWSBusinessServiceBaseConnector")
    private CWSBusinessServiceBaseConnector adapterCWS = null;

    /** Atributo connector awb. */
    @Inject
    private IConnectorAWB connectorAWB;

    /**
     * Nome: listaComPaginacao
     * 
     * Propósito: Executa transação com paginação
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @param transactionName
     *            the transaction name
     * @param alias
     *            the alias
     * @throws NpccTradeServiceBusinessException
     *             the business exception
     * @see
     */
    public void listaComPaginacao(FRWKGL01Request request, FRWKGL01Response pResponse, String transactionName,
            String alias) throws NpccTradeException {
        try {
            // Executa transação
            getAdapterCWS().involkeProcessFromNC(request, pResponse, transactionName, RESOUCE, alias);
        } catch (CTGServiceException e) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  alias + " !!!!! ERROR !!!!! " + e.getErrorCode() + " - " + e.getErrorMessage()  + " XXXXXXXXXXXXXX");
            throw new NpccTradeWebException(e.getErrorMessage(), e, SiteUtil.STRING_EMPTY);
        } catch (Throwable t) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  alias + " !!!!! ERROR !!!!! " + t.getMessage()  + " XXXXXXXXXXXXXX");
            throw new NpccTradeException(t.getMessage(), t);
        }
    }

    /**
     * Nome: listaSemPaginacao
     * 
     * Propósito: Executa transação sem paginação
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @param transactionName
     *            the transaction name
     * @throws NpccTradeServiceBusinessException
     *             the business exception
     * @see
     */
    public void listaSemPaginacao(FRWKGL01Request request, FRWKGL01Response pResponse, String transactionName)
            throws NpccTradeException {
        try {
            // Executa transação
            getAdapterCWS().involkeProcessFromNC(request, pResponse, transactionName);
        } catch (CTGServiceException e) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " !!!!! ERROR !!!!! " + e.getErrorCode() + " - " + e.getErrorMessage() + " XXXXXXXXXXXXXX");
            throw new NpccTradeWebException(e.getErrorMessage(), e, SiteUtil.STRING_EMPTY);
        } catch (Throwable t) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " !!!!! ERROR !!!!! " + t.getMessage()  + " XXXXXXXXXXXXXX");
            throw new NpccTradeException(t.getMessage(), t);
        }
    }

    /**
     * Método construtor da classe.
     */
    public BaseService() {
        super();
    }
    
    /**
     * Nome: autoPaginate
     * 
     * Propósito: Realizar a auto paginação de listas
     *
     * @param : TRequest request, TResponse response, String transactionName
     * @return : List<TResponse>
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    protected <TRequest, TResponse> List<TResponse> autoPaginate(TRequest request, TResponse response, String transactionName) {
        String stateID = UUID.randomUUID().toString().toUpperCase();
        
        return autoPaginate(request, response, transactionName, stateID);
    }
    
    @SuppressWarnings("unchecked")
    protected <TRequest, TResponse> List<TResponse> autoPaginate(TRequest request, TResponse response, String transactionName, String stateID) {
        List<TResponse> results = new ArrayList<TResponse>();
        boolean init = false;
        boolean hasMoreData = false;
        
        try {
            Class<TResponse> responseClass = (Class<TResponse>) response.getClass();
            Field[] fields = responseClass.getDeclaredFields();
            Field outputBook = null;
            
            // Percorre todos os campos até encontrar o bloco de transação
            for (int i = 0; i < fields.length; i++) {
                Adapter annotation = fields[i].getAnnotation(Adapter.class);
                
                // Verifica se é o campo referente ao bloco de transação
                if (annotation != null && annotation.isTransactionBlock()) {
                    outputBook = fields[i];
                    
                    break;
                }
            }
            
            String methodName = outputBook.getName();
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
                                new CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector>(getAdapterCWS());
                PaginationAPI paginationAPI = PaginationAPIFactory.getInstance().getAPI(RESOUCE, apiAdapter, params);
            
                PaginationRequest<TRequest> paginationRequest = new PaginationRequest<TRequest>(request);
                PaginationResponse<TResponse> paginationResponse = new PaginationResponse<TResponse>();

                // Verifica se o processo já foi iniciado
                if (!init) {
                    init = true;
                    paginationResponse = paginationAPI.init(paginationRequest);
                    AWBPaginationSessionState.setAWBPaginationDataState("cws", stateID, new AWBPaginationDataState());
                } else {
                    paginationResponse = paginationAPI.next(paginationRequest);
                }

                //atualiza a flag que informa se tem mais dados para frente (a direita)
                hasMoreData = paginationResponse.isHasMoreDataRight();
                results.add(paginationResponse.getResponse());
                
            } while (hasMoreData);
            
        } catch (NoSuchMethodException e) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  stateID + " !!!!! ERROR !!!!! " + e.getMessage()  + " XXXXXXXXXXXXXX");
            results = new ArrayList<TResponse>();
        } catch (SecurityException e) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  stateID + " !!!!! ERROR !!!!! " + e.getMessage()  + " XXXXXXXXXXXXXX");
            results = new ArrayList<TResponse>();
        } catch (InstantiationException e) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  stateID + " !!!!! ERROR !!!!! " + e.getMessage()  + " XXXXXXXXXXXXXX");
            results = new ArrayList<TResponse>();
        } catch (IllegalAccessException e) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  stateID + " !!!!! ERROR !!!!! " + e.getMessage()  + " XXXXXXXXXXXXXX");
            results = new ArrayList<TResponse>();
        } catch (PaginationAPIException e) {            
        	
            // Verifica se a causa da exception é do tipo CTGServiceException
            if (e.getCause() instanceof InvocationTargetException) {
                InvocationTargetException invocationTargetException = (InvocationTargetException) e.getCause();
                
                // Verifica se é uma exceção do tipo CTGServiceException para obter o código de retorno e mensagem correta
                if (invocationTargetException.getTargetException() instanceof CTGServiceException) {
                    CTGServiceException ctgServiceException = (CTGServiceException) invocationTargetException
                            .getTargetException();
                    
                    BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  stateID + " !!!!! ERROR !!!!! " + ctgServiceException.getErrorMessage()  + " XXXXXXXXXXXXXX");
                    throw new NpccTradeException(ctgServiceException.getErrorMessage(), ctgServiceException,
                            SiteUtil.STRING_EMPTY);
                }
            }
            
            BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  stateID + " !!!!! ERROR !!!!! " + e.getMessage()  + " XXXXXXXXXXXXXX");
            throw new NpccTradeException(e.getMessage(), e, SiteUtil.STRING_EMPTY);
        } catch (Throwable t) {
        	BradescoCommonServiceFactory.getLogManager().info("           XXXXXXXXXXXXXX  " + transactionName + " <-> " +  stateID + " !!!!! ERROR !!!!! " + t.getMessage()  + " XXXXXXXXXXXXXX");
            throw new NpccTradeException(t.getMessage(), t);
        }
        
        return results;
    }

    /**
     * @return the msgRetorno
     */
    public String getMsgRetorno() {
        return msgRetorno;
    }

    /**
     * @param msgRetorno
     *            the msgRetorno to set
     */
    public void setMsgRetorno(String msgRetorno) {
        this.msgRetorno = msgRetorno;
    }

    /**
     * @return o valor do adapterCWS
     */
    public CWSBusinessServiceBaseConnector getAdapterCWS() {
        return adapterCWS;
    }

    /**
     * @param adapterCWS
     *            seta o novo valor para o campo adapterCWS
     */
    public void setAdapterCWS(CWSBusinessServiceBaseConnector adapterCWS) {
        this.adapterCWS = adapterCWS;
    }

    /**
     * @return o valor do connectorAWB
     */
    public IConnectorAWB getConnectorAWB() {
        return connectorAWB;
    }

    /**
     * @param connectorAWB
     *            seta o novo valor para o campo connectorAWB
     */
    public void setConnectorAWB(IConnectorAWB connectorAWB) {
        this.connectorAWB = connectorAWB;
    }

}
