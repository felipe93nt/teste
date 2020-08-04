package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/06/16 12:08
 */
public class Combounidadenegocioresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzksresponse npccwzksresponse = null;
	
	public void setNpccwzksresponse(Npccwzksresponse npccwzksresponse) {
		this.npccwzksresponse = npccwzksresponse;
	}


	public Npccwzksresponse getNpccwzksresponse() {
		return npccwzksresponse;
	}
    
}