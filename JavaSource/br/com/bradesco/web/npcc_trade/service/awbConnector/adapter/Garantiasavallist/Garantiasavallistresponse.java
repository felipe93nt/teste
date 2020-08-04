package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/10/16 15:49
 */
public class Garantiasavallistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwjqsresponse npccwjqsresponse = null;
	
	public void setNpccwjqsresponse(Npccwjqsresponse npccwjqsresponse) {
		this.npccwjqsresponse = npccwjqsresponse;
	}


	public Npccwjqsresponse getNpccwjqsresponse() {
		return npccwjqsresponse;
	}
    
}