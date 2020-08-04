package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/08/16 18:41
 */
public class Tradefinancelogpesqresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwztsresponse npccwztsresponse = null;
	
	public void setNpccwztsresponse(Npccwztsresponse npccwztsresponse) {
		this.npccwztsresponse = npccwztsresponse;
	}


	public Npccwztsresponse getNpccwztsresponse() {
		return npccwztsresponse;
	}
    
}