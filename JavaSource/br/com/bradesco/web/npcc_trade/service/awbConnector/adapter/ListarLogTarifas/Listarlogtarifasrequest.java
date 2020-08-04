package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarLogTarifas;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 10:48
 */
public class Listarlogtarifasrequest extends FRWKGL01Request {

	@Adapter(isTransactionBlock = true)
	private Npcdwn2erequest npcdwn2erequest = null;

	public void setNpcdwn2erequest(Npcdwn2erequest npcdwn2erequest) {
		this.npcdwn2erequest = npcdwn2erequest;
	}

	public Npcdwn2erequest getNpcdwn2erequest() {
		return npcdwn2erequest;
	}

}