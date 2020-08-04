package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Incl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 10:39
 */
public class Dadosbasegp1gp3inclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv2erequest npccwv2erequest = null;
	
	public void setNpccwv2erequest(Npccwv2erequest npccwv2erequest) {
		this.npccwv2erequest = npccwv2erequest;
	}


	public Npccwv2erequest getNpccwv2erequest() {
		return npccwv2erequest;
	}
    
}