package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/09/18 19:00
 */
public class Garantiaaprovlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwjpsresponse npccwjpsresponse = null;
	
	public void setNpccwjpsresponse(Npccwjpsresponse npccwjpsresponse) {
		this.npccwjpsresponse = npccwjpsresponse;
	}


	public Npccwjpsresponse getNpccwjpsresponse() {
		return npccwjpsresponse;
	}
    
}