/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.business
 * 
 * Propósito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Criação: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Parâmetros de Compilação: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.business.conectores;

import java.util.Map;

import javax.inject.Inject;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.ConnectorGateway;
import br.com.bradesco.data.connector.ConnectorSession;
import br.com.bradesco.data.connector.FRWKConstants;
import br.com.bradesco.data.connector.FWOSessionClass;
import br.com.bradesco.data.connector.IConnectorAWB;
import br.com.bradesco.data.connector.XMLTransactionRepository;
import br.com.bradesco.data.connector.exception.ConnectorBusinessException;
import br.com.bradesco.data.connector.exception.ConnectorException;
import br.com.bradesco.data.message.TransactionMessage;
import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.GenericoRequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.GenericoResponse;
import br.com.bradesco.web.npcc_trade.service.business.NpccTradeServiceBusinessException;

/**
 * Nome: BusinessServiceBaseConnector
 * Propósito: Classe base para execucao do servico
 * Equipe: AWB Conectores
 * Parametro de compilação: -d.
 *
 * @author william.santos CPM Braxis Copyright (c) 2011
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 * <p>Registro de Manutenção:
 * <li>Data : </li>
 * <li>Autor: </li>
 * <li>Responsável: </li>
 * </p>
 */
public abstract class BusinessServiceBaseConnector {
	
	/**
	 * Construtor Padrão
	 * Instancia um novo objeto BusinessServiceBaseConnector.
	 */
	public BusinessServiceBaseConnector() {
		super();
	}
	
	/** Nome:. @see Contém a instância do gerenciador de Log. */
	private ILogManager logManager;
	
	/** Atributo connector awb. */
	@Inject
	private IConnectorAWB connectorAWB;
	
	/**
	 * Nome:.
	 *
	 * @return Retorna o valor do campo 'logManager'.
	 * @see
	 */
	public ILogManager getLogManager() {
		return logManager;
	}
	
	/**
	 * Nome:.
	 *
	 * @param logManagerArg - Determina o valor do campo 'logManager'.
	 * @see
	 */
	public void setLogManager(ILogManager logManagerArg) {
		this.logManager = logManagerArg;
	}
	
