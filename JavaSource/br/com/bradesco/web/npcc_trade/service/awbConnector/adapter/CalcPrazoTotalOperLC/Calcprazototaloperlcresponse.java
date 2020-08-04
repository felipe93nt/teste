package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/06/16 11:43
 */
public class Calcprazototaloperlcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx3sresponse npccwx3sresponse = null;
	
	public void setNpccwx3sresponse(Npccwx3sresponse npccwx3sresponse) {
		this.npccwx3sresponse = npccwx3sresponse;
	}


	public Npccwx3sresponse getNpccwx3sresponse() {
		return npccwx3sresponse;
	}
    
}