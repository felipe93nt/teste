package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncAltFundingDespLC;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/11/16 15:05
 */
public class Incaltfundingdesplcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv6sresponse npccwv6sresponse = null;
	
	public void setNpccwv6sresponse(Npccwv6sresponse npccwv6sresponse) {
		this.npccwv6sresponse = npccwv6sresponse;
	}


	public Npccwv6sresponse getNpccwv6sresponse() {
		return npccwv6sresponse;
	}
    
}