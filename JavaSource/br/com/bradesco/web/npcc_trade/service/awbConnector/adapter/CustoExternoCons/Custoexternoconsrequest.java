package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoExternoCons;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 15/04/16 12:32
 */
public class Custoexternoconsrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyrerequest npccwyrerequest = null;
	
	public void setNpccwyrerequest(Npccwyrerequest npccwyrerequest) {
		this.npccwyrerequest = npccwyrerequest;
	}


	public Npccwyrerequest getNpccwyrerequest() {
		return npccwyrerequest;
	}
    
}