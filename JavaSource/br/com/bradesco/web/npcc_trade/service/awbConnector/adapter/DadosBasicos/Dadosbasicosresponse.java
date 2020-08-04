package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;

/**
 * Arquivo gerado automaticamente em 31/07/18 09:11
 */
public class Dadosbasicosresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx1sresponse npccwx1sresponse = null;
	
	public void setNpccwx1sresponse(Npccwx1sresponse npccwx1sresponse) {
		this.npccwx1sresponse = npccwx1sresponse;
	}


	public Npccwx1sresponse getNpccwx1sresponse() {
		return npccwx1sresponse;
	}
    
}