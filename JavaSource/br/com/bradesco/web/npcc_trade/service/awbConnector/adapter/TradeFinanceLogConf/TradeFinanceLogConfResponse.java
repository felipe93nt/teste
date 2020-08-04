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

import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;
import br.com.bradesco.data.connector.Adapter;

/**
 * Nome: TradeFinanceLogConfResponse
 * Propósito: Classe Gerada Automaticamente Através do WDE Bradesco
 *
 * @author: M157000
 * Equipe: BRADESCO
 * @version: 1.0
 * Parâmetros de Compilação:  -d
 *
 * @see: FRWKGL01Response
 *
 * 
 * Registro de Manutenção: 
 * Data: 
 * Autor: 
 * Responsável:
 */
public class TradeFinanceLogConfResponse extends FRWKGL01Response {

	/** Atributo NpccwvvsResponse*/
	@Adapter (isTransactionBlock=true)
	private NpccwvvsResponse npccwvvsResponse = null;
	
	/**
	 * Nome: setNpccwvvsResponse
	 * Propósito: Definir o valor do campo npccwvvsResponse
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
	 * Propósito: Retornar o valor do campo npccwvvsResponse
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
	 * Propósito: Criar uma instância
	 *
	 * @author: M157000
     * @return uma instância
	 *
	 */
    public TradeFinanceLogConfResponse() {
        super();
    }
    
}