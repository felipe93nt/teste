package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/11/16 16:03
 */
public class Validstatusvinculolcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww4erequest npccww4erequest = null;
	
	public void setNpccww4erequest(Npccww4erequest npccww4erequest) {
		this.npccww4erequest = npccww4erequest;
	}


	public Npccww4erequest getNpccww4erequest() {
		return npccww4erequest;
	}
    
}