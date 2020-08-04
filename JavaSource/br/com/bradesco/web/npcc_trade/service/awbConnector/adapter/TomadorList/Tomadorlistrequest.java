package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/05/16 11:24
 */
public class Tomadorlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwo9erequest npccwo9erequest = null;
	
	public void setNpccwo9erequest(Npccwo9erequest npccwo9erequest) {
		this.npccwo9erequest = npccwo9erequest;
	}


	public Npccwo9erequest getNpccwo9erequest() {
		return npccwo9erequest;
	}
    
}