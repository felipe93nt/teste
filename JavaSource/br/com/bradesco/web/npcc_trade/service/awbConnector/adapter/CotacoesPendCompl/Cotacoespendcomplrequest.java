package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 07/07/16 15:14
 */
public class Cotacoespendcomplrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyjerequest npccwyjerequest = null;
	
	public void setNpccwyjerequest(Npccwyjerequest npccwyjerequest) {
		this.npccwyjerequest = npccwyjerequest;
	}


	public Npccwyjerequest getNpccwyjerequest() {
		return npccwyjerequest;
	}
    
}