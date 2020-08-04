package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:43
 */
public class Fndrflxpgtcmssexaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxserequest npccwxserequest = null;
	
	public void setNpccwxserequest(Npccwxserequest npccwxserequest) {
		this.npccwxserequest = npccwxserequest;
	}


	public Npccwxserequest getNpccwxserequest() {
		return npccwxserequest;
	}
    
}