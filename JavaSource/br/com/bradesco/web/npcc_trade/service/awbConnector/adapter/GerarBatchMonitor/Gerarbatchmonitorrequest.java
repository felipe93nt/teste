package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GerarBatchMonitor;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/05/17 15:56
 */
public class Gerarbatchmonitorrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwkwerequest npccwkwerequest = null;
	
	public void setNpccwkwerequest(Npccwkwerequest npccwkwerequest) {
		this.npccwkwerequest = npccwkwerequest;
	}


	public Npccwkwerequest getNpccwkwerequest() {
		return npccwkwerequest;
	}
    
}