package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:10
 */
public class Calcvalorescomissintresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwlasresponse npccwlasresponse = null;
	
	public void setNpccwlasresponse(Npccwlasresponse npccwlasresponse) {
		this.npccwlasresponse = npccwlasresponse;
	}


	public Npccwlasresponse getNpccwlasresponse() {
		return npccwlasresponse;
	}
    
}