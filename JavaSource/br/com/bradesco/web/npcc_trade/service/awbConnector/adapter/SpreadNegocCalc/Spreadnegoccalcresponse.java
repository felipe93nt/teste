package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/03/17 09:38
 */
public class Spreadnegoccalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxxsresponse npccwxxsresponse = null;
	
	public void setNpccwxxsresponse(Npccwxxsresponse npccwxxsresponse) {
		this.npccwxxsresponse = npccwxxsresponse;
	}


	public Npccwxxsresponse getNpccwxxsresponse() {
		return npccwxxsresponse;
	}
    
}