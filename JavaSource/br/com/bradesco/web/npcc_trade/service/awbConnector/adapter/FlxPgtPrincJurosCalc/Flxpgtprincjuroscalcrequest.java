package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtPrincJurosCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/10/19 13:20
 */
public class Flxpgtprincjuroscalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwverequest npccwwverequest = null;
	
	public void setNpccwwverequest(Npccwwverequest npccwwverequest) {
		this.npccwwverequest = npccwwverequest;
	}


	public Npccwwverequest getNpccwwverequest() {
		return npccwwverequest;
	}
    
}