package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 17:35
 */
public class Consultasdivisaointrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzlerequest npccwzlerequest = null;
	
	public void setNpccwzlerequest(Npccwzlerequest npccwzlerequest) {
		this.npccwzlerequest = npccwzlerequest;
	}


	public Npccwzlerequest getNpccwzlerequest() {
		return npccwzlerequest;
	}
    
}