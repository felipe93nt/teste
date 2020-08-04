package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/11/16 15:10
 */
public class Opervinculadalcinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccww7erequest npccww7erequest = null;
	
	public void setNpccww7erequest(Npccww7erequest npccww7erequest) {
		this.npccww7erequest = npccww7erequest;
	}


	public Npccww7erequest getNpccww7erequest() {
		return npccww7erequest;
	}
    
}