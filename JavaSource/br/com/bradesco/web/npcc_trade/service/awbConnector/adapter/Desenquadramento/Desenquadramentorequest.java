package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Desenquadramentorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwmnerequest npccwmnerequest = null;
	
	public void setNpccwmnerequest(Npccwmnerequest npccwmnerequest) {
		this.npccwmnerequest = npccwmnerequest;
	}


	public Npccwmnerequest getNpccwmnerequest() {
		return npccwmnerequest;
	}
    
}