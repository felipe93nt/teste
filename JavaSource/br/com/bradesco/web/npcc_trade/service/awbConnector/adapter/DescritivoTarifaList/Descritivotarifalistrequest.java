package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/08/18 16:26
 */
public class Descritivotarifalistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwaterequest npccwaterequest = null;
	
	public void setNpccwaterequest(Npccwaterequest npccwaterequest) {
		this.npccwaterequest = npccwaterequest;
	}


	public Npccwaterequest getNpccwaterequest() {
		return npccwaterequest;
	}
    
}