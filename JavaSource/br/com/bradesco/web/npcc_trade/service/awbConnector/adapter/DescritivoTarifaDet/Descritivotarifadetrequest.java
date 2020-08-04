package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 10:05
 */
public class Descritivotarifadetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwaoerequest npccwaoerequest = null;
	
	public void setNpccwaoerequest(Npccwaoerequest npccwaoerequest) {
		this.npccwaoerequest = npccwaoerequest;
	}


	public Npccwaoerequest getNpccwaoerequest() {
		return npccwaoerequest;
	}
    
}