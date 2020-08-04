package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 11:58
 */
public class Cotacaoppealtrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwierequest npccwwierequest = null;
	
	public void setNpccwwierequest(Npccwwierequest npccwwierequest) {
		this.npccwwierequest = npccwwierequest;
	}


	public Npccwwierequest getNpccwwierequest() {
		return npccwwierequest;
	}
    
}