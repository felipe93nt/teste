package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesClienteList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:30
 */
public class Operacoesclientelistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwwqsresponse npccwwqsresponse = null;
	
	public void setNpccwwqsresponse(Npccwwqsresponse npccwwqsresponse) {
		this.npccwwqsresponse = npccwwqsresponse;
	}


	public Npccwwqsresponse getNpccwwqsresponse() {
		return npccwwqsresponse;
	}
    
}