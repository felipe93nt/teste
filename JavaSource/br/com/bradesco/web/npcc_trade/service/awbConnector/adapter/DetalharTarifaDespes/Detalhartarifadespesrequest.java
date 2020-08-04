package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/16 15:38
 */
public class Detalhartarifadespesrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwiderequest npccwiderequest = null;
	
	public void setNpccwiderequest(Npccwiderequest npccwiderequest) {
		this.npccwiderequest = npccwiderequest;
	}


	public Npccwiderequest getNpccwiderequest() {
		return npccwiderequest;
	}
    
}