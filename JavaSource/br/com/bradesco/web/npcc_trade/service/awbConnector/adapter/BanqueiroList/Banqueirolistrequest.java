package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/09/18 14:36
 */
public class Banqueirolistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwfgerequest npcdwfgerequest = null;
	
	public void setNpcdwfgerequest(Npcdwfgerequest npcdwfgerequest) {
		this.npcdwfgerequest = npcdwfgerequest;
	}


	public Npcdwfgerequest getNpcdwfgerequest() {
		return npcdwfgerequest;
	}
    
}