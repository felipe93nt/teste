package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/12/15 15:56
 */
public class Tipoclausulainclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwvbsresponse npccwvbsresponse = null;
	
	public void setNpccwvbsresponse(Npccwvbsresponse npccwvbsresponse) {
		this.npccwvbsresponse = npccwvbsresponse;
	}


	public Npccwvbsresponse getNpccwvbsresponse() {
		return npccwvbsresponse;
	}
    
}