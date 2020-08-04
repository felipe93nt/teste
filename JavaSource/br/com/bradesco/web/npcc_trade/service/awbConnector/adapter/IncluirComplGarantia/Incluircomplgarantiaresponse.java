package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirComplGarantia;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/07/16 21:26
 */
public class Incluircomplgarantiaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyisresponse npccwyisresponse = null;
	
	public void setNpccwyisresponse(Npccwyisresponse npccwyisresponse) {
		this.npccwyisresponse = npccwyisresponse;
	}


	public Npccwyisresponse getNpccwyisresponse() {
		return npccwyisresponse;
	}
    
}