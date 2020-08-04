package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 17/10/16 11:15
 */
public class Cotacoesdivergentesrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyherequest npccwyherequest = null;
	
	public void setNpccwyherequest(Npccwyherequest npccwyherequest) {
		this.npccwyherequest = npccwyherequest;
	}


	public Npccwyherequest getNpccwyherequest() {
		return npccwyherequest;
	}
    
}