package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/08/15 08:48
 */
public class Formaliquidacaoinclrequest extends FRWKGL01Request {

	@Adapter (isTransactionBlock=true)
	private Npcdwaberequest npcdwaberequest = null;

    /**
     * @return o valor do npcdwaberequest
     */
    public Npcdwaberequest getNpcdwaberequest() {
        return npcdwaberequest;
    }

    /**
     * @param npcdwaberequest seta o novo valor para o campo npcdwaberequest
     */
    public void setNpcdwaberequest(Npcdwaberequest npcdwaberequest) {
        this.npcdwaberequest = npcdwaberequest;
    }
    
}