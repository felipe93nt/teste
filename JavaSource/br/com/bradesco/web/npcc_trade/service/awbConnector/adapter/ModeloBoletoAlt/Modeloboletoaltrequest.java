package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/06/18 13:32
 */
public class Modeloboletoaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvperequest npccwvperequest = null;
	
	public void setNpccwvperequest(Npccwvperequest npccwvperequest) {
		this.npccwvperequest = npccwvperequest;
	}


	public Npccwvperequest getNpccwvperequest() {
		return npccwvperequest;
	}
    
}