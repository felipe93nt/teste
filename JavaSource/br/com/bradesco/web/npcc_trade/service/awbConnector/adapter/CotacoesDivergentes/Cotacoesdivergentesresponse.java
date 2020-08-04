package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 17/10/16 11:15
 */
public class Cotacoesdivergentesresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyhsresponse npccwyhsresponse = null;
	
	public void setNpccwyhsresponse(Npccwyhsresponse npccwyhsresponse) {
		this.npccwyhsresponse = npccwyhsresponse;
	}


	public Npccwyhsresponse getNpccwyhsresponse() {
		return npccwyhsresponse;
	}
    
}