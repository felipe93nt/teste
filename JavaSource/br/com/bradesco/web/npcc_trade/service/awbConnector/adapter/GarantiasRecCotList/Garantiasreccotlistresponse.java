package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/08/17 18:19
 */
public class Garantiasreccotlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwppsresponse npccwppsresponse = null;
	
	public void setNpccwppsresponse(Npccwppsresponse npccwppsresponse) {
		this.npccwppsresponse = npccwppsresponse;
	}


	public Npccwppsresponse getNpccwppsresponse() {
		return npccwppsresponse;
	}
    
}