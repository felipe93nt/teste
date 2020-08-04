package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasModalList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/12/15 12:13
 */
public class Mercadoriasmodallistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwnsresponse npccwwnsresponse = null;
	
	public void setNpccwwnsresponse(Npccwwnsresponse npccwwnsresponse) {
		this.npccwwnsresponse = npccwwnsresponse;
	}


	public Npccwwnsresponse getNpccwwnsresponse() {
		return npccwwnsresponse;
	}
    
}