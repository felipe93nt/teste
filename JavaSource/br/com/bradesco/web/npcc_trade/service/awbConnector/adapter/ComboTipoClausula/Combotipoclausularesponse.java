package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/01/16 16:05
 */
public class Combotipoclausularesponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvfsresponse npccwvfsresponse = null;
	
	public void setNpccwvfsresponse(Npccwvfsresponse npccwvfsresponse) {
		this.npccwvfsresponse = npccwvfsresponse;
	}


	public Npccwvfsresponse getNpccwvfsresponse() {
		return npccwvfsresponse;
	}
    
}