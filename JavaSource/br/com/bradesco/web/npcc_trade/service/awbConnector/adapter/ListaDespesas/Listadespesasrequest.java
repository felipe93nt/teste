package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaDespesas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/10/16 09:54
 */
public class Listadespesasrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyberequest npccwyberequest = null;
	
	public void setNpccwyberequest(Npccwyberequest npccwyberequest) {
		this.npccwyberequest = npccwyberequest;
	}


	public Npccwyberequest getNpccwyberequest() {
		return npccwyberequest;
	}
    
}