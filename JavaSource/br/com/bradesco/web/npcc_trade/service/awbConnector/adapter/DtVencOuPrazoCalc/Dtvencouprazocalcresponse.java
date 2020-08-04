package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/08/16 10:24
 */
public class Dtvencouprazocalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx6sresponse npccwx6sresponse = null;
	
	public void setNpccwx6sresponse(Npccwx6sresponse npccwx6sresponse) {
		this.npccwx6sresponse = npccwx6sresponse;
	}


	public Npccwx6sresponse getNpccwx6sresponse() {
		return npccwx6sresponse;
	}
    
}