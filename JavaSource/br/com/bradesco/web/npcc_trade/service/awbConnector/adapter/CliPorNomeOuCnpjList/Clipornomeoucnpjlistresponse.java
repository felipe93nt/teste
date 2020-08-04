package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/02/17 13:37
 */
public class Clipornomeoucnpjlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxusresponse npccwxusresponse = null;
	
	public void setNpccwxusresponse(Npccwxusresponse npccwxusresponse) {
		this.npccwxusresponse = npccwxusresponse;
	}


	public Npccwxusresponse getNpccwxusresponse() {
		return npccwxusresponse;
	}
    
}