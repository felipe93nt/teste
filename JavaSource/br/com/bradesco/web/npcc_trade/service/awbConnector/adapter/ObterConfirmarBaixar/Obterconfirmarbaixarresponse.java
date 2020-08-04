package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarBaixar;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/01/17 12:51
 */
public class Obterconfirmarbaixarresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxtsresponse npccwxtsresponse = null;
	
	public void setNpccwxtsresponse(Npccwxtsresponse npccwxtsresponse) {
		this.npccwxtsresponse = npccwxtsresponse;
	}


	public Npccwxtsresponse getNpccwxtsresponse() {
		return npccwxtsresponse;
	}
    
}