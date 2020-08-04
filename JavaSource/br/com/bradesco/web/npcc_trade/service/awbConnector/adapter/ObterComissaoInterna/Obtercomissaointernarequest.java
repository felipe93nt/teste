package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 06/04/17 09:29
 */
public class Obtercomissaointernarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxeerequest npccwxeerequest = null;
	
	public void setNpccwxeerequest(Npccwxeerequest npccwxeerequest) {
		this.npccwxeerequest = npccwxeerequest;
	}


	public Npccwxeerequest getNpccwxeerequest() {
		return npccwxeerequest;
	}
    
}