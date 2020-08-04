package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:30
 */
public class Finimpdiretoaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwcerequest npccwwcerequest = null;
	
	public void setNpccwwcerequest(Npccwwcerequest npccwwcerequest) {
		this.npccwwcerequest = npccwwcerequest;
	}


	public Npccwwcerequest getNpccwwcerequest() {
		return npccwwcerequest;
	}
    
}