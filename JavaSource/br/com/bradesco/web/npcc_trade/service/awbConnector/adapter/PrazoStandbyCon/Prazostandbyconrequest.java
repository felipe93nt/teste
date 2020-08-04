package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/12/15 09:36
 */
public class Prazostandbyconrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvyerequest npccwvyerequest = null;
	
	public void setNpccwvyerequest(Npccwvyerequest npccwvyerequest) {
		this.npccwvyerequest = npccwvyerequest;
	}


	public Npccwvyerequest getNpccwvyerequest() {
		return npccwvyerequest;
	}
    
}