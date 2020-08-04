package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/03/20 15:27
 */
public class Operadormodallistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvuerequest npccwvuerequest = null;
	
	public void setNpccwvuerequest(Npccwvuerequest npccwvuerequest) {
		this.npccwvuerequest = npccwvuerequest;
	}


	public Npccwvuerequest getNpccwvuerequest() {
		return npccwvuerequest;
	}
    
}