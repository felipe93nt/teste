package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/03/17 15:10
 */
public class Cotacforfaitinginclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv5sresponse npccwv5sresponse = null;
	
	public void setNpccwv5sresponse(Npccwv5sresponse npccwv5sresponse) {
		this.npccwv5sresponse = npccwv5sresponse;
	}


	public Npccwv5sresponse getNpccwv5sresponse() {
		return npccwv5sresponse;
	}
    
}