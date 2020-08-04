package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/07/16 15:14
 */
public class Cotacoespendcomplresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyjsresponse npccwyjsresponse = null;
	
	public void setNpccwyjsresponse(Npccwyjsresponse npccwyjsresponse) {
		this.npccwyjsresponse = npccwyjsresponse;
	}


	public Npccwyjsresponse getNpccwyjsresponse() {
		return npccwyjsresponse;
	}
    
}