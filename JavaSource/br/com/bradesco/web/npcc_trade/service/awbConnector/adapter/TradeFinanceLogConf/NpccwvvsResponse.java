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
import java.util.List;

/**
 * Nome: NpccwvvsResponse
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
public class NpccwvvsResponse extends AnnotatedAdapter {

	/** Atributo codLayout*/
	@Adapter(transactionField = "NPCCWVVS-HEADER.NPCCWVVS-COD-LAYOUT")
	private String codLayout = "NPCCWVVS";

	/** Atributo tamLayout*/
	@Adapter(transactionField = "NPCCWVVS-HEADER.NPCCWVVS-TAM-LAYOUT")
	private Integer tamLayout = 24066;

	/** Atributo qtdeocorr*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-QTDEOCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE" ,
        isAnnotatedAdapter = true,
        nameClass =
        "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogConf" + 
        ".NpccwvvsResponseGride")
	private List<NpccwvvsResponseGride> gride = null;
	
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
	 * Nome: getQtdeocorr
	 * Propósito: Retornar o valor do campo qtdeocorr
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo qtdeocorr
	 * @see: 
	 *
	 */
	public Integer getQtdeocorr() {
		return qtdeocorr;
	}

	/**
	 * Nome: setQtdeocorr
	 * Propósito: Definir o valor do campo qtdeocorr
	 *
	 * @author: M157000
	 * @param value novo valor para o campo qtdeocorr
	 *
	 */
	public void setQtdeocorr(Integer value) {
		this.qtdeocorr = value;
	}

	/**
	 * Nome: getGride
	 * Propósito: Retornar o valor do campo gride
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo gride
	 * @see: 
	 *
	 */
	public List<NpccwvvsResponseGride> getGride() {
		return gride;
	}

	/**
	 * Nome: setGride
	 * Propósito: Definir o valor do campo gride
	 *
	 * @author: M157000
	 * @param value novo valor para o campo gride
	 *
	 */
	public void setGride( List<NpccwvvsResponseGride> value) {
		this.gride = value;
	}



	/**
	 * Nome: NpccwvvsResponse
	 * Propósito: Criar uma instância
	 *
	 * @author: M157000
     * @return uma instância
	 *
	 */
    public NpccwvvsResponse() {
        super();
    }
    
}