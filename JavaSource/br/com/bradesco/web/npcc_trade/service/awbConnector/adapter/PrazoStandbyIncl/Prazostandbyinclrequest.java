package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/12/15 14:30
 */
public class Prazostandbyinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvwerequest npccwvwerequest = null;
	
	public void setNpccwvwerequest(Npccwvwerequest npccwvwerequest) {
		this.npccwvwerequest = npccwvwerequest;
	}


	public Npccwvwerequest getNpccwvwerequest() {
		return npccwvwerequest;
	}
    
}