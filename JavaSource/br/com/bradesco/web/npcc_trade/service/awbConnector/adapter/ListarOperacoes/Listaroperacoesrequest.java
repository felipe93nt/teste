package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarOperacoes;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 17:40
 */
public class Listaroperacoesrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwnzerequest npcdwnzerequest = null;
	
	public void setNpcdwnzerequest(Npcdwnzerequest npcdwnzerequest) {
		this.npcdwnzerequest = npcdwnzerequest;
	}


	public Npcdwnzerequest getNpcdwnzerequest() {
		return npcdwnzerequest;
	}
    
}