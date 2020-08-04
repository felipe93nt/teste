package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarLogTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 10:48
 */
public class Listarlogtarifasresponse extends FRWKGL01Response {

	@Adapter(isTransactionBlock = true)
	private Npcdwn2sresponse npcdwn2sresponse = null;

	public void setNpcdwn2sresponse(Npcdwn2sresponse npcdwn2sresponse) {
		this.npcdwn2sresponse = npcdwn2sresponse;
	}

	public Npcdwn2sresponse getNpcdwn2sresponse() {
		return npcdwn2sresponse;
	}

}