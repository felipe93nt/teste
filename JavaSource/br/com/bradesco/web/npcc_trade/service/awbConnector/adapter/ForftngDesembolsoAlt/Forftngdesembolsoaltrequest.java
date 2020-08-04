package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ForftngDesembolsoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/09/16 17:33
 */
public class Forftngdesembolsoaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyqerequest npccwyqerequest = null;
	
	public void setNpccwyqerequest(Npccwyqerequest npccwyqerequest) {
		this.npccwyqerequest = npccwyqerequest;
	}


	public Npccwyqerequest getNpccwyqerequest() {
		return npccwyqerequest;
	}
    
}