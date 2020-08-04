package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConfirmaFormalizacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:13
 */
public class Confirmaformalizacaoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwkjsresponse npccwkjsresponse = null;
	
	public void setNpccwkjsresponse(Npccwkjsresponse npccwkjsresponse) {
		this.npccwkjsresponse = npccwkjsresponse;
	}


	public Npccwkjsresponse getNpccwkjsresponse() {
		return npccwkjsresponse;
	}
    
}