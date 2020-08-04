package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/10/16 15:49
 */
public class Garantiasavallistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwjqerequest npccwjqerequest = null;
	
	public void setNpccwjqerequest(Npccwjqerequest npccwjqerequest) {
		this.npccwjqerequest = npccwjqerequest;
	}


	public Npccwjqerequest getNpccwjqerequest() {
		return npccwjqerequest;
	}
    
}