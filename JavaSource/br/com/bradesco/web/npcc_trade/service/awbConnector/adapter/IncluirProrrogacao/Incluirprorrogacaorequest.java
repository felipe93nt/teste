package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirProrrogacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:02
 */
public class Incluirprorrogacaorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww5erequest npccww5erequest = null;
	
	public void setNpccww5erequest(Npccww5erequest npccww5erequest) {
		this.npccww5erequest = npccww5erequest;
	}


	public Npccww5erequest getNpccww5erequest() {
		return npccww5erequest;
	}
    
}