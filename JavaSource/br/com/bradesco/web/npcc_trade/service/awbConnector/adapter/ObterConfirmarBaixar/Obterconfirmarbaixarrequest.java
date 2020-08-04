package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarBaixar;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/01/17 12:51
 */
public class Obterconfirmarbaixarrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxterequest npccwxterequest = null;
	
	public void setNpccwxterequest(Npccwxterequest npccwxterequest) {
		this.npccwxterequest = npccwxterequest;
	}


	public Npccwxterequest getNpccwxterequest() {
		return npccwxterequest;
	}
    
}