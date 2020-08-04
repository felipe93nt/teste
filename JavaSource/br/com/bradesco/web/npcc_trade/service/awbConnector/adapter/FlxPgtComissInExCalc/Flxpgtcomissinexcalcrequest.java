package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FlxPgtComissInExCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:06
 */
public class Flxpgtcomissinexcalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwmerequest npccwwmerequest = null;
	
	public void setNpccwwmerequest(Npccwwmerequest npccwwmerequest) {
		this.npccwwmerequest = npccwwmerequest;
	}


	public Npccwwmerequest getNpccwwmerequest() {
		return npccwwmerequest;
	}
    
}