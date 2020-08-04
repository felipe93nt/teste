package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/12/15 10:25
 */
public class Clausulainclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvherequest npccwvherequest = null;
	
	public void setNpccwvherequest(Npccwvherequest npccwvherequest) {
		this.npccwvherequest = npccwvherequest;
	}


	public Npccwvherequest getNpccwvherequest() {
		return npccwvherequest;
	}
    
}