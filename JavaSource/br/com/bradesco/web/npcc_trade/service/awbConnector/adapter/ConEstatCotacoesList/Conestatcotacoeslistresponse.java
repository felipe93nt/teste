package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 25/10/16 17:51
 */
public class Conestatcotacoeslistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzdsresponse npccwzdsresponse = null;
	
	public void setNpccwzdsresponse(Npccwzdsresponse npccwzdsresponse) {
		this.npccwzdsresponse = npccwzdsresponse;
	}


	public Npccwzdsresponse getNpccwzdsresponse() {
		return npccwzdsresponse;
	}
    
}