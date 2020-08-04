package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Dadosfundingincl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 14:05
 */
public class Dadosfundinginclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwysresponse npccwwysresponse = null;
	
	public void setNpccwwysresponse(Npccwwysresponse npccwwysresponse) {
		this.npccwwysresponse = npccwwysresponse;
	}


	public Npccwwysresponse getNpccwwysresponse() {
		return npccwwysresponse;
	}
    
}