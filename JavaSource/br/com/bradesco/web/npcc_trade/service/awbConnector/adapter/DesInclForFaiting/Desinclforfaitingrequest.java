package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 17/05/16 09:26
 */
public class Desinclforfaitingrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwxerequest npccwwxerequest = null;
	
	public void setNpccwwxerequest(Npccwwxerequest npccwwxerequest) {
		this.npccwwxerequest = npccwwxerequest;
	}


	public Npccwwxerequest getNpccwwxerequest() {
		return npccwwxerequest;
	}
    
}