package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 12/12/16 15:24
 */
public class Alterarcomplgarantiaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwjsresponse npccwwjsresponse = null;
	
	public void setNpccwwjsresponse(Npccwwjsresponse npccwwjsresponse) {
		this.npccwwjsresponse = npccwwjsresponse;
	}


	public Npccwwjsresponse getNpccwwjsresponse() {
		return npccwwjsresponse;
	}
    
}