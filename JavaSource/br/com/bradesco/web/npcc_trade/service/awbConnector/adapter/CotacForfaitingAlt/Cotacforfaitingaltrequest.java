package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/03/17 17:58
 */
public class Cotacforfaitingaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwweerequest npccwweerequest = null;
	
	public void setNpccwweerequest(Npccwweerequest npccwweerequest) {
		this.npccwweerequest = npccwweerequest;
	}


	public Npccwweerequest getNpccwweerequest() {
		return npccwweerequest;
	}
    
}