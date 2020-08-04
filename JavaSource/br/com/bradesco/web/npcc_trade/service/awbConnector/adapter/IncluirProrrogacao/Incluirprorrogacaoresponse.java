package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirProrrogacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:02
 */
public class Incluirprorrogacaoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww5sresponse npccww5sresponse = null;
	
	public void setNpccww5sresponse(Npccww5sresponse npccww5sresponse) {
		this.npccww5sresponse = npccww5sresponse;
	}


	public Npccww5sresponse getNpccww5sresponse() {
		return npccww5sresponse;
	}
    
}