package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 12:15
 */
public class Boletoagexlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwn2sresponse npccwn2sresponse = null;
	
	public void setNpccwn2sresponse(Npccwn2sresponse npccwn2sresponse) {
		this.npccwn2sresponse = npccwn2sresponse;
	}


	public Npccwn2sresponse getNpccwn2sresponse() {
		return npccwn2sresponse;
	}
    
}