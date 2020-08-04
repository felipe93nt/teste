package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BeneficiarioModlList;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 21/01/16 11:22
 */
public class Beneficiariomodllistresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwemsresponse npcdwemsresponse = null;
	
	public void setNpcdwemsresponse(Npcdwemsresponse npcdwemsresponse) {
		this.npcdwemsresponse = npcdwemsresponse;
	}


	public Npcdwemsresponse getNpcdwemsresponse() {
		return npcdwemsresponse;
	}
    
}