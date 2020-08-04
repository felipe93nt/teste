package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/17 09:29
 */
public class Obtercomissaointernaresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwxesresponse npccwxesresponse = null;
	
	public void setNpccwxesresponse(Npccwxesresponse npccwxesresponse) {
		this.npccwxesresponse = npccwxesresponse;
	}


	public Npccwxesresponse getNpccwxesresponse() {
		return npccwxesresponse;
	}
    
}