package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/04/17 15:21
 */
public class Operacoespendlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwznerequest npccwznerequest = null;
	
	public void setNpccwznerequest(Npccwznerequest npccwznerequest) {
		this.npccwznerequest = npccwznerequest;
	}


	public Npccwznerequest getNpccwznerequest() {
		return npccwznerequest;
	}
    
}