package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:25
 */
public class Comissaoexternadetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxksresponse npccwxksresponse = null;
	
	public void setNpccwxksresponse(Npccwxksresponse npccwxksresponse) {
		this.npccwxksresponse = npccwxksresponse;
	}


	public Npccwxksresponse getNpccwxksresponse() {
		return npccwxksresponse;
	}
    
}