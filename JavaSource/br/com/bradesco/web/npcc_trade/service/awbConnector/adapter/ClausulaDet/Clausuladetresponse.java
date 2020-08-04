package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/12/15 13:40
 */
public class Clausuladetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvisresponse npccwvisresponse = null;
	
	public void setNpccwvisresponse(Npccwvisresponse npccwvisresponse) {
		this.npccwvisresponse = npccwvisresponse;
	}


	public Npccwvisresponse getNpccwvisresponse() {
		return npccwvisresponse;
	}
    
}