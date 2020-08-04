package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/08/16 18:41
 */
public class Tradefinancelogpesqrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzterequest npccwzterequest = null;
	
	public void setNpccwzterequest(Npccwzterequest npccwzterequest) {
		this.npccwzterequest = npccwzterequest;
	}


	public Npccwzterequest getNpccwzterequest() {
		return npccwzterequest;
	}
    
}