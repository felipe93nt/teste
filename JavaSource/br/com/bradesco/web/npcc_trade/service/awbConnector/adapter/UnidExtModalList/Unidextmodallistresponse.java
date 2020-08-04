package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/16 08:46
 */
public class Unidextmodallistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwfgsresponse npcdwfgsresponse = null;
	
	public void setNpcdwfgsresponse(Npcdwfgsresponse npcdwfgsresponse) {
		this.npcdwfgsresponse = npcdwfgsresponse;
	}


	public Npcdwfgsresponse getNpcdwfgsresponse() {
		return npcdwfgsresponse;
	}
    
}