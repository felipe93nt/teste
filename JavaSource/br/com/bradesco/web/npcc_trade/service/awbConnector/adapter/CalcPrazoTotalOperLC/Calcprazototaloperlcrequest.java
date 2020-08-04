package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/06/16 11:43
 */
public class Calcprazototaloperlcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx3erequest npccwx3erequest = null;
	
	public void setNpccwx3erequest(Npccwx3erequest npccwx3erequest) {
		this.npccwx3erequest = npccwx3erequest;
	}


	public Npccwx3erequest getNpccwx3erequest() {
		return npccwx3erequest;
	}
    
}