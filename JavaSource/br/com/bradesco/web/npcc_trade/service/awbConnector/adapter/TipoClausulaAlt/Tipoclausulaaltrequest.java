package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/12/15 09:56
 */
public class Tipoclausulaaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvderequest npccwvderequest = null;
	
	public void setNpccwvderequest(Npccwvderequest npccwvderequest) {
		this.npccwvderequest = npccwvderequest;
	}


	public Npccwvderequest getNpccwvderequest() {
		return npccwvderequest;
	}
    
}