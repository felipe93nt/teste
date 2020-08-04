package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 08:12
 */
public class Garantiaadicionaconsrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwyperequest npccwyperequest = null;
	
	public void setNpccwyperequest(Npccwyperequest npccwyperequest) {
		this.npccwyperequest = npccwyperequest;
	}


	public Npccwyperequest getNpccwyperequest() {
		return npccwyperequest;
	}
    
}