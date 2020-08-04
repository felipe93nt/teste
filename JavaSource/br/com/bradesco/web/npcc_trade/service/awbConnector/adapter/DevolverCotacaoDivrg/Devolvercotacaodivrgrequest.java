package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DevolverCotacaoDivrg;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 01/11/18 12:34
 */
public class Devolvercotacaodivrgrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwkyerequest npccwkyerequest = null;
	
	public void setNpccwkyerequest(Npccwkyerequest npccwkyerequest) {
		this.npccwkyerequest = npccwkyerequest;
	}


	public Npccwkyerequest getNpccwkyerequest() {
		return npccwkyerequest;
	}
    
}