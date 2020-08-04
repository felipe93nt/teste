package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/05/17 16:44
 */
public class Consultapilotorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwcderequest npccwcderequest = null;
	
	public void setNpccwcderequest(Npccwcderequest npccwcderequest) {
		this.npccwcderequest = npccwcderequest;
	}


	public Npccwcderequest getNpccwcderequest() {
		return npccwcderequest;
	}
    
}