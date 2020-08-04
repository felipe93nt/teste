package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaExcl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 15:28
 */
public class Clausulaexclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvksresponse npccwvksresponse = null;
	
	public void setNpccwvksresponse(Npccwvksresponse npccwvksresponse) {
		this.npccwvksresponse = npccwvksresponse;
	}


	public Npccwvksresponse getNpccwvksresponse() {
		return npccwvksresponse;
	}
    
}