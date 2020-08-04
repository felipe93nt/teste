package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/12/15 15:47
 */
public class Tipoclausulalistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvasresponse npccwvasresponse = null;
	
	public void setNpccwvasresponse(Npccwvasresponse npccwvasresponse) {
		this.npccwvasresponse = npccwvasresponse;
	}


	public Npccwvasresponse getNpccwvasresponse() {
		return npccwvasresponse;
	}
    
}