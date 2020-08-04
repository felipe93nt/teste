package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/12/15 17:42
 */
public class Clausulalistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvgsresponse npccwvgsresponse = null;
	
	public void setNpccwvgsresponse(Npccwvgsresponse npccwvgsresponse) {
		this.npccwvgsresponse = npccwvgsresponse;
	}


	public Npccwvgsresponse getNpccwvgsresponse() {
		return npccwvgsresponse;
	}
    
}