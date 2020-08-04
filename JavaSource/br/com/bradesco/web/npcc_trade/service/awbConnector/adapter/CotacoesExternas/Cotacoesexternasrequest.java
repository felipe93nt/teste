package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 31/10/17 12:30
 */
public class Cotacoesexternasrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyderequest npccwyderequest = null;
	
	public void setNpccwyderequest(Npccwyderequest npccwyderequest) {
		this.npccwyderequest = npccwyderequest;
	}


	public Npccwyderequest getNpccwyderequest() {
		return npccwyderequest;
	}
    
}