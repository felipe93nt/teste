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

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Nome: NpccwvveRequest
 * Propósito: Classe Gerada Automaticamente Através do WDE Bradesco
 *
 * @author: M157000
 * Equipe: BRADESCO
 * @version: 1.0
 * Parâmetros de Compilação:  -d
 *
 * @see: AnnotatedAdapter
 *
 * 
 * Registro de Manutenção: 
 * Data: 
 * Autor: 
 * Responsável:
 */
public class NpccwvveRequest extends AnnotatedAdapter {

	/** Atributo codLayout*/
	@Adapter(transactionField = "NPCCWVVE-HEADER.NPCCWVVE-COD-LAYOUT")
	private String codLayout = "NPCCWVVE";

	/** Atributo tamLayout*/
	@Adapter(transactionField = "NPCCWVVE-HEADER.NPCCWVVE-TAM-LAYOUT")
	private Integer tamLayout = 36;

	/** Atributo nbletocmbioano*/
	@Adapter(transactionField = "NPCCWVVE-REGISTRO.NPCCWVVE-NBLETOCMBIOANO")
	private Long nbletocmbioano = 0L;

	/** Atributo nbletonegoccmbio*/
	@Adapter(transactionField = "NPCCWVVE-REGISTRO.NPCCWVVE-NBLETONEGOCCMBIO")
	private Long nbletonegoccmbio = 0L;
	
	/**
	 * Nome: getCodLayout
	 * Propósito: Retornar o valor do campo codLayout
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo codLayout
	 * @see: 
	 *
	 */
	public String getCodLayout() {
		return codLayout;
	}

	/**
	 * Nome: setCodLayout
	 * Propósito: Definir o valor do campo codLayout
	 *
	 * @author: M157000
	 * @param value novo valor para o campo codLayout
	 *
	 */
	public void setCodLayout(String value) {
		this.codLayout = value;
	}

	/**
	 * Nome: getTamLayout
	 * Propósito: Retornar o valor do campo tamLayout
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo tamLayout
	 * @see: 
	 *
	 */
	public Integer getTamLayout() {
		return tamLayout;
	}

	/**
	 * Nome: setTamLayout
	 * Propósito: Definir o valor do campo tamLayout
	 *
	 * @author: M157000
	 * @param value novo valor para o campo tamLayout
	 *
	 */
	public void setTamLayout(Integer value) {
		this.tamLayout = value;
	}

	/**
	 * Nome: getNbletocmbioano
	 * Propósito: Retornar o valor do campo nbletocmbioano
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo nbletocmbioano
	 * @see: 
	 *
	 */
	public Long getNbletocmbioano() {
		return nbletocmbioano;
	}

	/**
	 * Nome: setNbletocmbioano
	 * Propósito: Definir o valor do campo nbletocmbioano
	 *
	 * @author: M157000
	 * @param value novo valor para o campo nbletocmbioano
	 *
	 */
	public void setNbletocmbioano(Long value) {
		this.nbletocmbioano = value;
	}

	/**
	 * Nome: getNbletonegoccmbio
	 * Propósito: Retornar o valor do campo nbletonegoccmbio
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo nbletonegoccmbio
	 * @see: 
	 *
	 */
	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}

	/**
	 * Nome: setNbletonegoccmbio
	 * Propósito: Definir o valor do campo nbletonegoccmbio
	 *
	 * @author: M157000
	 * @param value novo valor para o campo nbletonegoccmbio
	 *
	 */
	public void setNbletonegoccmbio(Long value) {
		this.nbletonegoccmbio = value;
	}



	/**
	 * Nome: NpccwvveRequest
	 * Propósito: Criar uma instância
	 *
	 * @author: M157000
     * @return uma instância
	 *
	 */
    public NpccwvveRequest() {
        super();
    }
    
}