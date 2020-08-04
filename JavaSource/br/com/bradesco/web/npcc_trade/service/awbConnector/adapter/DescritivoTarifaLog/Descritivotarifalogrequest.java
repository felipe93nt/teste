package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 03/09/18 16:07
 */
public class Descritivotarifalogrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwaxerequest npccwaxerequest = null;
	
	public void setNpccwaxerequest(Npccwaxerequest npccwaxerequest) {
		this.npccwaxerequest = npccwaxerequest;
	}


	public Npccwaxerequest getNpccwaxerequest() {
		return npccwaxerequest;
	}
    
}