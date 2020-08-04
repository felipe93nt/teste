package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/07/16 10:46
 */
public class Paisdetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwaysresponse npcdwaysresponse = null;
	
	public void setNpcdwaysresponse(Npcdwaysresponse npcdwaysresponse) {
		this.npcdwaysresponse = npcdwaysresponse;
	}


	public Npcdwaysresponse getNpcdwaysresponse() {
		return npcdwaysresponse;
	}
    
}