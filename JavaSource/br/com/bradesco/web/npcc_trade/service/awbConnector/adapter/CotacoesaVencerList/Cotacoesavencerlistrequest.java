package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesaVencerList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/11/17 16:31
 */
public class Cotacoesavencerlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzjerequest npccwzjerequest = null;
	
	public void setNpccwzjerequest(Npccwzjerequest npccwzjerequest) {
		this.npccwzjerequest = npccwzjerequest;
	}


	public Npccwzjerequest getNpccwzjerequest() {
		return npccwzjerequest;
	}
    
}