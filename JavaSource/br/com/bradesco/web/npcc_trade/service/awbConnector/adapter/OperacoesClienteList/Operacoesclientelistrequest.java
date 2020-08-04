package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:30
 */
public class Operacoesclientelistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwwqerequest npccwwqerequest = null;
	
	public void setNpccwwqerequest(Npccwwqerequest npccwwqerequest) {
		this.npccwwqerequest = npccwwqerequest;
	}


	public Npccwwqerequest getNpccwwqerequest() {
		return npccwwqerequest;
	}
    
}