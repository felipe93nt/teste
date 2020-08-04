package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaLogAgexList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 15:20
 */
public class Consultalogagexlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwn7erequest npccwn7erequest = null;
	
	public void setNpccwn7erequest(Npccwn7erequest npccwn7erequest) {
		this.npccwn7erequest = npccwn7erequest;
	}


	public Npccwn7erequest getNpccwn7erequest() {
		return npccwn7erequest;
	}
    
}