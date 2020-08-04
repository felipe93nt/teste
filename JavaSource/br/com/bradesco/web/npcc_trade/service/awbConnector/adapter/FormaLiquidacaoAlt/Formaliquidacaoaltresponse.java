package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoAlt;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/08/15 08:50
 */
public class Formaliquidacaoaltresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwacsresponse npcdwacsresponse = null;

    /**
     * @return o valor do npcdwacsresponse
     */
    public Npcdwacsresponse getNpcdwacsresponse() {
        return npcdwacsresponse;
    }

    /**
     * @param npcdwacsresponse seta o novo valor para o campo npcdwacsresponse
     */
    public void setNpcdwacsresponse(Npcdwacsresponse npcdwacsresponse) {
        this.npcdwacsresponse = npcdwacsresponse;
    }
    
}