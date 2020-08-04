package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/07/16 16:42
 */
public class Przmedoperdesembcalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzperequest npccwzperequest = null;
	
	public void setNpccwzperequest(Npccwzperequest npccwzperequest) {
		this.npccwzperequest = npccwzperequest;
	}


	public Npccwzperequest getNpccwzperequest() {
		return npccwzperequest;
	}
    
}