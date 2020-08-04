package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConfirmaFormalizacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:13
 */
public class Confirmaformalizacaorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwkjerequest npccwkjerequest = null;
	
	public void setNpccwkjerequest(Npccwkjerequest npccwkjerequest) {
		this.npccwkjerequest = npccwkjerequest;
	}


	public Npccwkjerequest getNpccwkjerequest() {
		return npccwkjerequest;
	}
    
}