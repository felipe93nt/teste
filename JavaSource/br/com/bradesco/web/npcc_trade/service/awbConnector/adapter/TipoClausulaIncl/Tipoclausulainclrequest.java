package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 08/12/15 15:56
 */
public class Tipoclausulainclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwvberequest npccwvberequest = null;
	
	public void setNpccwvberequest(Npccwvberequest npccwvberequest) {
		this.npccwvberequest = npccwvberequest;
	}


	public Npccwvberequest getNpccwvberequest() {
		return npccwvberequest;
	}
    
}