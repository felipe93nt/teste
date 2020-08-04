package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/07/16 15:26
 */
public class Tradefinancemntlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwrsresponse npccwwrsresponse = null;
	
	public void setNpccwwrsresponse(Npccwwrsresponse npccwwrsresponse) {
		this.npccwwrsresponse = npccwwrsresponse;
	}


	public Npccwwrsresponse getNpccwwrsresponse() {
		return npccwwrsresponse;
	}
    
}