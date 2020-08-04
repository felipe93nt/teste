package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/01/16 11:29
 */
public class Comboclausularequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvserequest npccwvserequest = null;
	
	public void setNpccwvserequest(Npccwvserequest npccwvserequest) {
		this.npccwvserequest = npccwvserequest;
	}


	public Npccwvserequest getNpccwvserequest() {
		return npccwvserequest;
	}
    
}