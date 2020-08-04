package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/12/15 09:52
 */
public class Prazostandbyaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvzsresponse npccwvzsresponse = null;
	
	public void setNpccwvzsresponse(Npccwvzsresponse npccwvzsresponse) {
		this.npccwvzsresponse = npccwvzsresponse;
	}


	public Npccwvzsresponse getNpccwvzsresponse() {
		return npccwvzsresponse;
	}
    
}