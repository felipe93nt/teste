package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/04/16 12:32
 */
public class Custoexternoconsresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyrsresponse npccwyrsresponse = null;
	
	public void setNpccwyrsresponse(Npccwyrsresponse npccwyrsresponse) {
		this.npccwyrsresponse = npccwyrsresponse;
	}


	public Npccwyrsresponse getNpccwyrsresponse() {
		return npccwyrsresponse;
	}
    
}