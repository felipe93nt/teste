package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 11:16
 */
public class Garantiaavalistaincrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwk9erequest npccwk9erequest = null;
	
	public void setNpccwk9erequest(Npccwk9erequest npccwk9erequest) {
		this.npccwk9erequest = npccwk9erequest;
	}


	public Npccwk9erequest getNpccwk9erequest() {
		return npccwk9erequest;
	}
    
}