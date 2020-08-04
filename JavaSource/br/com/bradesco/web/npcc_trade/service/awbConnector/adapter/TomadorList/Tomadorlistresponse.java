package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/05/16 11:24
 */
public class Tomadorlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwo9sresponse npccwo9sresponse = null;
	
	public void setNpccwo9sresponse(Npccwo9sresponse npccwo9sresponse) {
		this.npccwo9sresponse = npccwo9sresponse;
	}


	public Npccwo9sresponse getNpccwo9sresponse() {
		return npccwo9sresponse;
	}
    
}