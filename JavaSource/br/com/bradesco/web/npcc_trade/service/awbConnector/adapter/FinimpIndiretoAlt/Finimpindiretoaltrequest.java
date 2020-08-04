package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 11:53
 */
public class Finimpindiretoaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwderequest npccwwderequest = null;
	
	public void setNpccwwderequest(Npccwwderequest npccwwderequest) {
		this.npccwwderequest = npccwwderequest;
	}


	public Npccwwderequest getNpccwwderequest() {
		return npccwwderequest;
	}
    
}