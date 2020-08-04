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

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Nome: TradeFinanceLogConfRequest
 * Prop�sito: Classe Gerada Automaticamente Atrav�s do WDE Bradesco
 *
 * @author: M157000
 * Equipe: BRADESCO
 * @version: 1.0
 * Par�metros de Compila��o:  -d
 *
 * @see: FRWKGL01Request
 *
 * 
 * Registro de Manuten��o: 
 * Data: 
 * Autor: 
 * Respons�vel:
 */
public class TradeFinanceLogConfRequest extends FRWKGL01Request {

	/** Atributo NpccwvveRequest*/
	@Adapter (isTransactionBlock=true)
	private NpccwvveRequest npccwvveRequest = null;
	
	/**
	 * Nome: setNpccwvveRequest
	 * Prop�sito: Definir o valor do campo npccwvveRequest
	 *
	 * @author: M157000
	 * @param value novo valor para o campo npccwvveRequest
	 *
	 */
	public void setNpccwvveRequest(NpccwvveRequest value) {
		this.npccwvveRequest = value;
	}


	/**
	 * Nome: getNpccwvveRequest
	 * Prop�sito: Retornar o valor do campo npccwvveRequest
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo npccwvveRequest
	 * @see: 
	 *
	 */
	public NpccwvveRequest getNpccwvveRequest() {
		return npccwvveRequest;
	}




	/**
	 * Nome: TradeFinanceLogConfRequest
	 * Prop�sito: Criar uma inst�ncia
	 *
	 * @author: M157000
     * @return uma inst�ncia
	 *
	 */
    public TradeFinanceLogConfRequest() {
        super();
    }
    
}