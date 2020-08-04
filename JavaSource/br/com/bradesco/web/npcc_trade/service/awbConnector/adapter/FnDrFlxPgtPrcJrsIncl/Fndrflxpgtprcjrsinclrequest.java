package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/02/16 19:22
 */
public class Fndrflxpgtprcjrsinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwykerequest npccwykerequest = null;
	
	public void setNpccwykerequest(Npccwykerequest npccwykerequest) {
		this.npccwykerequest = npccwykerequest;
	}


	public Npccwykerequest getNpccwykerequest() {
		return npccwykerequest;
	}
    
}