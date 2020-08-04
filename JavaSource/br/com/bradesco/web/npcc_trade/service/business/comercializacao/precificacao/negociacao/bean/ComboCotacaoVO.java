/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 25/08/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;


/**
 * Nome: ComboPaisVO.java
 * 
 * Prop�sito: Campos de pais
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 25/08/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public class ComboCotacaoVO {

    /**
     * Construtor
     * 
     * @param
     */
    public ComboCotacaoVO() {
        super();
    }
    
    /****** Combo Periodicidade ******/
    
	private Integer cfluxoperdccmbio = 0;

	private String ifluxoperdccmbio = null;
	
	private Integer perdcprzomes = null;
    
    /****** Combo Tipo Comissoes ******/
	private Integer ccondceconc = 0;

	private String icondeconc = null;
    
    /****** Combo Tarifas ******/
	private Integer ctpodespcmbio = 0;

	private String dtpodespcmbio = null;

	private String identtrfadeps = null;

	/**
	 * @return o valor do cfluxoperdccmbio
	 */
	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}

	/**
	 * @param cfluxoperdccmbio seta o novo valor para o campo cfluxoperdccmbio
	 */
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}

	/**
	 * @return o valor do ifluxoperdccmbio
	 */
	public String getIfluxoperdccmbio() {
		return ifluxoperdccmbio;
	}

	/**
	 * @param ifluxoperdccmbio seta o novo valor para o campo ifluxoperdccmbio
	 */
	public void setIfluxoperdccmbio(String ifluxoperdccmbio) {
		this.ifluxoperdccmbio = ifluxoperdccmbio;
	}

	/**
	 * @return o valor do ccondceconc
	 */
	public Integer getCcondceconc() {
		return ccondceconc;
	}

	/**
	 * @param ccondceconc seta o novo valor para o campo ccondceconc
	 */
	public void setCcondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}

	/**
	 * @return o valor do icondeconc
	 */
	public String getIcondeconc() {
		return icondeconc;
	}

	/**
	 * @param icondeconc seta o novo valor para o campo icondeconc
	 */
	public void setIcondeconc(String icondeconc) {
		this.icondeconc = icondeconc;
	}

	/**
	 * @return o valor do ctpodespcmbio
	 */
	public Integer getCtpodespcmbio() {
		return ctpodespcmbio;
	}

	/**
	 * @param ctpodespcmbio seta o novo valor para o campo ctpodespcmbio
	 */
	public void setCtpodespcmbio(Integer ctpodespcmbio) {
		this.ctpodespcmbio = ctpodespcmbio;
	}

	/**
	 * @return o valor do dtpodespcmbio
	 */
	public String getDtpodespcmbio() {
		return dtpodespcmbio;
	}

	/**
	 * @param dtpodespcmbio seta o novo valor para o campo dtpodespcmbio
	 */
	public void setDtpodespcmbio(String dtpodespcmbio) {
		this.dtpodespcmbio = dtpodespcmbio;
	}

	/**
	 * @return o valor do identtrfadeps
	 */
	public String getIdenttrfadeps() {
		return identtrfadeps;
	}

	/**
	 * @param identtrfadeps seta o novo valor para o campo identtrfadeps
	 */
	public void setIdenttrfadeps(String identtrfadeps) {
		this.identtrfadeps = identtrfadeps;
	}

    /**
     * @return o valor do perdcprzomes
     */
    public Integer getPerdcprzomes() {
        return perdcprzomes;
    }

    /**
     * @param perdcprzomes seta o novo valor para o campo perdcprzomes
     */
    public void setPerdcprzomes(Integer perdcprzomes) {
        this.perdcprzomes = perdcprzomes;
    }
    
}
