package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoExcl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/12/15 16:51
 */
public class Modeloboletoexclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvqerequest npccwvqerequest = null;
	
	public void setNpccwvqerequest(Npccwvqerequest npccwvqerequest) {
		this.npccwvqerequest = npccwvqerequest;
	}


	public Npccwvqerequest getNpccwvqerequest() {
		return npccwvqerequest;
	}
    
}