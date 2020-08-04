package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/02/16 19:22
 */
public class Fndrflxpgtprcjrsinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyksresponse npccwyksresponse = null;
	
	public void setNpccwyksresponse(Npccwyksresponse npccwyksresponse) {
		this.npccwyksresponse = npccwyksresponse;
	}


	public Npccwyksresponse getNpccwyksresponse() {
		return npccwyksresponse;
	}
    
}