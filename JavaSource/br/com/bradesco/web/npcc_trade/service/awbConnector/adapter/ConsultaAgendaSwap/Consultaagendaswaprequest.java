package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/09/16 16:40
 */
public class Consultaagendaswaprequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzqerequest npccwzqerequest = null;
	
	public void setNpccwzqerequest(Npccwzqerequest npccwzqerequest) {
		this.npccwzqerequest = npccwzqerequest;
	}


	public Npccwzqerequest getNpccwzqerequest() {
		return npccwzqerequest;
	}
    
}