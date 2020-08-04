package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 15:14
 */
public class Clausulaaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvjsresponse npccwvjsresponse = null;
	
	public void setNpccwvjsresponse(Npccwvjsresponse npccwvjsresponse) {
		this.npccwvjsresponse = npccwvjsresponse;
	}


	public Npccwvjsresponse getNpccwvjsresponse() {
		return npccwvjsresponse;
	}
    
}