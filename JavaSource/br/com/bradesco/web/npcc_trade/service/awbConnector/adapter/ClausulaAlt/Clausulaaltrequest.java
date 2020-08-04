package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 15:14
 */
public class Clausulaaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvjerequest npccwvjerequest = null;
	
	public void setNpccwvjerequest(Npccwvjerequest npccwvjerequest) {
		this.npccwvjerequest = npccwvjerequest;
	}


	public Npccwvjerequest getNpccwvjerequest() {
		return npccwvjerequest;
	}
    
}