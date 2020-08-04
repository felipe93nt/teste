/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf
 *
 * Compilador: 1.5
 *
 * Prop�sito: Classe Gerada Automaticamente Atrav�s do WDE Bradesco
 *
 * Data da Cria��o: 14/08/18 12:06
 *
 * Par�metros de Compila��o:  -d
 *
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Nome: TradeFinanceLogConfResponse
 * Prop�sito: Classe Gerada Automaticamente Atrav�s do WDE Bradesco
 *
 * @author: M157000
 * Equipe: BRADESCO
 * @version: 1.0
 * Par�metros de Compila��o:  -d
 *
 * @see: FRWKGL01Response
 *
 * 
 * Registro de Manuten��o: 
 * Data: 
 * Autor: 
 * Respons�vel:
 */
public class TradeFinanceLogConfResponse extends FRWKGL01Response {

	/** Atributo NpccwvvsResponse*/
	@Adapter (isTransactionBlock=true)
	private NpccwvvsResponse npccwvvsResponse = null;
	
	/**
	 * Nome: setNpccwvvsResponse
	 * Prop�sito: Definir o valor do campo npccwvvsResponse
	 *
	 * @author: M157000
	 * @param value novo valor para o campo npccwvvsResponse
	 *
	 */
	public void setNpccwvvsResponse(NpccwvvsResponse value) {
		this.npccwvvsResponse = value;
	}


	/**
	 * Nome: getNpccwvvsResponse
	 * Prop�sito: Retornar o valor do campo npccwvvsResponse
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo npccwvvsResponse
	 * @see: 
	 *
	 */
	public NpccwvvsResponse getNpccwvvsResponse() {
		return npccwvvsResponse;
	}




	/**
	 * Nome: TradeFinanceLogConfResponse
	 * Prop�sito: Criar uma inst�ncia
	 *
	 * @author: M157000
     * @return uma inst�ncia
	 *
	 */
    public TradeFinanceLogConfResponse() {
        super();
    }
    
}