package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/05/16 20:29
 */
public class Taxasforfaitingcalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzcsresponse npccwzcsresponse = null;
	
	public void setNpccwzcsresponse(Npccwzcsresponse npccwzcsresponse) {
		this.npccwzcsresponse = npccwzcsresponse;
	}


	public Npccwzcsresponse getNpccwzcsresponse() {
		return npccwzcsresponse;
	}
    
}