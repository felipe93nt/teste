package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:19
 */
public class Mercadoriaslistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxgerequest npccwxgerequest = null;
	
	public void setNpccwxgerequest(Npccwxgerequest npccwxgerequest) {
		this.npccwxgerequest = npccwxgerequest;
	}


	public Npccwxgerequest getNpccwxgerequest() {
		return npccwxgerequest;
	}
    
}