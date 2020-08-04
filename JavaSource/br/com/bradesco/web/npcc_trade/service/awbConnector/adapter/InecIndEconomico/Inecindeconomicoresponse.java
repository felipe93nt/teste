package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/12/16 11:07
 */
public class Inecindeconomicoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Inecwpasresponse inecwpasresponse = null;
	
	public void setInecwpasresponse(Inecwpasresponse inecwpasresponse) {
		this.inecwpasresponse = inecwpasresponse;
	}


	public Inecwpasresponse getInecwpasresponse() {
		return inecwpasresponse;
	}
    
}