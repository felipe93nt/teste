package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:19
 */
public class Mercadoriaslistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxgsresponse npccwxgsresponse = null;
	
	public void setNpccwxgsresponse(Npccwxgsresponse npccwxgsresponse) {
		this.npccwxgsresponse = npccwxgsresponse;
	}


	public Npccwxgsresponse getNpccwxgsresponse() {
		return npccwxgsresponse;
	}
    
}