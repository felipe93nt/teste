package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 15:23
 */
public class Fndrflxpgtprcjrsaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyfsresponse npccwyfsresponse = null;
	
	public void setNpccwyfsresponse(Npccwyfsresponse npccwyfsresponse) {
		this.npccwyfsresponse = npccwyfsresponse;
	}


	public Npccwyfsresponse getNpccwyfsresponse() {
		return npccwyfsresponse;
	}
    
}