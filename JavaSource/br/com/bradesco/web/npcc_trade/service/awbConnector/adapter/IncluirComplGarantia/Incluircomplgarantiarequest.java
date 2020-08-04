package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirComplGarantia;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 13/07/16 21:26
 */
public class Incluircomplgarantiarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyierequest npccwyierequest = null;
	
	public void setNpccwyierequest(Npccwyierequest npccwyierequest) {
		this.npccwyierequest = npccwyierequest;
	}


	public Npccwyierequest getNpccwyierequest() {
		return npccwyierequest;
	}
    
}