package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 15:30
 */
public class Combopaisrestricaoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwpsresponse npccwwpsresponse = null;
	
	public void setNpccwwpsresponse(Npccwwpsresponse npccwwpsresponse) {
		this.npccwwpsresponse = npccwwpsresponse;
	}


	public Npccwwpsresponse getNpccwwpsresponse() {
		return npccwwpsresponse;
	}
    
}