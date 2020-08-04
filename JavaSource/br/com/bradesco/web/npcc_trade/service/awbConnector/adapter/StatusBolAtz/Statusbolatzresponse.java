package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.StatusBolAtz;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:26
 */
public class Statusbolatzresponse extends FRWKGL01Response {


	@Adapter (isTransactionBlock=true)
	private Npccwn0sresponse npccwn0sresponse = null;
	
	public void setNpccwn0sresponse(Npccwn0sresponse npccwn0sresponse) {
		this.npccwn0sresponse = npccwn0sresponse;
	}

	public Npccwn0sresponse getNpccwn0sresponse() {
		return npccwn0sresponse;
	}
	
    
}