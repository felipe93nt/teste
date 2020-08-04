package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 15:00
 */
public class Desfazimentoaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccw55sresponse npccw55sresponse = null;
	
	public void setNpccw55sresponse(Npccw55sresponse npccw55sresponse) {
		this.npccw55sresponse = npccw55sresponse;
	}


	public Npccw55sresponse getNpccw55sresponse() {
		return npccw55sresponse;
	}
    
}