package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/05/16 20:29
 */
public class Taxasforfaitingcalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzcerequest npccwzcerequest = null;
	
	public void setNpccwzcerequest(Npccwzcerequest npccwzcerequest) {
		this.npccwzcerequest = npccwzcerequest;
	}


	public Npccwzcerequest getNpccwzcerequest() {
		return npccwzcerequest;
	}
    
}