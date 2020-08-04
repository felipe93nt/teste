package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 08:12
 */
public class Garantiaadicionaconsresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwypsresponse npccwypsresponse = null;
	
	public void setNpccwypsresponse(Npccwypsresponse npccwypsresponse) {
		this.npccwypsresponse = npccwypsresponse;
	}


	public Npccwypsresponse getNpccwypsresponse() {
		return npccwypsresponse;
	}
    
}