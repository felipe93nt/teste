package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Arquivo gerado automaticamente em 24/06/16 14:20
 */
public class Listarhistoricotarifrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwzuerequest npccwzuerequest = null;
	
	public void setNpccwzuerequest(Npccwzuerequest npccwzuerequest) {
		this.npccwzuerequest = npccwzuerequest;
	}


	public Npccwzuerequest getNpccwzuerequest() {
		return npccwzuerequest;
	}
    
}