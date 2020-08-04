package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 10:41
 */
public class Tradefinoprvinclistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxherequest npccwxherequest = null;
	
	public void setNpccwxherequest(Npccwxherequest npccwxherequest) {
		this.npccwxherequest = npccwxherequest;
	}


	public Npccwxherequest getNpccwxherequest() {
		return npccwxherequest;
	}
    
}