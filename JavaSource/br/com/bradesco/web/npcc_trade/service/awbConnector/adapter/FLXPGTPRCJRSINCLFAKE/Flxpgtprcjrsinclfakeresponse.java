package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/10/16 09:46
 */
public class Flxpgtprcjrsinclfakeresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwgsresponse npccwwgsresponse = null;
	
	public void setNpccwwgsresponse(Npccwwgsresponse npccwwgsresponse) {
		this.npccwwgsresponse = npccwwgsresponse;
	}


	public Npccwwgsresponse getNpccwwgsresponse() {
		return npccwwgsresponse;
	}
    
}