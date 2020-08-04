package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AtualizarTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 11:12
 */
public class Atualizartarifasresponse extends FRWKGL01Response {

	@Adapter(isTransactionBlock = true)
	private Npcdwn1sresponse npcdwn1sresponse = null;

	public void setNpcdwn1sresponse(Npcdwn1sresponse npcdwn1sresponse) {
		this.npcdwn1sresponse = npcdwn1sresponse;
	}

	public Npcdwn1sresponse getNpcdwn1sresponse() {
		return npcdwn1sresponse;
	}

}