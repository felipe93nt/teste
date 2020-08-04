package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 11:58
 */
public class Cotacaoppealtresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwisresponse npccwwisresponse = null;
	
	public void setNpccwwisresponse(Npccwwisresponse npccwwisresponse) {
		this.npccwwisresponse = npccwwisresponse;
	}


	public Npccwwisresponse getNpccwwisresponse() {
		return npccwwisresponse;
	}
    
}