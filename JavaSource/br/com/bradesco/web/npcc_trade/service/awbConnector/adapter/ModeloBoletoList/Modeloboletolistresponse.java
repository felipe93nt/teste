package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/06/18 09:46
 */
public class Modeloboletolistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvmsresponse npccwvmsresponse = null;
	
	public void setNpccwvmsresponse(Npccwvmsresponse npccwvmsresponse) {
		this.npccwvmsresponse = npccwvmsresponse;
	}


	public Npccwvmsresponse getNpccwvmsresponse() {
		return npccwvmsresponse;
	}
    
}