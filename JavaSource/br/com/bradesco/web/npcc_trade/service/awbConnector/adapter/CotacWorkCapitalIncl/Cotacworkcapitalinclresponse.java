package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 11:44
 */
public class Cotacworkcapitalinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww1sresponse npccww1sresponse = null;
	
	public void setNpccww1sresponse(Npccww1sresponse npccww1sresponse) {
		this.npccww1sresponse = npccww1sresponse;
	}


	public Npccww1sresponse getNpccww1sresponse() {
		return npccww1sresponse;
	}
    
}