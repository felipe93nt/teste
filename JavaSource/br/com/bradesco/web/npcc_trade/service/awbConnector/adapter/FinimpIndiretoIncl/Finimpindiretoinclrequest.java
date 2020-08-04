package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpIndiretoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 10:25
 */
public class Finimpindiretoinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv4erequest npccwv4erequest = null;
	
	public void setNpccwv4erequest(Npccwv4erequest npccwv4erequest) {
		this.npccwv4erequest = npccwv4erequest;
	}


	public Npccwv4erequest getNpccwv4erequest() {
		return npccwv4erequest;
	}
    
}