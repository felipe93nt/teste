package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 11:39
 */
public class Alterarcustoexternoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwygsresponse npccwygsresponse = null;
	
	public void setNpccwygsresponse(Npccwygsresponse npccwygsresponse) {
		this.npccwygsresponse = npccwygsresponse;
	}


	public Npccwygsresponse getNpccwygsresponse() {
		return npccwygsresponse;
	}
    
}