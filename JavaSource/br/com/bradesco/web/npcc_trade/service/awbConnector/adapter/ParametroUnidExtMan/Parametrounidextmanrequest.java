package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParametroUnidExtMan;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/10/18 15:12
 */
public class Parametrounidextmanrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwj7erequest npccwj7erequest = null;
	
	public void setNpccwj7erequest(Npccwj7erequest npccwj7erequest) {
		this.npccwj7erequest = npccwj7erequest;
	}


	public Npccwj7erequest getNpccwj7erequest() {
		return npccwj7erequest;
	}
    
}