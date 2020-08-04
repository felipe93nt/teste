package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/12/15 15:47
 */
public class Tipoclausulalistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvaerequest npccwvaerequest = null;
	
	public void setNpccwvaerequest(Npccwvaerequest npccwvaerequest) {
		this.npccwvaerequest = npccwvaerequest;
	}


	public Npccwvaerequest getNpccwvaerequest() {
		return npccwvaerequest;
	}
    
}