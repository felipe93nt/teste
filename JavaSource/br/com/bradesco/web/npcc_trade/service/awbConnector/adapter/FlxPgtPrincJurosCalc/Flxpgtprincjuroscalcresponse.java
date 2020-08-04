package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/10/19 13:20
 */
public class Flxpgtprincjuroscalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwvsresponse npccwwvsresponse = null;
	
	public void setNpccwwvsresponse(Npccwwvsresponse npccwwvsresponse) {
		this.npccwwvsresponse = npccwwvsresponse;
	}


	public Npccwwvsresponse getNpccwwvsresponse() {
		return npccwwvsresponse;
	}
    
}