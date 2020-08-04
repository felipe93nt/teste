package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarPerda;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:09
 */
public class Obterconfirmarperdaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxqsresponse npccwxqsresponse = null;
	
	public void setNpccwxqsresponse(Npccwxqsresponse npccwxqsresponse) {
		this.npccwxqsresponse = npccwxqsresponse;
	}


	public Npccwxqsresponse getNpccwxqsresponse() {
		return npccwxqsresponse;
	}
    
}