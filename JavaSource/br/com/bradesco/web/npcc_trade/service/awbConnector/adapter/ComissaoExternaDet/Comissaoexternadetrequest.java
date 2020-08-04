package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:25
 */
public class Comissaoexternadetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxkerequest npccwxkerequest = null;
	
	public void setNpccwxkerequest(Npccwxkerequest npccwxkerequest) {
		this.npccwxkerequest = npccwxkerequest;
	}


	public Npccwxkerequest getNpccwxkerequest() {
		return npccwxkerequest;
	}
    
}