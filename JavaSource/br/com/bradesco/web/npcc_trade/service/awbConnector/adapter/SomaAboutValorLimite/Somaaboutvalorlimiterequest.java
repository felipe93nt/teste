package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/02/17 13:48
 */
public class Somaaboutvalorlimiterequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww8erequest npccww8erequest = null;
	
	public void setNpccww8erequest(Npccww8erequest npccww8erequest) {
		this.npccww8erequest = npccww8erequest;
	}


	public Npccww8erequest getNpccww8erequest() {
		return npccww8erequest;
	}
    
}