package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/16 17:03
 */
public class Motivoperdalistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwcrerequest npccwcrerequest = null;
	
	public void setNpccwcrerequest(Npccwcrerequest npccwcrerequest) {
		this.npccwcrerequest = npccwcrerequest;
	}


	public Npccwcrerequest getNpccwcrerequest() {
		return npccwcrerequest;
	}
    
}