package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaPrevisaoDesemb;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/01/17 15:43
 */
public class Validaprevisaodesembresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvxsresponse npccwvxsresponse = null;
	
	public void setNpccwvxsresponse(Npccwvxsresponse npccwvxsresponse) {
		this.npccwvxsresponse = npccwvxsresponse;
	}


	public Npccwvxsresponse getNpccwvxsresponse() {
		return npccwvxsresponse;
	}
    
}