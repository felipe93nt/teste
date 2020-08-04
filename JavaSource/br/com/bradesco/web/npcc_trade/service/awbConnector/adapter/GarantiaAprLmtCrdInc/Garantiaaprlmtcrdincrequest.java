package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/04/18 15:27
 */
public class Garantiaaprlmtcrdincrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwk7erequest npccwk7erequest = null;
	
	public void setNpccwk7erequest(Npccwk7erequest npccwk7erequest) {
		this.npccwk7erequest = npccwk7erequest;
	}


	public Npccwk7erequest getNpccwk7erequest() {
		return npccwk7erequest;
	}
    
}