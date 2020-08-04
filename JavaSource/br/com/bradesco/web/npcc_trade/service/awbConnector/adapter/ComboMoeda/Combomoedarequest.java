package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 18:35
 */
public class Combomoedarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwazerequest npcdwazerequest = null;
	
	public void setNpcdwazerequest(Npcdwazerequest npcdwazerequest) {
		this.npcdwazerequest = npcdwazerequest;
	}


	public Npcdwazerequest getNpcdwazerequest() {
		return npcdwazerequest;
	}
    
}