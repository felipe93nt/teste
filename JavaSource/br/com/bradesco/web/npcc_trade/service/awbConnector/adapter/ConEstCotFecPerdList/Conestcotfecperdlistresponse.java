package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/09/16 09:55
 */
public class Conestcotfecperdlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzgsresponse npccwzgsresponse = null;
	
	public void setNpccwzgsresponse(Npccwzgsresponse npccwzgsresponse) {
		this.npccwzgsresponse = npccwzgsresponse;
	}


	public Npccwzgsresponse getNpccwzgsresponse() {
		return npccwzgsresponse;
	}
    
}