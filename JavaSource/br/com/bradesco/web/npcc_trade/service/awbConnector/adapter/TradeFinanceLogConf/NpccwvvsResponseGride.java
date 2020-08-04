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
 * Nome: NpccwvvsResponseGride
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
public class NpccwvvsResponseGride extends AnnotatedAdapter {

	/** Atributo scsitbletocmbio*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SCSITBLETOCMBIO")
	private Integer scsitbletocmbio = 0;

	/** Atributo sdsitbletocmbio*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SDSITBLETOCMBIO")
	private String sdsitbletocmbio = null;

	/** Atributo sdtcotacao*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SDTCOTACAO")
	private String sdtcotacao = null;

	/** Atributo shorario*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SHORARIO")
	private String shorario = null;

	/** Atributo scunicclicmbio*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SCUNICCLICMBIO")
	private Long scunicclicmbio = 0L;

	/** Atributo sncunicclicmbio*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SNCUNICCLICMBIO")
	private String sncunicclicmbio = null;

	/** Atributo scprodtservc*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SCPRODTSERVC")
	private Integer scprodtservc = 0;

	/** Atributo sdprodtservc*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SDPRODTSERVC")
	private String sdprodtservc = null;

	/** Atributo scmodldprodtcmbio*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SCMODLDPRODTCMBIO")
	private Integer scmodldprodtcmbio = 0;

	/** Atributo scmodldprodtdesc*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SCMODLDPRODTDESC")
	private String scmodldprodtdesc = null;

	/** Atributo svnegocmoedaestrg*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SVNEGOCMOEDAESTRG")
	private Double svnegocmoedaestrg = 0D;

	/** Atributo scusuarinclt*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SCUSUARINCLT")
	private String scusuarinclt = null;

	/** Atributo snusuarinclt*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SNUSUARINCLT")
	private String snusuarinclt = null;

	/** Atributo scindcdtpomanut*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SCINDCDTPOMANUT")
	private String scindcdtpomanut = null;

	/** Atributo sfuncao*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SFUNCAO")
	private String sfuncao = null;

	/** Atributo snbletonegoccmbio*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SNBLETONEGOCCMBIO")
	private Long snbletonegoccmbio = 0L;

	/** Atributo shinclreghist*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SHINCLREGHIST")
	private String shinclreghist = null;

	/** Atributo shinclanthist*/
	@Adapter(transactionField = "NPCCWVVS-REGISTRO.NPCCWVVS-GRIDE.NPCCWVVS-SHINCLANTHIST")
	private String shinclanthist = null;
	
	/**
	 * Nome: getScsitbletocmbio
	 * Propósito: Retornar o valor do campo scsitbletocmbio
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo scsitbletocmbio
	 * @see: 
	 *
	 */
	public Integer getScsitbletocmbio() {
		return scsitbletocmbio;
	}

	/**
	 * Nome: setScsitbletocmbio
	 * Propósito: Definir o valor do campo scsitbletocmbio
	 *
	 * @author: M157000
	 * @param value novo valor para o campo scsitbletocmbio
	 *
	 */
	public void setScsitbletocmbio(Integer value) {
		this.scsitbletocmbio = value;
	}

	/**
	 * Nome: getSdsitbletocmbio
	 * Propósito: Retornar o valor do campo sdsitbletocmbio
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo sdsitbletocmbio
	 * @see: 
	 *
	 */
	public String getSdsitbletocmbio() {
		return sdsitbletocmbio;
	}

	/**
	 * Nome: setSdsitbletocmbio
	 * Propósito: Definir o valor do campo sdsitbletocmbio
	 *
	 * @author: M157000
	 * @param value novo valor para o campo sdsitbletocmbio
	 *
	 */
	public void setSdsitbletocmbio(String value) {
		this.sdsitbletocmbio = value;
	}

	/**
	 * Nome: getSdtcotacao
	 * Propósito: Retornar o valor do campo sdtcotacao
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo sdtcotacao
	 * @see: 
	 *
	 */
	public String getSdtcotacao() {
		return sdtcotacao;
	}

	/**
	 * Nome: setSdtcotacao
	 * Propósito: Definir o valor do campo sdtcotacao
	 *
	 * @author: M157000
	 * @param value novo valor para o campo sdtcotacao
	 *
	 */
	public void setSdtcotacao(String value) {
		this.sdtcotacao = value;
	}

	/**
	 * Nome: getShorario
	 * Propósito: Retornar o valor do campo shorario
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo shorario
	 * @see: 
	 *
	 */
	public String getShorario() {
		return shorario;
	}

