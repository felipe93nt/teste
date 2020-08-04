package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/08/16 10:24
 */
public class Dtvencouprazocalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx6erequest npccwx6erequest = null;
	
	public void setNpccwx6erequest(Npccwx6erequest npccwx6erequest) {
		this.npccwx6erequest = npccwx6erequest;
	}


	public Npccwx6erequest getNpccwx6erequest() {
		return npccwx6erequest;
	}
    
}