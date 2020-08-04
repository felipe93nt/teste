package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/02/17 13:37
 */
public class Clipornomeoucnpjlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxuerequest npccwxuerequest = null;
	
	public void setNpccwxuerequest(Npccwxuerequest npccwxuerequest) {
		this.npccwxuerequest = npccwxuerequest;
	}


	public Npccwxuerequest getNpccwxuerequest() {
		return npccwxuerequest;
	}
    
}