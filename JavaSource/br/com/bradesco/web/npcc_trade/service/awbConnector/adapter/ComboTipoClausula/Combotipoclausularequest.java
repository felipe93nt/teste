package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/01/16 16:05
 */
public class Combotipoclausularequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvferequest npccwvferequest = null;
	
	public void setNpccwvferequest(Npccwvferequest npccwvferequest) {
		this.npccwvferequest = npccwvferequest;
	}


	public Npccwvferequest getNpccwvferequest() {
		return npccwvferequest;
	}
    
}