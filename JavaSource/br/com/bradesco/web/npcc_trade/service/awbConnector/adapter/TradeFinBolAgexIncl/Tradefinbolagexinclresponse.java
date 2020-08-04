package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/12/16 16:39
 */
public class Tradefinbolagexinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwnysresponse npccwnysresponse = null;
	
	public void setNpccwnysresponse(Npccwnysresponse npccwnysresponse) {
		this.npccwnysresponse = npccwnysresponse;
	}


	public Npccwnysresponse getNpccwnysresponse() {
		return npccwnysresponse;
	}
    
}