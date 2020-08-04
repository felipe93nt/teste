package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/16 15:38
 */
public class Detalhartarifadespesresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwidsresponse npccwidsresponse = null;
	
	public void setNpccwidsresponse(Npccwidsresponse npccwidsresponse) {
		this.npccwidsresponse = npccwidsresponse;
	}


	public Npccwidsresponse getNpccwidsresponse() {
		return npccwidsresponse;
	}
    
}