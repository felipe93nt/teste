package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/10/16 10:41
 */
public class Parcelasdesembolsoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzfsresponse npccwzfsresponse = null;
	
	public void setNpccwzfsresponse(Npccwzfsresponse npccwzfsresponse) {
		this.npccwzfsresponse = npccwzfsresponse;
	}


	public Npccwzfsresponse getNpccwzfsresponse() {
		return npccwzfsresponse;
	}
    
}