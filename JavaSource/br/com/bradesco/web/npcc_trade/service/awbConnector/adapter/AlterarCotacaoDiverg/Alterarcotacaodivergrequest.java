package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarCotacaoDiverg;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/01/17 10:55
 */
public class Alterarcotacaodivergrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzwerequest npccwzwerequest = null;
	
	public void setNpccwzwerequest(Npccwzwerequest npccwzwerequest) {
		this.npccwzwerequest = npccwzwerequest;
	}


	public Npccwzwerequest getNpccwzwerequest() {
		return npccwzwerequest;
	}
    
}