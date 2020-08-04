package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/10/16 11:28
 */
public class Fluxovalidacaopagameresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx8sresponse npccwx8sresponse = null;
	
	public void setNpccwx8sresponse(Npccwx8sresponse npccwx8sresponse) {
		this.npccwx8sresponse = npccwx8sresponse;
	}


	public Npccwx8sresponse getNpccwx8sresponse() {
		return npccwx8sresponse;
	}
    
}