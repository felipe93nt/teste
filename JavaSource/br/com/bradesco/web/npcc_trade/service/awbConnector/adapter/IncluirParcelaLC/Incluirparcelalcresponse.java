package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/06/16 11:10
 */
public class Incluirparcelalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv1sresponse npccwv1sresponse = null;
	
	public void setNpccwv1sresponse(Npccwv1sresponse npccwv1sresponse) {
		this.npccwv1sresponse = npccwv1sresponse;
	}


	public Npccwv1sresponse getNpccwv1sresponse() {
		return npccwv1sresponse;
	}
    
}