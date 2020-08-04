package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 13:53
 */
public class Cotacworkcapitalaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwkerequest npccwwkerequest = null;
	
	public void setNpccwwkerequest(Npccwwkerequest npccwwkerequest) {
		this.npccwwkerequest = npccwwkerequest;
	}


	public Npccwwkerequest getNpccwwkerequest() {
		return npccwwkerequest;
	}
    
}