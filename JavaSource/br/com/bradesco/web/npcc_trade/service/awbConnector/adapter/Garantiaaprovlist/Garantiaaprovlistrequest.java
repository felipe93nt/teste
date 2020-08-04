package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/09/18 19:00
 */
public class Garantiaaprovlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwjperequest npccwjperequest = null;
	
	public void setNpccwjperequest(Npccwjperequest npccwjperequest) {
		this.npccwjperequest = npccwjperequest;
	}


	public Npccwjperequest getNpccwjperequest() {
		return npccwjperequest;
	}
    
}