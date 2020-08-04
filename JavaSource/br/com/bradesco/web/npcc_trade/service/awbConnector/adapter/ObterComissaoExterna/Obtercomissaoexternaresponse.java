package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:44
 */
public class Obtercomissaoexternaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxjsresponse npccwxjsresponse = null;
	
	public void setNpccwxjsresponse(Npccwxjsresponse npccwxjsresponse) {
		this.npccwxjsresponse = npccwxjsresponse;
	}


	public Npccwxjsresponse getNpccwxjsresponse() {
		return npccwxjsresponse;
	}
    
}