	/**
	 * Nome: connectorExecuteGenerico
	 * Connector execute generico.
	 *
	 * @param commareaEntrada the commarea entrada
	 * @param nomeTransacao the nome transacao
	 * @return string
	 * @see
	 */
	public String connectorExecuteGenerico(String commareaEntrada, String nomeTransacao) {
		
		GenericoRequest request = new GenericoRequest();
		GenericoResponse response = new GenericoResponse();
		
		try {
			//request.setDadosTransacao(formataTamanho(commareaEntrada, 2000));
			request.setDadosTransacao(commareaEntrada);
			request.setLogManager(logManager);
			TransactionMessage message = request.toTransactionMessage();
			message.setName(nomeTransacao);
			message.setTransacaoGenerica(true);
			message.getRequestOptions().put(FRWKConstants.PARAM_SESSION, FWOSessionClass.MAIN_SESSION);
			int tamanho = Integer.parseInt(commareaEntrada.substring(8, 13));
			tamanho += 230; // tamanho do header do gseg
			message.getElement("FRWKGL01-REGISTRO").getElement("FRWKGL01-BLOCO-ENTR-SAID").getElement(
					"FRWKGL01-TAM-LAYOUT-RESTO").setValue(String.valueOf(tamanho));
			TransactionMessage tmResponse = connectorAWB.executeTransaction(message);
			response.setResource(connectorAWB.getResource());
			response.fromTransactionMessage(tmResponse);
			response.setLogManager(logManager);
			return response.getDadosTransacao();
		} catch (ConnectorBusinessException cbe) {
			throw new NpccTradeException(cbe.getMessage(), cbe);
		} catch (ConnectorException e) {
			throw new NpccTradeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Nome: connectorExecute
	 * Connector execute.
	 *
	 * @param request the request
	 * @param response the response
	 * @param transactionName the transaction name
	 * @throws ServiceException the service exception
	 * @see
	 */
	public void connectorExecute(AnnotatedAdapter request, AnnotatedAdapter response, String transactionName)
			throws NpccTradeException {
		this.connectorExecuteParalel(request, response, transactionName, FWOSessionClass.MAIN_SESSION);
	}
	
	/**
	 * Nome: connectorExecuteParalel
	 * Connector execute paralel.
	 *
	 * @param request the request
	 * @param response the response
	 * @param transactionName the transaction name
	 * @param alias the alias
	 * @throws ServiceException the service exception
	 * @see
	 */
	public void connectorExecuteParalel(AnnotatedAdapter request, AnnotatedAdapter response, String transactionName,
			String alias) throws NpccTradeException {
	    
		try {
		    
			// Preparando requisicao
			TransactionMessage message = request.gerarTransactionMessage();
			message.setName(transactionName);
			message.getRequestOptions().put(FRWKConstants.PARAM_SESSION, alias);
			
			// Executa requisicao
			TransactionMessage tmResponse = connectorAWB.executeTransaction(message);
			
			// Trata retorno
			response.setResource(connectorAWB.getResource());
			response.tratarTransactionMessage(tmResponse);
			
		} catch (ConnectorBusinessException cbe) {
			throw new NpccTradeServiceBusinessException(cbe.getMessage(), cbe);
		} catch (ConnectorException e) {
		    throw new NpccTradeWebException(e.getMessage(), e, e.getCode());
		} catch (Throwable t) {
		    throw new NpccTradeException(t.getMessage(), t);
		}
	}
	
	/**
     * Nome: connectorExecute
     * Connector execute.
     *
     * @param request the request
     * @param response the response
     * @param transactionName the transaction name
     * @throws ServiceException the service exception
     * @see
     */
    public void connectorExecuteManut(AnnotatedAdapter request, AnnotatedAdapter response, String transactionName)
            throws NpccTradeException {
        this.connectorExecuteManut(request, response, transactionName, FWOSessionClass.MAIN_SESSION);
    }
    
    /**
     * Nome: connectorExecuteParalel
     * Connector execute paralel.
     *
     * @param request the request
     * @param response the response
     * @param transactionName the transaction name
     * @param alias the alias
     * @throws ServiceException the service exception
     * @see
     */
    public void connectorExecuteManut(AnnotatedAdapter request, AnnotatedAdapter response, String transactionName,
            String alias) throws NpccTradeException {
        try {
            // Preparando requisicao
            TransactionMessage message = request.gerarTransactionMessage();
            message.setName(transactionName);
            message.getRequestOptions().put(FRWKConstants.PARAM_SESSION, alias);
            
            // Exeuta requisicao
            TransactionMessage tmResponse = connectorAWB.executeTransaction(message);
            
            // Tratar retorno
            response.setResource(connectorAWB.getResource());
            response.fromTransactionMessage(tmResponse);
            
        } catch (ConnectorBusinessException cbe) {
            throw new NpccTradeServiceBusinessException(cbe.getMessage(), cbe);
        } catch (ConnectorException e) {
            throw new NpccTradeWebException(e.getMessage(), e, e.getCode());
        } catch (Throwable t) {
                throw new NpccTradeException(t.getMessage(), t);
        }
    }
	
	/**
	 * Nome: getConnectorAWB
	 * Recupera o valor do atributo 'connectorAWB'.
	 *
	 * @return valor do atributo 'connectorAWB'
	 * @see
	 */
	public IConnectorAWB getConnectorAWB() {
		return connectorAWB;
	}
	
	/**
	 * Nome: setConnectorAWB
	 * Registra o valor do atributo 'connectorAWB'.
	 *
	 * @param paramConnectorAWB valor do atributo connector awb
	 * @see
	 */
	public void setConnectorAWB(IConnectorAWB paramConnectorAWB) {
		connectorAWB = paramConnectorAWB;
	}
	
	/**
	 * Nome: getResource
	 * Recupera o valor do atributo 'resource'.
	 *
	 * @return valor do atributo 'resource'
	 * @see
	 */
	public XMLTransactionRepository getResource() {
		return this.connectorAWB.getResource();
	}
	
	/**
	 * Nome: setResource
	 * Registra o valor do atributo 'resource'.
	 *
	 * @param resource valor do atributo resource
	 * @see
	 */
	public void setResource(XMLTransactionRepository resource) {
		this.connectorAWB.setResource(resource);
	}
	
	/**
	 * Nome: setConnectors
	 * Sets the connectors.
	 *
	 * @param connectors the connectors
	 * @see
	 */
	public void setConnectors(Map<String, ConnectorGateway> connectors) {
		this.connectorAWB.setConnectors(connectors);
	}
	
	/**
	 * Nome: setConnectorSession
	 * Registra o valor do atributo 'connectorSession'.
	 *
	 * @param session valor do atributo connector session
	 * @see
	 */
	public void setConnectorSession(ConnectorSession session) {
		this.connectorAWB.setConnectorSession(session);
	}
	
	/**
	 * Nome: getConnectorSession
	 * Recupera o valor do atributo 'connectorSession'.
	 *
	 * @return valor do atributo 'connectorSession'
	 * @see
	 */
	public ConnectorSession getConnectorSession() {
		return this.connectorAWB.getConnectorSession();
	}
}