	/**
	 * Nome: setShorario
	 * Propósito: Definir o valor do campo shorario
	 *
	 * @author: M157000
	 * @param value novo valor para o campo shorario
	 *
	 */
	public void setShorario(String value) {
		this.shorario = value;
	}

	/**
	 * Nome: getScunicclicmbio
	 * Propósito: Retornar o valor do campo scunicclicmbio
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo scunicclicmbio
	 * @see: 
	 *
	 */
	public Long getScunicclicmbio() {
		return scunicclicmbio;
	}

	/**
	 * Nome: setScunicclicmbio
	 * Propósito: Definir o valor do campo scunicclicmbio
	 *
	 * @author: M157000
	 * @param value novo valor para o campo scunicclicmbio
	 *
	 */
	public void setScunicclicmbio(Long value) {
		this.scunicclicmbio = value;
	}

	/**
	 * Nome: getSncunicclicmbio
	 * Propósito: Retornar o valor do campo sncunicclicmbio
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo sncunicclicmbio
	 * @see: 
	 *
	 */
	public String getSncunicclicmbio() {
		return sncunicclicmbio;
	}

	/**
	 * Nome: setSncunicclicmbio
	 * Propósito: Definir o valor do campo sncunicclicmbio
	 *
	 * @author: M157000
	 * @param value novo valor para o campo sncunicclicmbio
	 *
	 */
	public void setSncunicclicmbio(String value) {
		this.sncunicclicmbio = value;
	}

	/**
	 * Nome: getScprodtservc
	 * Propósito: Retornar o valor do campo scprodtservc
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo scprodtservc
	 * @see: 
	 *
	 */
	public Integer getScprodtservc() {
		return scprodtservc;
	}

	/**
	 * Nome: setScprodtservc
	 * Propósito: Definir o valor do campo scprodtservc
	 *
	 * @author: M157000
	 * @param value novo valor para o campo scprodtservc
	 *
	 */
	public void setScprodtservc(Integer value) {
		this.scprodtservc = value;
	}

	/**
	 * Nome: getSdprodtservc
	 * Propósito: Retornar o valor do campo sdprodtservc
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo sdprodtservc
	 * @see: 
	 *
	 */
	public String getSdprodtservc() {
		return sdprodtservc;
	}

	/**
	 * Nome: setSdprodtservc
	 * Propósito: Definir o valor do campo sdprodtservc
	 *
	 * @author: M157000
	 * @param value novo valor para o campo sdprodtservc
	 *
	 */
	public void setSdprodtservc(String value) {
		this.sdprodtservc = value;
	}

	/**
	 * Nome: getScmodldprodtcmbio
	 * Propósito: Retornar o valor do campo scmodldprodtcmbio
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo scmodldprodtcmbio
	 * @see: 
	 *
	 */
	public Integer getScmodldprodtcmbio() {
		return scmodldprodtcmbio;
	}

	/**
	 * Nome: setScmodldprodtcmbio
	 * Propósito: Definir o valor do campo scmodldprodtcmbio
	 *
	 * @author: M157000
	 * @param value novo valor para o campo scmodldprodtcmbio
	 *
	 */
	public void setScmodldprodtcmbio(Integer value) {
		this.scmodldprodtcmbio = value;
	}

	/**
	 * Nome: getScmodldprodtdesc
	 * Propósito: Retornar o valor do campo scmodldprodtdesc
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo scmodldprodtdesc
	 * @see: 
	 *
	 */
	public String getScmodldprodtdesc() {
		return scmodldprodtdesc;
	}

	/**
	 * Nome: setScmodldprodtdesc
	 * Propósito: Definir o valor do campo scmodldprodtdesc
	 *
	 * @author: M157000
	 * @param value novo valor para o campo scmodldprodtdesc
	 *
	 */
	public void setScmodldprodtdesc(String value) {
		this.scmodldprodtdesc = value;
	}

	/**
	 * Nome: getSvnegocmoedaestrg
	 * Propósito: Retornar o valor do campo svnegocmoedaestrg
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo svnegocmoedaestrg
	 * @see: 
	 *
	 */
	public Double getSvnegocmoedaestrg() {
		return svnegocmoedaestrg;
	}

	/**
	 * Nome: setSvnegocmoedaestrg
	 * Propósito: Definir o valor do campo svnegocmoedaestrg
	 *
	 * @author: M157000
	 * @param value novo valor para o campo svnegocmoedaestrg
	 *
	 */
	public void setSvnegocmoedaestrg(Double value) {
		this.svnegocmoedaestrg = value;
	}

