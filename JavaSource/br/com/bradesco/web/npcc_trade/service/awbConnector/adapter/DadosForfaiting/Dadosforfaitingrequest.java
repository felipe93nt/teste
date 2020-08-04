package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/11/17 10:30
 */
public class Dadosforfaitingrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx4erequest npccwx4erequest = null;
	
	public void setNpccwx4erequest(Npccwx4erequest npccwx4erequest) {
		this.npccwx4erequest = npccwx4erequest;
	}


	public Npccwx4erequest getNpccwx4erequest() {
		return npccwx4erequest;
	}
    
}