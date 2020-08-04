package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/11/18 16:58
 */
public class Comissaodesembolsdetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwj6erequest npccwj6erequest = null;
	
	public void setNpccwj6erequest(Npccwj6erequest npccwj6erequest) {
		this.npccwj6erequest = npccwj6erequest;
	}


	public Npccwj6erequest getNpccwj6erequest() {
		return npccwj6erequest;
	}
    
}