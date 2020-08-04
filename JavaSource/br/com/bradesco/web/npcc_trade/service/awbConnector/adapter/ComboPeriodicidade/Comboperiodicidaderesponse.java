package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/09/16 16:13
 */
public class Comboperiodicidaderesponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwusresponse npccwwusresponse = null;
	
	public void setNpccwwusresponse(Npccwwusresponse npccwwusresponse) {
		this.npccwwusresponse = npccwwusresponse;
	}


	public Npccwwusresponse getNpccwwusresponse() {
		return npccwwusresponse;
	}
    
}