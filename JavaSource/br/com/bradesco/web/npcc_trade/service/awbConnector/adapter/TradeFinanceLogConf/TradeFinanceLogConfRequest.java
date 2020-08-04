/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf
 *
 * Compilador: 1.5
 *
 * Propósito: Classe Gerada Automaticamente Através do WDE Bradesco
 *
 * Data da Criação: 14/08/18 12:06
 *
 * Parâmetros de Compilação:  -d
 *
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf;

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;
import br.com.bradesco.data.connector.Adapter;

/**
 * Nome: TradeFinanceLogConfRequest
 * Propósito: Classe Gerada Automaticamente Através do WDE Bradesco
 *
 * @author: M157000
 * Equipe: BRADESCO
 * @version: 1.0
 * Parâmetros de Compilação:  -d
 *
 * @see: FRWKGL01Request
 *
 * 
 * Registro de Manutenção: 
 * Data: 
 * Autor: 
 * Responsável:
 */
public class TradeFinanceLogConfRequest extends FRWKGL01Request {

	/** Atributo NpccwvveRequest*/
	@Adapter (isTransactionBlock=true)
	private NpccwvveRequest npccwvveRequest = null;
	
	/**
	 * Nome: setNpccwvveRequest
	 * Propósito: Definir o valor do campo npccwvveRequest
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
	 * Propósito: Retornar o valor do campo npccwvveRequest
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
	 * Propósito: Criar uma instância
	 *
	 * @author: M157000
     * @return uma instância
	 *
	 */
    public TradeFinanceLogConfRequest() {
        super();
    }
    
}