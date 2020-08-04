package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/03/17 17:58
 */
public class Cotacforfaitingaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwesresponse npccwwesresponse = null;
	
	public void setNpccwwesresponse(Npccwwesresponse npccwwesresponse) {
		this.npccwwesresponse = npccwwesresponse;
	}


	public Npccwwesresponse getNpccwwesresponse() {
		return npccwwesresponse;
	}
    
}