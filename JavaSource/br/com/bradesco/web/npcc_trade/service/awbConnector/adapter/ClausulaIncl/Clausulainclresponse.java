package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClausulaIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/12/15 10:25
 */
public class Clausulainclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvhsresponse npccwvhsresponse = null;
	
	public void setNpccwvhsresponse(Npccwvhsresponse npccwvhsresponse) {
		this.npccwvhsresponse = npccwvhsresponse;
	}


	public Npccwvhsresponse getNpccwvhsresponse() {
		return npccwvhsresponse;
	}
    
}