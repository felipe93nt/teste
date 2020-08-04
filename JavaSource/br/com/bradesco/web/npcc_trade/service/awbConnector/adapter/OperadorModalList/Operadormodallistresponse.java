package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/03/20 15:27
 */
public class Operadormodallistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvusresponse npccwvusresponse = null;
	
	public void setNpccwvusresponse(Npccwvusresponse npccwvusresponse) {
		this.npccwvusresponse = npccwvusresponse;
	}


	public Npccwvusresponse getNpccwvusresponse() {
		return npccwvusresponse;
	}
    
}