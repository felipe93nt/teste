package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 11:16
 */
public class Garantiaavalistaincresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwk9sresponse npccwk9sresponse = null;
	
	public void setNpccwk9sresponse(Npccwk9sresponse npccwk9sresponse) {
		this.npccwk9sresponse = npccwk9sresponse;
	}


	public Npccwk9sresponse getNpccwk9sresponse() {
		return npccwk9sresponse;
	}
    
}