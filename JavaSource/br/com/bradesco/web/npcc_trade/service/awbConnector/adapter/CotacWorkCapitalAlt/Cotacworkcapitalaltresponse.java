package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 13:53
 */
public class Cotacworkcapitalaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwksresponse npccwwksresponse = null;
	
	public void setNpccwwksresponse(Npccwwksresponse npccwwksresponse) {
		this.npccwwksresponse = npccwwksresponse;
	}


	public Npccwwksresponse getNpccwwksresponse() {
		return npccwwksresponse;
	}
    
}