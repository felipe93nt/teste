package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/10/18 18:45
 */
public class Parametrounidextdetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwj3erequest npccwj3erequest = null;
	
	public void setNpccwj3erequest(Npccwj3erequest npccwj3erequest) {
		this.npccwj3erequest = npccwj3erequest;
	}


	public Npccwj3erequest getNpccwj3erequest() {
		return npccwj3erequest;
	}
    
}