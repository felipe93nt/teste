package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Fndrgrtvnctrfobsinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwynerequest npccwynerequest = null;
	
	public void setNpccwynerequest(Npccwynerequest npccwynerequest) {
		this.npccwynerequest = npccwynerequest;
	}


	public Npccwynerequest getNpccwynerequest() {
		return npccwynerequest;
	}
    
}