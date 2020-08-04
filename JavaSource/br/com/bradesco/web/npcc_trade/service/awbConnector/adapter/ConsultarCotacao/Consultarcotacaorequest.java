package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 09:19
 */
public class Consultarcotacaorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxaerequest npccwxaerequest = null;
	
	public void setNpccwxaerequest(Npccwxaerequest npccwxaerequest) {
		this.npccwxaerequest = npccwxaerequest;
	}


	public Npccwxaerequest getNpccwxaerequest() {
		return npccwxaerequest;
	}
    
}