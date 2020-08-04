package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 16/06/16 15:09
 */
public class Calcularsomatoriarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwv8erequest npccwv8erequest = null;
	
	public void setNpccwv8erequest(Npccwv8erequest npccwv8erequest) {
		this.npccwv8erequest = npccwv8erequest;
	}


	public Npccwv8erequest getNpccwv8erequest() {
		return npccwv8erequest;
	}
    
}