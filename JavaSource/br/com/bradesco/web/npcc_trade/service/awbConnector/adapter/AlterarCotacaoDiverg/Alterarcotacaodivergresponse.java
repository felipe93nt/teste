package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarCotacaoDiverg;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/01/17 10:55
 */
public class Alterarcotacaodivergresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzwsresponse npccwzwsresponse = null;
	
	public void setNpccwzwsresponse(Npccwzwsresponse npccwzwsresponse) {
		this.npccwzwsresponse = npccwzwsresponse;
	}


	public Npccwzwsresponse getNpccwzwsresponse() {
		return npccwzwsresponse;
	}
    
}