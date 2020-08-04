package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/12/15 09:52
 */
public class Prazostandbyaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvzerequest npccwvzerequest = null;
	
	public void setNpccwvzerequest(Npccwvzerequest npccwvzerequest) {
		this.npccwvzerequest = npccwvzerequest;
	}


	public Npccwvzerequest getNpccwvzerequest() {
		return npccwvzerequest;
	}
    
}