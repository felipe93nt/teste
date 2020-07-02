package br.com.bradesco.web.ricc.service.business;

import java.util.Date;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.FWOSessionClass;
import br.com.bradesco.data.connector.IAuthenticationServiceAWBAdapter;
import br.com.bradesco.data.connector.baseconnector.BusinessServiceBaseConnector;
import br.com.bradesco.data.connector.exception.ConnectorException;
import br.com.bradesco.data.connector.exception.ConnectorExecutionException;
import br.com.bradesco.web.aq.application.adapter.sso.sharedata.AdapterSSOUtils;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.logon.GSEGGLAERequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.logon.GSEGGLAFResponse;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.logon.LogonRequest;
import br.com.bradesco.web.ricc.service.awbConnector.adapter.logon.LogonResponse;

@SuppressWarnings("rawtypes")
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
        } catch (ConnectorExecutionException e) {
			throw new RiccException(e.getMessage(), e);
		}

    }

	public GSEGGLAERequest getGsegglaeRequest() {
		return gsegglaeRequest;
	}

	public void setGsegglaeRequest(GSEGGLAERequest paramGsegglaeRequest) {
		gsegglaeRequest = paramGsegglaeRequest;
	}

	public GSEGGLAFResponse getGsegglafResponse() {
		return gsegglafResponse;
	}

	public void setGsegglafResponse(GSEGGLAFResponse paramGsegglafResponse) {
		gsegglafResponse = paramGsegglafResponse;
	}

    public LogonRequest getLogonRequest() {
        return logonRequest;
    }

    public void setLogonRequest(LogonRequest logonRequest) {
        this.logonRequest = logonRequest;
    }

    public LogonResponse getLogonResponse() {
        return logonResponse;
    }

    public void setLogonResponse(LogonResponse logonResponse) {
        this.logonResponse = logonResponse;
    }

	@Override
	public void invokeProcessFromNC(AnnotatedAdapter request, AnnotatedAdapter response, String transactionName,
		String resource, String stateID) throws ConnectorExecutionException {

		throw new UnsupportedOperationException("Essa operação não é suportada para o serviço de Longon NC");
	}

	/**
	 * Nome: involkeProcessFromNC <br/>
	 * Propósito: Metodo sobrescrito <br/>
	 *
	 * Data: <14/12/2015> <br/>
	 * @author abaratel / Capgemini <br/>
	 * copyright Copyright (c) 2015 <br/>
	 *
	 * @param request
	 * @param response
	 * @param transactionName
	 * @param resource
	 * @param stateID
	 * @throws ConnectorExecutionException
	 * @deprecated
	 * @see br.com.bradesco.data.connector.baseconnector.BusinessServiceBaseConnector#involkeProcessFromNC(br.com.bradesco.data.connector.AnnotatedAdapter, br.com.bradesco.data.connector.AnnotatedAdapter, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void involkeProcessFromNC(AnnotatedAdapter request, AnnotatedAdapter response, String transactionName,
		String resource, String stateID) throws ConnectorExecutionException {
		invokeProcessFromNC(request, response, transactionName, resource, stateID);
	}


}
