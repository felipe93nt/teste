package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/06/18 10:50
 */
public class Modeloboletoinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvnerequest npccwvnerequest = null;
	
	public void setNpccwvnerequest(Npccwvnerequest npccwvnerequest) {
		this.npccwvnerequest = npccwvnerequest;
	}


	public Npccwvnerequest getNpccwvnerequest() {
		return npccwvnerequest;
	}
    
}