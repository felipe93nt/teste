package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 20:56
 */
public class Fluxopagamentolistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxcsresponse npccwxcsresponse = null;
	
	public void setNpccwxcsresponse(Npccwxcsresponse npccwxcsresponse) {
		this.npccwxcsresponse = npccwxcsresponse;
	}


	public Npccwxcsresponse getNpccwxcsresponse() {
		return npccwxcsresponse;
	}
    
}