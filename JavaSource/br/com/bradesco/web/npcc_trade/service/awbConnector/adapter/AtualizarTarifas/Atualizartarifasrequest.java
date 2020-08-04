package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AtualizarTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 11:12
 */
public class Atualizartarifasrequest extends FRWKGL01Request {

	@Adapter(isTransactionBlock = true)
	private Npcdwn1erequest npcdwn1erequest = null;

	public void setNpcdwn1erequest(Npcdwn1erequest npcdwn1erequest) {
		this.npcdwn1erequest = npcdwn1erequest;
	}

	public Npcdwn1erequest getNpcdwn1erequest() {
		return npcdwn1erequest;
	}

}