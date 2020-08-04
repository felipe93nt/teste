package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 16:40
 */
public class Fndrgrtvnctrfobsaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzxerequest npccwzxerequest = null;
	
	public void setNpccwzxerequest(Npccwzxerequest npccwzxerequest) {
		this.npccwzxerequest = npccwzxerequest;
	}


	public Npccwzxerequest getNpccwzxerequest() {
		return npccwzxerequest;
	}
    
}