package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModeloBoleto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/12/15 15:27
 */
public class Combomodeloboletoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvtsresponse npccwvtsresponse = null;
	
	public void setNpccwvtsresponse(Npccwvtsresponse npccwvtsresponse) {
		this.npccwvtsresponse = npccwvtsresponse;
	}


	public Npccwvtsresponse getNpccwvtsresponse() {
		return npccwvtsresponse;
	}
    
}