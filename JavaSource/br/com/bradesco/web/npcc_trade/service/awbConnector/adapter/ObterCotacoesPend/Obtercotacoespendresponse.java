package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 12:50
 */
public class Obtercotacoespendresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwyesresponse npccwyesresponse = null;
	
	public void setNpccwyesresponse(Npccwyesresponse npccwyesresponse) {
		this.npccwyesresponse = npccwyesresponse;
	}


	public Npccwyesresponse getNpccwyesresponse() {
		return npccwyesresponse;
	}
    
}