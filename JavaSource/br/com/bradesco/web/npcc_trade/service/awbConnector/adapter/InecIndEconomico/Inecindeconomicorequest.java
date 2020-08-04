package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/12/16 11:07
 */
public class Inecindeconomicorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Inecwpaerequest inecwpaerequest = null;
	
	public void setInecwpaerequest(Inecwpaerequest inecwpaerequest) {
		this.inecwpaerequest = inecwpaerequest;
	}


	public Inecwpaerequest getInecwpaerequest() {
		return inecwpaerequest;
	}
    
}