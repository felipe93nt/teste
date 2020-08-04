package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 24/06/16 14:20
 */
public class Listarhistoricotarifresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzusresponse npccwzusresponse = null;
	
	public void setNpccwzusresponse(Npccwzusresponse npccwzusresponse) {
		this.npccwzusresponse = npccwzusresponse;
	}


	public Npccwzusresponse getNpccwzusresponse() {
		return npccwzusresponse;
	}
    
}