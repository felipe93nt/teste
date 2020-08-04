package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/12/16 14:09
 */
public class Desfazimentoinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccw0csresponse npccw0csresponse = null;
	
	public void setNpccw0csresponse(Npccw0csresponse npccw0csresponse) {
		this.npccw0csresponse = npccw0csresponse;
	}


	public Npccw0csresponse getNpccw0csresponse() {
		return npccw0csresponse;
	}
    
}