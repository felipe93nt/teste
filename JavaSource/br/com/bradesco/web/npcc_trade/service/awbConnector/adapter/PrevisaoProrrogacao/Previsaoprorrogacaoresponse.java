package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/05/16 19:33
 */
public class Previsaoprorrogacaoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx9sresponse npccwx9sresponse = null;
	
	public void setNpccwx9sresponse(Npccwx9sresponse npccwx9sresponse) {
		this.npccwx9sresponse = npccwx9sresponse;
	}


	public Npccwx9sresponse getNpccwx9sresponse() {
		return npccwx9sresponse;
	}
    
}