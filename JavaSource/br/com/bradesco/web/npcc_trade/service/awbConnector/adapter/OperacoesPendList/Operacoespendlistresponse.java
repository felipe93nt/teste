package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/04/17 15:21
 */
public class Operacoespendlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwznsresponse npccwznsresponse = null;
	
	public void setNpccwznsresponse(Npccwznsresponse npccwznsresponse) {
		this.npccwznsresponse = npccwznsresponse;
	}


	public Npccwznsresponse getNpccwznsresponse() {
		return npccwznsresponse;
	}
    
}