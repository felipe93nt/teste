package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/10/18 17:22
 */
public class Parametrounidextlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwj2erequest npccwj2erequest = null;
	
	public void setNpccwj2erequest(Npccwj2erequest npccwj2erequest) {
		this.npccwj2erequest = npccwj2erequest;
	}


	public Npccwj2erequest getNpccwj2erequest() {
		return npccwj2erequest;
	}
    
}