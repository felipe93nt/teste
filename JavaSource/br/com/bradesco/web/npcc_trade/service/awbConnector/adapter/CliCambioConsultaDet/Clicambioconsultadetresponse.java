package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Clicambioconsultadetresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdweysresponse npcdweysresponse = null;
	
	public void setNpcdweysresponse(Npcdweysresponse npcdweysresponse) {
		this.npcdweysresponse = npcdweysresponse;
	}


	public Npcdweysresponse getNpcdweysresponse() {
		return npcdweysresponse;
	}
    
}