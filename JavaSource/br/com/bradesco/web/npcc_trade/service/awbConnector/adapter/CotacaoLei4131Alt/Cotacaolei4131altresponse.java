package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Alt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 14:52
 */
public class Cotacaolei4131altresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww9sresponse npccww9sresponse = null;
	
	public void setNpccww9sresponse(Npccww9sresponse npccww9sresponse) {
		this.npccww9sresponse = npccww9sresponse;
	}


	public Npccww9sresponse getNpccww9sresponse() {
		return npccww9sresponse;
	}
    
}