package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesfazimentoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/12/16 14:09
 */
public class Desfazimentoinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccw0cerequest npccw0cerequest = null;
	
	public void setNpccw0cerequest(Npccw0cerequest npccw0cerequest) {
		this.npccw0cerequest = npccw0cerequest;
	}


	public Npccw0cerequest getNpccw0cerequest() {
		return npccw0cerequest;
	}
    
}