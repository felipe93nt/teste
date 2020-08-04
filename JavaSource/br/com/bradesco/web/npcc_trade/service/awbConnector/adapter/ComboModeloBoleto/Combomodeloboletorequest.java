package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/12/15 15:27
 */
public class Combomodeloboletorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvterequest npccwvterequest = null;
	
	public void setNpccwvterequest(Npccwvterequest npccwvterequest) {
		this.npccwvterequest = npccwvterequest;
	}


	public Npccwvterequest getNpccwvterequest() {
		return npccwvterequest;
	}
    
}