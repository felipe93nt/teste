package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 15:53
 */
public class Combopaisrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwa3erequest npcdwa3erequest = null;
	
	public void setNpcdwa3erequest(Npcdwa3erequest npcdwa3erequest) {
		this.npcdwa3erequest = npcdwa3erequest;
	}


	public Npcdwa3erequest getNpcdwa3erequest() {
		return npcdwa3erequest;
	}
    
}