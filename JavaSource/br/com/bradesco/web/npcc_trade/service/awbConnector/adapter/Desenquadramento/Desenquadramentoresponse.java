package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Desenquadramentoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwmnsresponse npccwmnsresponse = null;
	
	public void setNpccwmnsresponse(Npccwmnsresponse npccwmnsresponse) {
		this.npccwmnsresponse = npccwmnsresponse;
	}


	public Npccwmnsresponse getNpccwmnsresponse() {
		return npccwmnsresponse;
	}
    
}