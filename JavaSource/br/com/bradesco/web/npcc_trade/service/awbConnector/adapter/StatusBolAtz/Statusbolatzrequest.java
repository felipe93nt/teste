package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.StatusBolAtz;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:26
 */
public class Statusbolatzrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwn0erequest npccwn0erequest = null;
	
	public void setNpccwn0erequest(Npccwn0erequest npccwn0erequest) {
		this.npccwn0erequest = npccwn0erequest;
	}


	public Npccwn0erequest getNpccwn0erequest() {
		return npccwn0erequest;
	}
    
}