package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 09/08/17 18:19
 */
public class Garantiasreccotlistrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwpperequest npccwpperequest = null;
	
	public void setNpccwpperequest(Npccwpperequest npccwpperequest) {
		this.npccwpperequest = npccwpperequest;
	}


	public Npccwpperequest getNpccwpperequest() {
		return npccwpperequest;
	}
    
}