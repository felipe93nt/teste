package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 11:13
 */
public class Descritivotarifainclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwaaerequest npccwaaerequest = null;
	
	public void setNpccwaaerequest(Npccwaaerequest npccwaaerequest) {
		this.npccwaaerequest = npccwaaerequest;
	}


	public Npccwaaerequest getNpccwaaerequest() {
		return npccwaaerequest;
	}
    
}