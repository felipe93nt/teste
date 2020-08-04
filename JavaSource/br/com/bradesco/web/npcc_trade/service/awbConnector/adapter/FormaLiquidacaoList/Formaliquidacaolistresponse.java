package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 23/10/15 10:02
 */
public class Formaliquidacaolistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwaasresponse npcdwaasresponse = null;
	
	public void setNpcdwaasresponse(Npcdwaasresponse npcdwaasresponse) {
		this.npcdwaasresponse = npcdwaasresponse;
	}


	public Npcdwaasresponse getNpcdwaasresponse() {
		return npcdwaasresponse;
	}
    
}