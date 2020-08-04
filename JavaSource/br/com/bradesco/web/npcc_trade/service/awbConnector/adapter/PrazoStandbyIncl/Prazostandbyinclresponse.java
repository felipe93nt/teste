package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/12/15 14:30
 */
public class Prazostandbyinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvwsresponse npccwvwsresponse = null;
	
	public void setNpccwvwsresponse(Npccwvwsresponse npccwvwsresponse) {
		this.npccwvwsresponse = npccwvwsresponse;
	}


	public Npccwvwsresponse getNpccwvwsresponse() {
		return npccwvwsresponse;
	}
    
}