package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/12/16 11:33
 */
public class Responsaveldespesasresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyasresponse npccwyasresponse = null;
	
	public void setNpccwyasresponse(Npccwyasresponse npccwyasresponse) {
		this.npccwyasresponse = npccwyasresponse;
	}


	public Npccwyasresponse getNpccwyasresponse() {
		return npccwyasresponse;
	}
    
}