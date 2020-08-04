package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/01/16 14:08
 */
public class Convvlrpramoedalimitresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwzsresponse npccwwzsresponse = null;
	
	public void setNpccwwzsresponse(Npccwwzsresponse npccwwzsresponse) {
		this.npccwwzsresponse = npccwwzsresponse;
	}


	public Npccwwzsresponse getNpccwwzsresponse() {
		return npccwwzsresponse;
	}
    
}