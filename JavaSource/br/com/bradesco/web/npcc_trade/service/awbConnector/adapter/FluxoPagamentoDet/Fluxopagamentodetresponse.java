package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/08/16 14:53
 */
public class Fluxopagamentodetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxdsresponse npccwxdsresponse = null;
	
	public void setNpccwxdsresponse(Npccwxdsresponse npccwxdsresponse) {
		this.npccwxdsresponse = npccwxdsresponse;
	}


	public Npccwxdsresponse getNpccwxdsresponse() {
		return npccwxdsresponse;
	}
    
}