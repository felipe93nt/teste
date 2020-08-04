package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:10
 */
public class Calcvalorescomissintrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwlaerequest npccwlaerequest = null;
	
	public void setNpccwlaerequest(Npccwlaerequest npccwlaerequest) {
		this.npccwlaerequest = npccwlaerequest;
	}


	public Npccwlaerequest getNpccwlaerequest() {
		return npccwlaerequest;
	}
    
}