package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarPerda;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:09
 */
public class Obterconfirmarperdarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxqerequest npccwxqerequest = null;
	
	public void setNpccwxqerequest(Npccwxqerequest npccwxqerequest) {
		this.npccwxqerequest = npccwxqerequest;
	}


	public Npccwxqerequest getNpccwxqerequest() {
		return npccwxqerequest;
	}
    
}