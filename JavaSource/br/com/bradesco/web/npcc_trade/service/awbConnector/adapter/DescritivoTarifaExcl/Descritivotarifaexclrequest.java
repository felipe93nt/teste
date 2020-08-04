package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaExcl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 10:03
 */
public class Descritivotarifaexclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwaqerequest npccwaqerequest = null;
	
	public void setNpccwaqerequest(Npccwaqerequest npccwaqerequest) {
		this.npccwaqerequest = npccwaqerequest;
	}


	public Npccwaqerequest getNpccwaqerequest() {
		return npccwaqerequest;
	}
    
}