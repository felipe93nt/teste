package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/10/16 11:28
 */
public class Fluxovalidacaopagamerequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx8erequest npccwx8erequest = null;
	
	public void setNpccwx8erequest(Npccwx8erequest npccwx8erequest) {
		this.npccwx8erequest = npccwx8erequest;
	}


	public Npccwx8erequest getNpccwx8erequest() {
		return npccwx8erequest;
	}
    
}