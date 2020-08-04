package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/09/16 17:33
 */
public class Forftngdesembolsoaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyqsresponse npccwyqsresponse = null;
	
	public void setNpccwyqsresponse(Npccwyqsresponse npccwyqsresponse) {
		this.npccwyqsresponse = npccwyqsresponse;
	}


	public Npccwyqsresponse getNpccwyqsresponse() {
		return npccwyqsresponse;
	}
    
}