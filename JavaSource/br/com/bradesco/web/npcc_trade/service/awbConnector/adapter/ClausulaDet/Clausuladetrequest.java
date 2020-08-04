package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/12/15 13:40
 */
public class Clausuladetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvierequest npccwvierequest = null;
	
	public void setNpccwvierequest(Npccwvierequest npccwvierequest) {
		this.npccwvierequest = npccwvierequest;
	}


	public Npccwvierequest getNpccwvierequest() {
		return npccwvierequest;
	}
    
}