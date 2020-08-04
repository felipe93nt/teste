package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/11/16 15:05
 */
public class Incaltfundingdesplcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv6erequest npccwv6erequest = null;
	
	public void setNpccwv6erequest(Npccwv6erequest npccwv6erequest) {
		this.npccwv6erequest = npccwv6erequest;
	}


	public Npccwv6erequest getNpccwv6erequest() {
		return npccwv6erequest;
	}
    
}