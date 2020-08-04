package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 10:29
 */
public class Combosegmentorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwh8erequest npccwh8erequest = null;
	
	public void setNpccwh8erequest(Npccwh8erequest npccwh8erequest) {
		this.npccwh8erequest = npccwh8erequest;
	}


	public Npccwh8erequest getNpccwh8erequest() {
		return npccwh8erequest;
	}
    
}