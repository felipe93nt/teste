package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsMan;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/11/18 18:01
 */
public class Comissaodesembolsmanrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwj4erequest npccwj4erequest = null;
	
	public void setNpccwj4erequest(Npccwj4erequest npccwj4erequest) {
		this.npccwj4erequest = npccwj4erequest;
	}


	public Npccwj4erequest getNpccwj4erequest() {
		return npccwj4erequest;
	}
    
}