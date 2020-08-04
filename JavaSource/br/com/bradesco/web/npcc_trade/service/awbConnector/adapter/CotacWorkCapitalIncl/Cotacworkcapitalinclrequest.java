package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 11:44
 */
public class Cotacworkcapitalinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww1erequest npccww1erequest = null;
	
	public void setNpccww1erequest(Npccww1erequest npccww1erequest) {
		this.npccww1erequest = npccww1erequest;
	}


	public Npccww1erequest getNpccww1erequest() {
		return npccww1erequest;
	}
    
}