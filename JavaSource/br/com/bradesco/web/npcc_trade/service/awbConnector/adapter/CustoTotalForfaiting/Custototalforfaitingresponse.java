package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:58
 */
public class Custototalforfaitingresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzisresponse npccwzisresponse = null;
	
	public void setNpccwzisresponse(Npccwzisresponse npccwzisresponse) {
		this.npccwzisresponse = npccwzisresponse;
	}


	public Npccwzisresponse getNpccwzisresponse() {
		return npccwzisresponse;
	}
    
}