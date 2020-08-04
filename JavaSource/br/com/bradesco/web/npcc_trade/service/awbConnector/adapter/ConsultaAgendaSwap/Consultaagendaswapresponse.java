package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/09/16 16:40
 */
public class Consultaagendaswapresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzqsresponse npccwzqsresponse = null;
	
	public void setNpccwzqsresponse(Npccwzqsresponse npccwzqsresponse) {
		this.npccwzqsresponse = npccwzqsresponse;
	}


	public Npccwzqsresponse getNpccwzqsresponse() {
		return npccwzqsresponse;
	}
    
}