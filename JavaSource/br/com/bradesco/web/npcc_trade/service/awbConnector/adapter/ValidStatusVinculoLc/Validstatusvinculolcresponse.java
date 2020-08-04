package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/11/16 16:03
 */
public class Validstatusvinculolcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww4sresponse npccww4sresponse = null;
	
	public void setNpccww4sresponse(Npccww4sresponse npccww4sresponse) {
		this.npccww4sresponse = npccww4sresponse;
	}


	public Npccww4sresponse getNpccww4sresponse() {
		return npccww4sresponse;
	}
    
}