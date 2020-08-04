package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/11/17 16:31
 */
public class Cotacoesavencerlistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzjsresponse npccwzjsresponse = null;
	
	public void setNpccwzjsresponse(Npccwzjsresponse npccwzjsresponse) {
		this.npccwzjsresponse = npccwzjsresponse;
	}


	public Npccwzjsresponse getNpccwzjsresponse() {
		return npccwzjsresponse;
	}
    
}