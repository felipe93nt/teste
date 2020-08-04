package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 23/06/16 20:56
 */
public class Fluxopagamentolistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxcerequest npccwxcerequest = null;
	
	public void setNpccwxcerequest(Npccwxcerequest npccwxcerequest) {
		this.npccwxcerequest = npccwxcerequest;
	}


	public Npccwxcerequest getNpccwxcerequest() {
		return npccwxcerequest;
	}
    
}