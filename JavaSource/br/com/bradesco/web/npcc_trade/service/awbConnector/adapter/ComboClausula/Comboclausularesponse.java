package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboClausula;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/01/16 11:29
 */
public class Comboclausularesponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvssresponse npccwvssresponse = null;
	
	public void setNpccwvssresponse(Npccwvssresponse npccwvssresponse) {
		this.npccwvssresponse = npccwvssresponse;
	}


	public Npccwvssresponse getNpccwvssresponse() {
		return npccwvssresponse;
	}
    
}