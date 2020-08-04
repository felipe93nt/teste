package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 14:31
 */
public class Cotacoesfechadasresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzvsresponse npccwzvsresponse = null;
	
	public void setNpccwzvsresponse(Npccwzvsresponse npccwzvsresponse) {
		this.npccwzvsresponse = npccwzvsresponse;
	}


	public Npccwzvsresponse getNpccwzvsresponse() {
		return npccwzvsresponse;
	}
    
}