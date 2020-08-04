package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 11/01/16 14:08
 */
public class Convvlrpramoedalimitrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwzerequest npccwwzerequest = null;
	
	public void setNpccwwzerequest(Npccwwzerequest npccwwzerequest) {
		this.npccwwzerequest = npccwwzerequest;
	}


	public Npccwwzerequest getNpccwwzerequest() {
		return npccwwzerequest;
	}
    
}