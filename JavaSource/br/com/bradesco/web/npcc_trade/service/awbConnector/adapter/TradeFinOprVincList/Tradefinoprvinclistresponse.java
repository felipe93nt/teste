package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinOprVincList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 10:41
 */
public class Tradefinoprvinclistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxhsresponse npccwxhsresponse = null;
	
	public void setNpccwxhsresponse(Npccwxhsresponse npccwxhsresponse) {
		this.npccwxhsresponse = npccwxhsresponse;
	}


	public Npccwxhsresponse getNpccwxhsresponse() {
		return npccwxhsresponse;
	}
    
}