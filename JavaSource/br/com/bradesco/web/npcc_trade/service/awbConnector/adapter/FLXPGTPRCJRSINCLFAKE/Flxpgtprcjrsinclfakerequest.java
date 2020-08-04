package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/10/16 09:46
 */
public class Flxpgtprcjrsinclfakerequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwgerequest npccwwgerequest = null;
	
	public void setNpccwwgerequest(Npccwwgerequest npccwwgerequest) {
		this.npccwwgerequest = npccwwgerequest;
	}


	public Npccwwgerequest getNpccwwgerequest() {
		return npccwwgerequest;
	}
    
}