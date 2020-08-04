package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 16:40
 */
public class Fndrgrtvnctrfobsaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzxsresponse npccwzxsresponse = null;
	
	public void setNpccwzxsresponse(Npccwzxsresponse npccwzxsresponse) {
		this.npccwzxsresponse = npccwzxsresponse;
	}


	public Npccwzxsresponse getNpccwzxsresponse() {
		return npccwzxsresponse;
	}
    
}