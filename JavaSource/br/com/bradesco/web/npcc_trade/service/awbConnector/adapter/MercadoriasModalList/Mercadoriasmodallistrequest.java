package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/12/15 12:13
 */
public class Mercadoriasmodallistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwnerequest npccwwnerequest = null;
	
	public void setNpccwwnerequest(Npccwwnerequest npccwwnerequest) {
		this.npccwwnerequest = npccwwnerequest;
	}


	public Npccwwnerequest getNpccwwnerequest() {
		return npccwwnerequest;
	}
    
}