package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/09/16 11:12
 */
public class Consopersiclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww2erequest npccww2erequest = null;
	
	public void setNpccww2erequest(Npccww2erequest npccww2erequest) {
		this.npccww2erequest = npccww2erequest;
	}


	public Npccww2erequest getNpccww2erequest() {
		return npccww2erequest;
	}
    
}