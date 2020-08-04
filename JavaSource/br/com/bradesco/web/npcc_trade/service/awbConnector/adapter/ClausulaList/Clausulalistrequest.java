package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/12/15 17:42
 */
public class Clausulalistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvgerequest npccwvgerequest = null;
	
	public void setNpccwvgerequest(Npccwvgerequest npccwvgerequest) {
		this.npccwvgerequest = npccwvgerequest;
	}


	public Npccwvgerequest getNpccwvgerequest() {
		return npccwvgerequest;
	}
    
}