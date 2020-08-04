package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/07/16 16:42
 */
public class Przmedoperdesembcalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzpsresponse npccwzpsresponse = null;
	
	public void setNpccwzpsresponse(Npccwzpsresponse npccwzpsresponse) {
		this.npccwzpsresponse = npccwzpsresponse;
	}


	public Npccwzpsresponse getNpccwzpsresponse() {
		return npccwzpsresponse;
	}
    
}