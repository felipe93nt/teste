package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 18:08
 */
public class Listasituacaoboletoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwjxsresponse npccwjxsresponse = null;
	
	public void setNpccwjxsresponse(Npccwjxsresponse npccwjxsresponse) {
		this.npccwjxsresponse = npccwjxsresponse;
	}


	public Npccwjxsresponse getNpccwjxsresponse() {
		return npccwjxsresponse;
	}
    
}