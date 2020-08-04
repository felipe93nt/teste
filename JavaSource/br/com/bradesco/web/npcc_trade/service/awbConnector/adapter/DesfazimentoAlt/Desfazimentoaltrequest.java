package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 15:00
 */
public class Desfazimentoaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccw55erequest npccw55erequest = null;
	
	public void setNpccw55erequest(Npccw55erequest npccw55erequest) {
		this.npccw55erequest = npccw55erequest;
	}


	public Npccw55erequest getNpccw55erequest() {
		return npccw55erequest;
	}
    
}