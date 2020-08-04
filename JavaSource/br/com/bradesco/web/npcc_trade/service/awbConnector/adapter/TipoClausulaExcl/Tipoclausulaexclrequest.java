package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaExcl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 08:52
 */
public class Tipoclausulaexclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwveerequest npccwveerequest = null;
	
	public void setNpccwveerequest(Npccwveerequest npccwveerequest) {
		this.npccwveerequest = npccwveerequest;
	}


	public Npccwveerequest getNpccwveerequest() {
		return npccwveerequest;
	}
    
}