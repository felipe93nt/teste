package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/09/16 12:52
 */
public class Operacoespendtotaisresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwzosresponse npccwzosresponse = null;
	
	public void setNpccwzosresponse(Npccwzosresponse npccwzosresponse) {
		this.npccwzosresponse = npccwzosresponse;
	}


	public Npccwzosresponse getNpccwzosresponse() {
		return npccwzosresponse;
	}
    
}