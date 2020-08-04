package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AprovarBanqueiro;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/08/16 18:13
 */
public class Aprovarbanqueiroresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwycsresponse npccwycsresponse = null;
	
	public void setNpccwycsresponse(Npccwycsresponse npccwycsresponse) {
		this.npccwycsresponse = npccwycsresponse;
	}


	public Npccwycsresponse getNpccwycsresponse() {
		return npccwycsresponse;
	}
    
}