package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 09:55
 */
public class Descritivotarifaaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwanerequest npccwanerequest = null;
	
	public void setNpccwanerequest(Npccwanerequest npccwanerequest) {
		this.npccwanerequest = npccwanerequest;
	}


	public Npccwanerequest getNpccwanerequest() {
		return npccwanerequest;
	}
    
}