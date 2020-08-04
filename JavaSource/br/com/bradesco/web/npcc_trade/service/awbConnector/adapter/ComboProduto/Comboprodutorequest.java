package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/02/16 14:44
 */
public class Comboprodutorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwiaerequest npccwiaerequest = null;
	
	public void setNpccwiaerequest(Npccwiaerequest npccwiaerequest) {
		this.npccwiaerequest = npccwiaerequest;
	}


	public Npccwiaerequest getNpccwiaerequest() {
		return npccwiaerequest;
	}
    
}