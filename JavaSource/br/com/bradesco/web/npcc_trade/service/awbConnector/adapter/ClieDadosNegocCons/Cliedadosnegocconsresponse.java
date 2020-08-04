package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:55
 */
public class Cliedadosnegocconsresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxbsresponse npccwxbsresponse = null;
	
	public void setNpccwxbsresponse(Npccwxbsresponse npccwxbsresponse) {
		this.npccwxbsresponse = npccwxbsresponse;
	}


	public Npccwxbsresponse getNpccwxbsresponse() {
		return npccwxbsresponse;
	}
    
}