package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoExterna;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:44
 */
public class Obtercomissaoexternarequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwxjerequest npccwxjerequest = null;
	
	public void setNpccwxjerequest(Npccwxjerequest npccwxjerequest) {
		this.npccwxjerequest = npccwxjerequest;
	}


	public Npccwxjerequest getNpccwxjerequest() {
		return npccwxjerequest;
	}
    
}