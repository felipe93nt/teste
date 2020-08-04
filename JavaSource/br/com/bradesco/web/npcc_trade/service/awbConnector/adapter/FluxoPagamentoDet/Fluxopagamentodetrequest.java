package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/08/16 14:53
 */
public class Fluxopagamentodetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxderequest npccwxderequest = null;
	
	public void setNpccwxderequest(Npccwxderequest npccwxderequest) {
		this.npccwxderequest = npccwxderequest;
	}


	public Npccwxderequest getNpccwxderequest() {
		return npccwxderequest;
	}
    
}