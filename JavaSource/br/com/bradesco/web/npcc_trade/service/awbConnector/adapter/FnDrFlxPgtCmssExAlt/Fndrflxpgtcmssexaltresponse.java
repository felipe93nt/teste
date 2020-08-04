package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:43
 */
public class Fndrflxpgtcmssexaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxssresponse npccwxssresponse = null;
	
	public void setNpccwxssresponse(Npccwxssresponse npccwxssresponse) {
		this.npccwxssresponse = npccwxssresponse;
	}


	public Npccwxssresponse getNpccwxssresponse() {
		return npccwxssresponse;
	}
    
}