package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:41
 */
public class Fndrflxpgtcmssininclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwylsresponse npccwylsresponse = null;
	
	public void setNpccwylsresponse(Npccwylsresponse npccwylsresponse) {
		this.npccwylsresponse = npccwylsresponse;
	}


	public Npccwylsresponse getNpccwylsresponse() {
		return npccwylsresponse;
	}
    
}