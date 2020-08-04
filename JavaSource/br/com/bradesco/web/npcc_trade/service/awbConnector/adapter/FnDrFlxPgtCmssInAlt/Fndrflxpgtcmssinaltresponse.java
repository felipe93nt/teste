package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:50
 */
public class Fndrflxpgtcmssinaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxnsresponse npccwxnsresponse = null;
	
	public void setNpccwxnsresponse(Npccwxnsresponse npccwxnsresponse) {
		this.npccwxnsresponse = npccwxnsresponse;
	}


	public Npccwxnsresponse getNpccwxnsresponse() {
		return npccwxnsresponse;
	}
    
}