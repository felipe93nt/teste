package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:04
 */
public class Comissaointernadetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxfsresponse npccwxfsresponse = null;
	
	public void setNpccwxfsresponse(Npccwxfsresponse npccwxfsresponse) {
		this.npccwxfsresponse = npccwxfsresponse;
	}


	public Npccwxfsresponse getNpccwxfsresponse() {
		return npccwxfsresponse;
	}
    
}