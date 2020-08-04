package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/07/16 15:26
 */
public class Tradefinancemntlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwrerequest npccwwrerequest = null;
	
	public void setNpccwwrerequest(Npccwwrerequest npccwwrerequest) {
		this.npccwwrerequest = npccwwrerequest;
	}


	public Npccwwrerequest getNpccwwrerequest() {
		return npccwwrerequest;
	}
    
}