package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/09/16 09:55
 */
public class Conestcotfecperdlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzgerequest npccwzgerequest = null;
	
	public void setNpccwzgerequest(Npccwzgerequest npccwzgerequest) {
		this.npccwzgerequest = npccwzgerequest;
	}


	public Npccwzgerequest getNpccwzgerequest() {
		return npccwzgerequest;
	}
    
}