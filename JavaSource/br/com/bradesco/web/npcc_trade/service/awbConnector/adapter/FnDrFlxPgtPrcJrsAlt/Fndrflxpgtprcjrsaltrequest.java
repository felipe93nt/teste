package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 15:23
 */
public class Fndrflxpgtprcjrsaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyferequest npccwyferequest = null;
	
	public void setNpccwyferequest(Npccwyferequest npccwyferequest) {
		this.npccwyferequest = npccwyferequest;
	}


	public Npccwyferequest getNpccwyferequest() {
		return npccwyferequest;
	}
    
}