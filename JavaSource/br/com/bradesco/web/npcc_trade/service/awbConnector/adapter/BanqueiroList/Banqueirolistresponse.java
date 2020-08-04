package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/09/18 14:36
 */
public class Banqueirolistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwfgsresponse npcdwfgsresponse = null;
	
	public void setNpcdwfgsresponse(Npcdwfgsresponse npcdwfgsresponse) {
		this.npcdwfgsresponse = npcdwfgsresponse;
	}


	public Npcdwfgsresponse getNpcdwfgsresponse() {
		return npcdwfgsresponse;
	}
    
}