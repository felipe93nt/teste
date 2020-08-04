package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/06/16 11:10
 */
public class Incluirparcelalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv1erequest npccwv1erequest = null;
	
	public void setNpccwv1erequest(Npccwv1erequest npccwv1erequest) {
		this.npccwv1erequest = npccwv1erequest;
	}


	public Npccwv1erequest getNpccwv1erequest() {
		return npccwv1erequest;
	}
    
}