package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObservCotacaoInclAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 25/04/18 10:06
 */
public class Observcotacaoinclaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccww0sresponse npccww0sresponse = null;
	
	public void setNpccww0sresponse(Npccww0sresponse npccww0sresponse) {
		this.npccww0sresponse = npccww0sresponse;
	}


	public Npccww0sresponse getNpccww0sresponse() {
		return npccww0sresponse;
	}
    
}