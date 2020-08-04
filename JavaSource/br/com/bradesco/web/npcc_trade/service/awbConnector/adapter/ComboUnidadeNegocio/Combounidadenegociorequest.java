package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 16/06/16 12:08
 */
public class Combounidadenegociorequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzkerequest npccwzkerequest = null;
	
	public void setNpccwzkerequest(Npccwzkerequest npccwzkerequest) {
		this.npccwzkerequest = npccwzkerequest;
	}


	public Npccwzkerequest getNpccwzkerequest() {
		return npccwzkerequest;
	}
    
}