package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:58
 */
public class Custototalforfaitingrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzierequest npccwzierequest = null;
	
	public void setNpccwzierequest(Npccwzierequest npccwzierequest) {
		this.npccwzierequest = npccwzierequest;
	}


	public Npccwzierequest getNpccwzierequest() {
		return npccwzierequest;
	}
    
}