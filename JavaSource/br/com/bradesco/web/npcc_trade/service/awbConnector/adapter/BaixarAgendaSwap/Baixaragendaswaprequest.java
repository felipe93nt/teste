package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixarAgendaSwap;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 14/09/16 10:28
 */
public class Baixaragendaswaprequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzrerequest npccwzrerequest = null;
	
	public void setNpccwzrerequest(Npccwzrerequest npccwzrerequest) {
		this.npccwzrerequest = npccwzrerequest;
	}


	public Npccwzrerequest getNpccwzrerequest() {
		return npccwzrerequest;
	}
    
}