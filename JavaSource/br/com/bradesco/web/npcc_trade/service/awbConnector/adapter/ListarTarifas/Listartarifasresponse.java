package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 18:02
 */
public class Listartarifasresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwn0sresponse npcdwn0sresponse = null;
	
	public void setNpcdwn0sresponse(Npcdwn0sresponse npcdwn0sresponse) {
		this.npcdwn0sresponse = npcdwn0sresponse;
	}


	public Npcdwn0sresponse getNpcdwn0sresponse() {
		return npcdwn0sresponse;
	}
    
}