	/**
	 * Nome: getScusuarinclt
	 * Propósito: Retornar o valor do campo scusuarinclt
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo scusuarinclt
	 * @see: 
	 *
	 */
	public String getScusuarinclt() {
		return scusuarinclt;
	}

	/**
	 * Nome: setScusuarinclt
	 * Propósito: Definir o valor do campo scusuarinclt
	 *
	 * @author: M157000
	 * @param value novo valor para o campo scusuarinclt
	 *
	 */
	public void setScusuarinclt(String value) {
		this.scusuarinclt = value;
	}

	/**
	 * Nome: getSnusuarinclt
	 * Propósito: Retornar o valor do campo snusuarinclt
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo snusuarinclt
	 * @see: 
	 *
	 */
	public String getSnusuarinclt() {
		return snusuarinclt;
	}

	/**
	 * Nome: setSnusuarinclt
	 * Propósito: Definir o valor do campo snusuarinclt
	 *
	 * @author: M157000
	 * @param value novo valor para o campo snusuarinclt
	 *
	 */
	public void setSnusuarinclt(String value) {
		this.snusuarinclt = value;
	}

	/**
	 * Nome: getScindcdtpomanut
	 * Propósito: Retornar o valor do campo scindcdtpomanut
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo scindcdtpomanut
	 * @see: 
	 *
	 */
	public String getScindcdtpomanut() {
		return scindcdtpomanut;
	}

	/**
	 * Nome: setScindcdtpomanut
	 * Propósito: Definir o valor do campo scindcdtpomanut
	 *
	 * @author: M157000
	 * @param value novo valor para o campo scindcdtpomanut
	 *
	 */
	public void setScindcdtpomanut(String value) {
		this.scindcdtpomanut = value;
	}

	/**
	 * Nome: getSfuncao
	 * Propósito: Retornar o valor do campo sfuncao
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo sfuncao
	 * @see: 
	 *
	 */
	public String getSfuncao() {
		return sfuncao;
	}

	/**
	 * Nome: setSfuncao
	 * Propósito: Definir o valor do campo sfuncao
	 *
	 * @author: M157000
	 * @param value novo valor para o campo sfuncao
	 *
	 */
	public void setSfuncao(String value) {
		this.sfuncao = value;
	}

	/**
	 * Nome: getSnbletonegoccmbio
	 * Propósito: Retornar o valor do campo snbletonegoccmbio
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo snbletonegoccmbio
	 * @see: 
	 *
	 */
	public Long getSnbletonegoccmbio() {
		return snbletonegoccmbio;
	}

	/**
	 * Nome: setSnbletonegoccmbio
	 * Propósito: Definir o valor do campo snbletonegoccmbio
	 *
	 * @author: M157000
	 * @param value novo valor para o campo snbletonegoccmbio
	 *
	 */
	public void setSnbletonegoccmbio(Long value) {
		this.snbletonegoccmbio = value;
	}

	/**
	 * Nome: getShinclreghist
	 * Propósito: Retornar o valor do campo shinclreghist
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo shinclreghist
	 * @see: 
	 *
	 */
	public String getShinclreghist() {
		return shinclreghist;
	}

	/**
	 * Nome: setShinclreghist
	 * Propósito: Definir o valor do campo shinclreghist
	 *
	 * @author: M157000
	 * @param value novo valor para o campo shinclreghist
	 *
	 */
	public void setShinclreghist(String value) {
		this.shinclreghist = value;
	}

	/**
	 * Nome: getShinclanthist
	 * Propósito: Retornar o valor do campo shinclanthist
	 *
	 * @author: M157000
	 * @return Retornar o valor do campo shinclanthist
	 * @see: 
	 *
	 */
	public String getShinclanthist() {
		return shinclanthist;
	}

	/**
	 * Nome: setShinclanthist
	 * Propósito: Definir o valor do campo shinclanthist
	 *
	 * @author: M157000
	 * @param value novo valor para o campo shinclanthist
	 *
	 */
	public void setShinclanthist(String value) {
		this.shinclanthist = value;
	}



	/**
	 * Nome: NpccwvvsResponseGride
	 * Propósito: Criar uma instância
	 *
	 * @author: M157000
     * @return uma instância
	 *
	 */
    public NpccwvvsResponseGride() {
        super();
    }
    
}