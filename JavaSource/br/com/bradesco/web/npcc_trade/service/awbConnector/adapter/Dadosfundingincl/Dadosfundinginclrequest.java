package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 14:05
 */
public class Dadosfundinginclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwyerequest npccwwyerequest = null;
	
	public void setNpccwwyerequest(Npccwwyerequest npccwwyerequest) {
		this.npccwwyerequest = npccwwyerequest;
	}


	public Npccwwyerequest getNpccwwyerequest() {
		return npccwwyerequest;
	}
    
}