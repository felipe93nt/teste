package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/08/16 16:41
 */
public class Obtertarifaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwdjsresponse npccwdjsresponse = null;
	
	public void setNpccwdjsresponse(Npccwdjsresponse npccwdjsresponse) {
		this.npccwdjsresponse = npccwdjsresponse;
	}


	public Npccwdjsresponse getNpccwdjsresponse() {
		return npccwdjsresponse;
	}
    
}