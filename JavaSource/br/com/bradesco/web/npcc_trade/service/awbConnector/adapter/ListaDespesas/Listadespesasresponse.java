package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/10/16 09:54
 */
public class Listadespesasresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwybsresponse npccwybsresponse = null;
	
	public void setNpccwybsresponse(Npccwybsresponse npccwybsresponse) {
		this.npccwybsresponse = npccwybsresponse;
	}


	public Npccwybsresponse getNpccwybsresponse() {
		return npccwybsresponse;
	}
    
}