package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 13:31
 */
public class Garantiaavalmtcredrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwk8erequest npccwk8erequest = null;
	
	public void setNpccwk8erequest(Npccwk8erequest npccwk8erequest) {
		this.npccwk8erequest = npccwk8erequest;
	}


	public Npccwk8erequest getNpccwk8erequest() {
		return npccwk8erequest;
	}
    
}