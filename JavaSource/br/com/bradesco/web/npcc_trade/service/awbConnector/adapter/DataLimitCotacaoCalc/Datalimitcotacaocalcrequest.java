package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DataLimitCotacaoCalc;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 04/04/16 11:04
 */
public class Datalimitcotacaocalcrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npccwhferequest npccwhferequest = null;
	
	public void setNpccwhferequest(Npccwhferequest npccwhferequest) {
		this.npccwhferequest = npccwhferequest;
	}


	public Npccwhferequest getNpccwhferequest() {
		return npccwhferequest;
	}
    
}