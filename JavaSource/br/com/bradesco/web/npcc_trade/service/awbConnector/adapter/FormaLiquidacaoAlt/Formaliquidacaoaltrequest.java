package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/08/15 08:50
 */
public class Formaliquidacaoaltrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwacerequest npcdwacerequest = null;

    /**
     * @return o valor do npcdwacerequest
     */
    public Npcdwacerequest getNpcdwacerequest() {
        return npcdwacerequest;
    }

    /**
     * @param npcdwacerequest seta o novo valor para o campo npcdwacerequest
     */
    public void setNpcdwacerequest(Npcdwacerequest npcdwacerequest) {
        this.npcdwacerequest = npcdwacerequest;
    }
    
}