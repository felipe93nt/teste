package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 18:08
 */
public class Listasituacaoboletorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwjxerequest npccwjxerequest = null;
	
	public void setNpccwjxerequest(Npccwjxerequest npccwjxerequest) {
		this.npccwjxerequest = npccwjxerequest;
	}


	public Npccwjxerequest getNpccwjxerequest() {
		return npccwjxerequest;
	}
    
}