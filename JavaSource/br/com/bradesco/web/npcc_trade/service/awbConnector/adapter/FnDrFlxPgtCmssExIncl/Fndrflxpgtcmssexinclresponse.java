package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 13:33
 */
public class Fndrflxpgtcmssexinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwymsresponse npccwymsresponse = null;
	
	public void setNpccwymsresponse(Npccwymsresponse npccwymsresponse) {
		this.npccwymsresponse = npccwymsresponse;
	}


	public Npccwymsresponse getNpccwymsresponse() {
		return npccwymsresponse;
	}
    
}