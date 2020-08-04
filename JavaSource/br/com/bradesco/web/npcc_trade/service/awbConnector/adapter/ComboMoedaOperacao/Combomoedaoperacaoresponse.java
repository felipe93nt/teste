package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 17/12/15 15:08
 */
public class Combomoedaoperacaoresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwh6sresponse npccwh6sresponse = null;
	
	public void setNpccwh6sresponse(Npccwh6sresponse npccwh6sresponse) {
		this.npccwh6sresponse = npccwh6sresponse;
	}


	public Npccwh6sresponse getNpccwh6sresponse() {
		return npccwh6sresponse;
	}
    
}