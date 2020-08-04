package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 13:33
 */
public class Fndrflxpgtcmssexinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwymerequest npccwymerequest = null;
	
	public void setNpccwymerequest(Npccwymerequest npccwymerequest) {
		this.npccwymerequest = npccwymerequest;
	}


	public Npccwymerequest getNpccwymerequest() {
		return npccwymerequest;
	}
    
}