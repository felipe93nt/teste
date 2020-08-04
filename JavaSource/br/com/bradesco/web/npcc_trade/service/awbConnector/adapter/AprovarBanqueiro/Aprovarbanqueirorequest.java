package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AprovarBanqueiro;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/08/16 18:13
 */
public class Aprovarbanqueirorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwycerequest npccwycerequest = null;
	
	public void setNpccwycerequest(Npccwycerequest npccwycerequest) {
		this.npccwycerequest = npccwycerequest;
	}


	public Npccwycerequest getNpccwycerequest() {
		return npccwycerequest;
	}
    
}