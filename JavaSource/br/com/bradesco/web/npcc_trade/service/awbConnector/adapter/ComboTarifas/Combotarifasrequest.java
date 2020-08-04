package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 30/03/16 14:37
 */
public class Combotarifasrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwieerequest npccwieerequest = null;
	
	public void setNpccwieerequest(Npccwieerequest npccwieerequest) {
		this.npccwieerequest = npccwieerequest;
	}


	public Npccwieerequest getNpccwieerequest() {
		return npccwieerequest;
	}
    
}