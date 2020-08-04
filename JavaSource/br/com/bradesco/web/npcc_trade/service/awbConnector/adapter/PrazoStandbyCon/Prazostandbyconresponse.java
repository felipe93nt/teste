package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrazoStandbyCon;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/12/15 09:36
 */
public class Prazostandbyconresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvysresponse npccwvysresponse = null;
	
	public void setNpccwvysresponse(Npccwvysresponse npccwvysresponse) {
		this.npccwvysresponse = npccwvysresponse;
	}


	public Npccwvysresponse getNpccwvysresponse() {
		return npccwvysresponse;
	}
    
}