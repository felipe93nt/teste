package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarCotacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 09:19
 */
public class Consultarcotacaoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxasresponse npccwxasresponse = null;
	
	public void setNpccwxasresponse(Npccwxasresponse npccwxasresponse) {
		this.npccwxasresponse = npccwxasresponse;
	}


	public Npccwxasresponse getNpccwxasresponse() {
		return npccwxasresponse;
	}
    
}