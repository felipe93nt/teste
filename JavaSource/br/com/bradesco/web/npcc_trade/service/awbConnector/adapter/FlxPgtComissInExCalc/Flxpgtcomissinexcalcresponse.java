package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:06
 */
public class Flxpgtcomissinexcalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwmsresponse npccwwmsresponse = null;
	
	public void setNpccwwmsresponse(Npccwwmsresponse npccwwmsresponse) {
		this.npccwwmsresponse = npccwwmsresponse;
	}


	public Npccwwmsresponse getNpccwwmsresponse() {
		return npccwwmsresponse;
	}
    
}