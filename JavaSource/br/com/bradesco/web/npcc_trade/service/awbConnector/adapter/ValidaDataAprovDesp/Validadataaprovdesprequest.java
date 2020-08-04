package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/11/16 11:32
 */
public class Validadataaprovdesprequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww3erequest npccww3erequest = null;
	
	public void setNpccww3erequest(Npccww3erequest npccww3erequest) {
		this.npccww3erequest = npccww3erequest;
	}


	public Npccww3erequest getNpccww3erequest() {
		return npccww3erequest;
	}
    
}