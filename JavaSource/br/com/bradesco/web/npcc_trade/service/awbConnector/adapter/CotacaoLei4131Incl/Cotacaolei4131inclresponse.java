package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoLei4131Incl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 11:40
 */
public class Cotacaolei4131inclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npccwv0sresponse npccwv0sresponse = null;
	
	public void setNpccwv0sresponse(Npccwv0sresponse npccwv0sresponse) {
		this.npccwv0sresponse = npccwv0sresponse;
	}


	public Npccwv0sresponse getNpccwv0sresponse() {
		return npccwv0sresponse;
	}
    
}