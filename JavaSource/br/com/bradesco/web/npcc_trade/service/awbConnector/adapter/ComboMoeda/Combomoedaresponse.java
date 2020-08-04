package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 18:35
 */
public class Combomoedaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwazsresponse npcdwazsresponse = null;
	
	public void setNpcdwazsresponse(Npcdwazsresponse npcdwazsresponse) {
		this.npcdwazsresponse = npcdwazsresponse;
	}


	public Npcdwazsresponse getNpcdwazsresponse() {
		return npcdwazsresponse;
	}
    
}