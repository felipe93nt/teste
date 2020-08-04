package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/06/18 09:46
 */
public class Modeloboletolistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvmerequest npccwvmerequest = null;
	
	public void setNpccwvmerequest(Npccwvmerequest npccwvmerequest) {
		this.npccwvmerequest = npccwvmerequest;
	}


	public Npccwvmerequest getNpccwvmerequest() {
		return npccwvmerequest;
	}
    
}