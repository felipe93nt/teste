package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 11:32
 */
public class Baixasaldoforfaitingrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww6erequest npccww6erequest = null;
	
	public void setNpccww6erequest(Npccww6erequest npccww6erequest) {
		this.npccww6erequest = npccww6erequest;
	}


	public Npccww6erequest getNpccww6erequest() {
		return npccww6erequest;
	}
    
}