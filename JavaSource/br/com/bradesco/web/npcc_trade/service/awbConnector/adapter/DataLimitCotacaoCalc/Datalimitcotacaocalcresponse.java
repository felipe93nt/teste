package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/04/16 11:04
 */
public class Datalimitcotacaocalcresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwhfsresponse npccwhfsresponse = null;
	
	public void setNpccwhfsresponse(Npccwhfsresponse npccwhfsresponse) {
		this.npccwhfsresponse = npccwhfsresponse;
	}


	public Npccwhfsresponse getNpccwhfsresponse() {
		return npccwhfsresponse;
	}
    
}