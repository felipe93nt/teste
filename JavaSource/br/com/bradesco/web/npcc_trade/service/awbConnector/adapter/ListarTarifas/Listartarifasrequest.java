package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 18:02
 */
public class Listartarifasrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwn0erequest npcdwn0erequest = null;
	
	public void setNpcdwn0erequest(Npcdwn0erequest npcdwn0erequest) {
		this.npcdwn0erequest = npcdwn0erequest;
	}


	public Npcdwn0erequest getNpcdwn0erequest() {
		return npcdwn0erequest;
	}
    
}