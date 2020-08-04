package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 15:53
 */
public class Combopaisresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwa3sresponse npcdwa3sresponse = null;
	
	public void setNpcdwa3sresponse(Npcdwa3sresponse npcdwa3sresponse) {
		this.npcdwa3sresponse = npcdwa3sresponse;
	}


	public Npcdwa3sresponse getNpcdwa3sresponse() {
		return npcdwa3sresponse;
	}
    
}