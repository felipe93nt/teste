package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/04/18 11:48
 */
public class Garantiaadiclistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwdgerequest npccwdgerequest = null;
	
	public void setNpccwdgerequest(Npccwdgerequest npccwdgerequest) {
		this.npccwdgerequest = npccwdgerequest;
	}


	public Npccwdgerequest getNpccwdgerequest() {
		return npccwdgerequest;
	}
    
}