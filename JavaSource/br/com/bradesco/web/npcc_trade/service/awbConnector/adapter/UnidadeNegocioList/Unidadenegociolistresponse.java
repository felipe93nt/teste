package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidadeNegocioList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/02/16 19:36
 */
public class Unidadenegociolistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwgksresponse npcdwgksresponse = null;
	
	public void setNpcdwgksresponse(Npcdwgksresponse npcdwgksresponse) {
		this.npcdwgksresponse = npcdwgksresponse;
	}


	public Npcdwgksresponse getNpcdwgksresponse() {
		return npcdwgksresponse;
	}
    
}