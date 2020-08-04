package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/09/16 11:12
 */
public class Consopersiclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww2sresponse npccww2sresponse = null;
	
	public void setNpccww2sresponse(Npccww2sresponse npccww2sresponse) {
		this.npccww2sresponse = npccww2sresponse;
	}


	public Npccww2sresponse getNpccww2sresponse() {
		return npccww2sresponse;
	}
    
}