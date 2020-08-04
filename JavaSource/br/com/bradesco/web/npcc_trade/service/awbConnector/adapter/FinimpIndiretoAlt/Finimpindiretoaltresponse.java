package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 11:53
 */
public class Finimpindiretoaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwdsresponse npccwwdsresponse = null;
	
	public void setNpccwwdsresponse(Npccwwdsresponse npccwwdsresponse) {
		this.npccwwdsresponse = npccwwdsresponse;
	}


	public Npccwwdsresponse getNpccwwdsresponse() {
		return npccwwdsresponse;
	}
    
}