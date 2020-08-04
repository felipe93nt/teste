package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MotivoPerdaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/16 17:03
 */
public class Motivoperdalistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwcrsresponse npccwcrsresponse = null;
	
	public void setNpccwcrsresponse(Npccwcrsresponse npccwcrsresponse) {
		this.npccwcrsresponse = npccwcrsresponse;
	}


	public Npccwcrsresponse getNpccwcrsresponse() {
		return npccwcrsresponse;
	}
    
}