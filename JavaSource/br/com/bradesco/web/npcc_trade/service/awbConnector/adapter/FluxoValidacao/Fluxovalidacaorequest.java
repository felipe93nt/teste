package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/11/18 23:58
 */
public class Fluxovalidacaorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwx2erequest npccwx2erequest = null;
	
	public void setNpccwx2erequest(Npccwx2erequest npccwx2erequest) {
		this.npccwx2erequest = npccwx2erequest;
	}


	public Npccwx2erequest getNpccwx2erequest() {
		return npccwx2erequest;
	}
    
}