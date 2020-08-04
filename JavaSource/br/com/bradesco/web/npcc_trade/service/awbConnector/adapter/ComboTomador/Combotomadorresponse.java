package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/05/16 17:35
 */
public class Combotomadorresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwtsresponse npccwwtsresponse = null;
	
	public void setNpccwwtsresponse(Npccwwtsresponse npccwwtsresponse) {
		this.npccwwtsresponse = npccwwtsresponse;
	}


	public Npccwwtsresponse getNpccwwtsresponse() {
		return npccwwtsresponse;
	}
    
}