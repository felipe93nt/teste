package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaExcl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 15:28
 */
public class Clausulaexclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvkerequest npccwvkerequest = null;
	
	public void setNpccwvkerequest(Npccwvkerequest npccwvkerequest) {
		this.npccwvkerequest = npccwvkerequest;
	}


	public Npccwvkerequest getNpccwvkerequest() {
		return npccwvkerequest;
	}
    
}