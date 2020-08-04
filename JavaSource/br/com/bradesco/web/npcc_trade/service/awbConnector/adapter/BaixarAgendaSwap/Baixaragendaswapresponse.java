package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixarAgendaSwap;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/09/16 10:28
 */
public class Baixaragendaswapresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzrsresponse npccwzrsresponse = null;
	
	public void setNpccwzrsresponse(Npccwzrsresponse npccwzrsresponse) {
		this.npccwzrsresponse = npccwzrsresponse;
	}


	public Npccwzrsresponse getNpccwzrsresponse() {
		return npccwzrsresponse;
	}
    
}