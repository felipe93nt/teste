package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/03/17 15:10
 */
public class Cotacforfaitinginclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv5erequest npccwv5erequest = null;
	
	public void setNpccwv5erequest(Npccwv5erequest npccwv5erequest) {
		this.npccwv5erequest = npccwv5erequest;
	}


	public Npccwv5erequest getNpccwv5erequest() {
		return npccwv5erequest;
	}
    
}