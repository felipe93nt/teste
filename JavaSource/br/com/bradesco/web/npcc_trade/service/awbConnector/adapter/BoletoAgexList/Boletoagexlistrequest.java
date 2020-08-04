package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 12:15
 */
public class Boletoagexlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwn2erequest npccwn2erequest = null;
	
	public void setNpccwn2erequest(Npccwn2erequest npccwn2erequest) {
		this.npccwn2erequest = npccwn2erequest;
	}


	public Npccwn2erequest getNpccwn2erequest() {
		return npccwn2erequest;
	}
    
}