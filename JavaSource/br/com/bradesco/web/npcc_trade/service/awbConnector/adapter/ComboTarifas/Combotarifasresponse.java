package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/03/16 14:37
 */
public class Combotarifasresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwiesresponse npccwiesresponse = null;
	
	public void setNpccwiesresponse(Npccwiesresponse npccwiesresponse) {
		this.npccwiesresponse = npccwiesresponse;
	}


	public Npccwiesresponse getNpccwiesresponse() {
		return npccwiesresponse;
	}
    
}