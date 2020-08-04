package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/07/18 11:13
 */
public class Modeloboletodetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvoerequest npccwvoerequest = null;
	
	public void setNpccwvoerequest(Npccwvoerequest npccwvoerequest) {
		this.npccwvoerequest = npccwvoerequest;
	}


	public Npccwvoerequest getNpccwvoerequest() {
		return npccwvoerequest;
	}
    
}