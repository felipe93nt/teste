package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 15:30
 */
public class Combopaisrestricaorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwperequest npccwwperequest = null;
	
	public void setNpccwwperequest(Npccwwperequest npccwwperequest) {
		this.npccwwperequest = npccwwperequest;
	}


	public Npccwwperequest getNpccwwperequest() {
		return npccwwperequest;
	}
    
}