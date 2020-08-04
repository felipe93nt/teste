package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/11/18 16:58
 */
public class Comissaodesembolsdetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwj6sresponse npccwj6sresponse = null;
	
	public void setNpccwj6sresponse(Npccwj6sresponse npccwj6sresponse) {
		this.npccwj6sresponse = npccwj6sresponse;
	}


	public Npccwj6sresponse getNpccwj6sresponse() {
		return npccwj6sresponse;
	}
    
}