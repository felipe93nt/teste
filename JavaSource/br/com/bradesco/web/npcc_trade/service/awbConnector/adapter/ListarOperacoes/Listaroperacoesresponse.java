package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarOperacoes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 17:40
 */
public class Listaroperacoesresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwnzsresponse npcdwnzsresponse = null;
	
	public void setNpcdwnzsresponse(Npcdwnzsresponse npcdwnzsresponse) {
		this.npcdwnzsresponse = npcdwnzsresponse;
	}


	public Npcdwnzsresponse getNpcdwnzsresponse() {
		return npcdwnzsresponse;
	}
    
}