package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:50
 */
public class Fndrflxpgtcmssinaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxnerequest npccwxnerequest = null;
	
	public void setNpccwxnerequest(Npccwxnerequest npccwxnerequest) {
		this.npccwxnerequest = npccwxnerequest;
	}


	public Npccwxnerequest getNpccwxnerequest() {
		return npccwxnerequest;
	}
    
}