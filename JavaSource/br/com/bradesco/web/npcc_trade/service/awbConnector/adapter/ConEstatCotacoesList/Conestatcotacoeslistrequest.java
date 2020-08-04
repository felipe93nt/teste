package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 25/10/16 17:51
 */
public class Conestatcotacoeslistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzderequest npccwzderequest = null;
	
	public void setNpccwzderequest(Npccwzderequest npccwzderequest) {
		this.npccwzderequest = npccwzderequest;
	}


	public Npccwzderequest getNpccwzderequest() {
		return npccwzderequest;
	}
    
}