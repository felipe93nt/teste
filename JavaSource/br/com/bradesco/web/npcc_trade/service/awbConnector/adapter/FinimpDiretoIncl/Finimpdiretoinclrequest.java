package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 13:31
 */
public class Finimpdiretoinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv3erequest npccwv3erequest = null;
	
	public void setNpccwv3erequest(Npccwv3erequest npccwv3erequest) {
		this.npccwv3erequest = npccwv3erequest;
	}


	public Npccwv3erequest getNpccwv3erequest() {
		return npccwv3erequest;
	}
    
}