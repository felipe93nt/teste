package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/07/16 10:46
 */
public class Paisdetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwayerequest npcdwayerequest = null;
	
	public void setNpcdwayerequest(Npcdwayerequest npcdwayerequest) {
		this.npcdwayerequest = npcdwayerequest;
	}


	public Npcdwayerequest getNpcdwayerequest() {
		return npcdwayerequest;
	}
    
}