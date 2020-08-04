package br.com.bradesco.web.npcc_trade.service.business.autenticacao;

import java.util.Date;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.FWOSessionClass;
import br.com.bradesco.data.connector.IAuthenticationServiceAWBAdapter;
import br.com.bradesco.data.connector.baseconnector.BusinessServiceBaseConnector;
import br.com.bradesco.data.connector.baseconnector.exception.CTGServiceException;
import br.com.bradesco.data.connector.exception.ConnectorException;
import br.com.bradesco.web.aq.application.adapter.sso.sharedata.AdapterSSOUtils;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon.GSEGGLAERequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon.GSEGGLAFResponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon.LogonRequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon.LogonResponse;

/**
*
* Nome: AuthenticationServiceAWBAdapterImpl.java
* Propósito: <p> </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 20/08/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
public class AuthenticationServiceAWBAdapterImpl extends BusinessServiceBaseConnector implements 
IAuthenticationServiceAWBAdapter {

	private GSEGGLAERequest gsegglaeRequest;
	private GSEGGLAFResponse gsegglafResponse; 

	private LogonRequest logonRequest;
    private LogonResponse logonResponse;

    public void efetuarLogin(String usuario, String senha) throws ConnectorException {
        
    	Date date = new Date();
		
		String sTime = Long.toString(date.getTime());
		int timeLength = sTime.length();
		String ctl = sTime.substring(timeLength - 4, timeLength);
		
		AdapterSSOUtils.setShareDataKey(ctl);	
        //Preparando request
		
		gsegglaeRequest = new GSEGGLAERequest();
		gsegglafResponse = new GSEGGLAFResponse();
		logonRequest = new LogonRequest();
		logonResponse = new LogonResponse();
		
        gsegglaeRequest.setPswdatual(senha);
        gsegglaeRequest.setIdtpauten("006");
        gsegglaeRequest.setIndatlzpsw("N");

        logonRequest.getFRWKParameter().setUsuario(usuario);
        logonRequest.getFRWKParameter().setLoginTransaction(true);
        logonRequest.setGsegglaeRequest(gsegglaeRequest);
        logonResponse.setGsegglafResponse(gsegglafResponse);
        try {
        	 logonNC(logonRequest, logonResponse, "LOGON", FWOSessionClass.MAIN_SESSION);
        } catch (CTGServiceException e) {
            throw new ConnectorException(e.getMessage(), e, e.getErrorCode(),
                    e.getErrorMessage());
		}
    
    }

	@Override
	public void involkeProcessFromNC(AnnotatedAdapter request,
			AnnotatedAdapter response, String transactionName, String resource,
			String alias) throws CTGServiceException {

			throw new   UnsupportedOperationException("Essa operação não é suportada para o serviço de Longon NC");
	}

    /**
     * @return o valor do gsegglaeRequest
     */
    public GSEGGLAERequest getGsegglaeRequest() {
        return gsegglaeRequest;
    }

    /**
     * @param gsegglaeRequest seta o novo valor para o campo gsegglaeRequest
     */
    public void setGsegglaeRequest(GSEGGLAERequest gsegglaeRequest) {
        this.gsegglaeRequest = gsegglaeRequest;
    }

    /**
     * @return o valor do gsegglafResponse
     */
    public GSEGGLAFResponse getGsegglafResponse() {
        return gsegglafResponse;
    }

    /**
     * @param gsegglafResponse seta o novo valor para o campo gsegglafResponse
     */
    public void setGsegglafResponse(GSEGGLAFResponse gsegglafResponse) {
        this.gsegglafResponse = gsegglafResponse;
    }

    /**
     * @return o valor do logonRequest
     */
    public LogonRequest getLogonRequest() {
        return logonRequest;
    }

    /**
     * @param logonRequest seta o novo valor para o campo logonRequest
     */
    public void setLogonRequest(LogonRequest logonRequest) {
        this.logonRequest = logonRequest;
    }

    /**
     * @return o valor do logonResponse
     */
    public LogonResponse getLogonResponse() {
        return logonResponse;
    }

    /**
     * @param logonResponse seta o novo valor para o campo logonResponse
     */
    public void setLogonResponse(LogonResponse logonResponse) {
        this.logonResponse = logonResponse;
    }

	
}
