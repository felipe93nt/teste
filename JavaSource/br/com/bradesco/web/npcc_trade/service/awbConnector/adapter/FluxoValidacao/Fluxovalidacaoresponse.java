package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoValidacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 10/11/18 23:58
 */
public class Fluxovalidacaoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwx2sresponse npccwx2sresponse = null;
	
	public void setNpccwx2sresponse(Npccwx2sresponse npccwx2sresponse) {
		this.npccwx2sresponse = npccwx2sresponse;
	}


	public Npccwx2sresponse getNpccwx2sresponse() {
		return npccwx2sresponse;
	}
    
}