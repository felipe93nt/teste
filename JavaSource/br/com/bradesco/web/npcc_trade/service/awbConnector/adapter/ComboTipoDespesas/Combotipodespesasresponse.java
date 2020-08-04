package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 14:03
 */
public class Combotipodespesasresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwigsresponse npccwigsresponse = null;
	
	public void setNpccwigsresponse(Npccwigsresponse npccwigsresponse) {
		this.npccwigsresponse = npccwigsresponse;
	}


	public Npccwigsresponse getNpccwigsresponse() {
		return npccwigsresponse;
	}
    
}