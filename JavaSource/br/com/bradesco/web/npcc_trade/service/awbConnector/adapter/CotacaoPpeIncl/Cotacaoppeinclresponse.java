package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/17 15:46
 */
public class Cotacaoppeinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv9sresponse npccwv9sresponse = null;
	
	public void setNpccwv9sresponse(Npccwv9sresponse npccwv9sresponse) {
		this.npccwv9sresponse = npccwv9sresponse;
	}


	public Npccwv9sresponse getNpccwv9sresponse() {
		return npccwv9sresponse;
	}
    
}