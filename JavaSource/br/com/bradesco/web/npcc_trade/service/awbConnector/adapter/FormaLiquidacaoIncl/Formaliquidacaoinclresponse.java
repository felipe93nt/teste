package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FormaLiquidacaoIncl;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Arquivo gerado automaticamente em 28/08/15 08:48
 */
public class Formaliquidacaoinclresponse extends FRWKGL01Response {

	@Adapter (isTransactionBlock=true)
	private Npcdwabsresponse npcdwabsresponse = null;

    /**
     * @return o valor do npcdwabsresponse
     */
    public Npcdwabsresponse getNpcdwabsresponse() {
        return npcdwabsresponse;
    }

    /**
     * @param npcdwabsresponse seta o novo valor para o campo npcdwabsresponse
     */
    public void setNpcdwabsresponse(Npcdwabsresponse npcdwabsresponse) {
        this.npcdwabsresponse = npcdwabsresponse;
    }
    
}