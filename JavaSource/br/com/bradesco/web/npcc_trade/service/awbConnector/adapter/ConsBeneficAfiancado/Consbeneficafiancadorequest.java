package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 05/09/16 10:19
 */
public class Consbeneficafiancadorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzmerequest npccwzmerequest = null;
	
	public void setNpccwzmerequest(Npccwzmerequest npccwzmerequest) {
		this.npccwzmerequest = npccwzmerequest;
	}


	public Npccwzmerequest getNpccwzmerequest() {
		return npccwzmerequest;
	}
    
}