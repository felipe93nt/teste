package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DevolverCotacaoDivrg;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 01/11/18 12:34
 */
public class Devolvercotacaodivrgresponse extends FRWKGL01Response {
	@Adapter (isTransactionBlock=true)
	private Npccwkysresponse npccwkysresponse = null;
	
	public void setNpccwkysresponse(Npccwkysresponse npccwkysresponse) {
		this.npccwkysresponse = npccwkysresponse;
	}


	public Npccwkysresponse getNpccwkysresponse() {
		return npccwkysresponse;
	}
}