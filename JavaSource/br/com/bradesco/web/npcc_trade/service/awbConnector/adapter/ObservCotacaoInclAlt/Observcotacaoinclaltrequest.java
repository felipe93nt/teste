package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 10:06
 */
public class Observcotacaoinclaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww0erequest npccww0erequest = null;
	
	public void setNpccww0erequest(Npccww0erequest npccww0erequest) {
		this.npccww0erequest = npccww0erequest;
	}


	public Npccww0erequest getNpccww0erequest() {
		return npccww0erequest;
	}
    
}