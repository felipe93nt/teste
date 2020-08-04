package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/06/16 17:23
 */
public class Combomodalidaderequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwicerequest npccwicerequest = null;
	
	public void setNpccwicerequest(Npccwicerequest npccwicerequest) {
		this.npccwicerequest = npccwicerequest;
	}


	public Npccwicerequest getNpccwicerequest() {
		return npccwicerequest;
	}
    
}