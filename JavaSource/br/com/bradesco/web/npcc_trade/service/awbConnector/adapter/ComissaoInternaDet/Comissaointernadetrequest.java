package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:04
 */
public class Comissaointernadetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxferequest npccwxferequest = null;
	
	public void setNpccwxferequest(Npccwxferequest npccwxferequest) {
		this.npccwxferequest = npccwxferequest;
	}


	public Npccwxferequest getNpccwxferequest() {
		return npccwxferequest;
	}
    
}