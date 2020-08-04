package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:41
 */
public class Fndrflxpgtcmssininclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwylerequest npccwylerequest = null;
	
	public void setNpccwylerequest(Npccwylerequest npccwylerequest) {
		this.npccwylerequest = npccwylerequest;
	}


	public Npccwylerequest getNpccwylerequest() {
		return npccwylerequest;
	}
    
}