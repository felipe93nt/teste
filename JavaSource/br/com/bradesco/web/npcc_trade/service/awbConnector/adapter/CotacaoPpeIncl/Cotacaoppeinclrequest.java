package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/17 15:46
 */
public class Cotacaoppeinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv9erequest npccwv9erequest = null;
	
	public void setNpccwv9erequest(Npccwv9erequest npccwv9erequest) {
		this.npccwv9erequest = npccwv9erequest;
	}


	public Npccwv9erequest getNpccwv9erequest() {
		return npccwv9erequest;
	}
    
}