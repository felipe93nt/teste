package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:30
 */
public class Finimpdiretoaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwcsresponse npccwwcsresponse = null;
	
	public void setNpccwwcsresponse(Npccwwcsresponse npccwwcsresponse) {
		this.npccwwcsresponse = npccwwcsresponse;
	}


	public Npccwwcsresponse getNpccwwcsresponse() {
		return npccwwcsresponse;
	}
    
}