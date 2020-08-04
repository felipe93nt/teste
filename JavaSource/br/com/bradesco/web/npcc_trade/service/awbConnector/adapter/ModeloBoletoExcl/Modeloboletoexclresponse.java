package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoExcl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/12/15 16:51
 */
public class Modeloboletoexclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvqsresponse npccwvqsresponse = null;
	
	public void setNpccwvqsresponse(Npccwvqsresponse npccwvqsresponse) {
		this.npccwvqsresponse = npccwvqsresponse;
	}


	public Npccwvqsresponse getNpccwvqsresponse() {
		return npccwvqsresponse;
	}
    
}