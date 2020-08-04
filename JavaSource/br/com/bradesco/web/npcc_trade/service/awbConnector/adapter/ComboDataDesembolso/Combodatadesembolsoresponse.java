package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 12:41
 */
public class Combodatadesembolsoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx7sresponse npccwx7sresponse = null;
	
	public void setNpccwx7sresponse(Npccwx7sresponse npccwx7sresponse) {
		this.npccwx7sresponse = npccwx7sresponse;
	}


	public Npccwx7sresponse getNpccwx7sresponse() {
		return npccwx7sresponse;
	}
    
}