package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/02/16 14:44
 */
public class Comboprodutoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwiasresponse npccwiasresponse = null;
	
	public void setNpccwiasresponse(Npccwiasresponse npccwiasresponse) {
		this.npccwiasresponse = npccwiasresponse;
	}


	public Npccwiasresponse getNpccwiasresponse() {
		return npccwiasresponse;
	}
    
}