package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaExcl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 02/12/15 08:52
 */
public class Tipoclausulaexclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvesresponse npccwvesresponse = null;
	
	public void setNpccwvesresponse(Npccwvesresponse npccwvesresponse) {
		this.npccwvesresponse = npccwvesresponse;
	}


	public Npccwvesresponse getNpccwvesresponse() {
		return npccwvesresponse;
	}
    
}