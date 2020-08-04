package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidadeNegocioList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 29/02/16 19:36
 */
public class Unidadenegociolistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwgkerequest npcdwgkerequest = null;
	
	public void setNpcdwgkerequest(Npcdwgkerequest npcdwgkerequest) {
		this.npcdwgkerequest = npcdwgkerequest;
	}


	public Npcdwgkerequest getNpcdwgkerequest() {
		return npcdwgkerequest;
	}
    
}