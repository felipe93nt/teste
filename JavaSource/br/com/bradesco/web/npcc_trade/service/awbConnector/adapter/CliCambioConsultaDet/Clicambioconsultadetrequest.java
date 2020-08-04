package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Clicambioconsultadetrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdweyerequest npcdweyerequest = null;
	
	public void setNpcdweyerequest(Npcdweyerequest npcdweyerequest) {
		this.npcdweyerequest = npcdweyerequest;
	}


	public Npcdweyerequest getNpcdweyerequest() {
		return npcdweyerequest;
	}
    
}