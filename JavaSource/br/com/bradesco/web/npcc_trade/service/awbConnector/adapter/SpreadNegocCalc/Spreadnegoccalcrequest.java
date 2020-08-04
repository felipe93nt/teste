package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/03/17 09:38
 */
public class Spreadnegoccalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxxerequest npccwxxerequest = null;
	
	public void setNpccwxxerequest(Npccwxxerequest npccwxxerequest) {
		this.npccwxxerequest = npccwxxerequest;
	}


	public Npccwxxerequest getNpccwxxerequest() {
		return npccwxxerequest;
	}
    
}