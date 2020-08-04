package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/05/16 19:33
 */
public class Previsaoprorrogacaorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx9erequest npccwx9erequest = null;
	
	public void setNpccwx9erequest(Npccwx9erequest npccwx9erequest) {
		this.npccwx9erequest = npccwx9erequest;
	}


	public Npccwx9erequest getNpccwx9erequest() {
		return npccwx9erequest;
	}
    
}