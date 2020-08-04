package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/04/18 15:27
 */
public class Garantiaaprlmtcrdincresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwk7sresponse npccwk7sresponse = null;
	
	public void setNpccwk7sresponse(Npccwk7sresponse npccwk7sresponse) {
		this.npccwk7sresponse = npccwk7sresponse;
	}


	public Npccwk7sresponse getNpccwk7sresponse() {
		return npccwk7sresponse;
	}
    
}