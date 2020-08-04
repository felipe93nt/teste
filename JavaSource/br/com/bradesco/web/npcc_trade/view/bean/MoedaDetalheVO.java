/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 25/08/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;


/**
 * Nome: MoedaDetalheVO.java
 * 
 * Propósito: Informações Detalhadas Referente a Moeda.
 *
 * @author : BRQ<BR/>
 *           Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class MoedaDetalheVO {

    /**
     * Construtor
     * 
     * @param
     */
    public MoedaDetalheVO() {
        super();
    }

    /** NOME DA MOEDA - SINGULAR */
    private String descrmoedasingular = SiteUtil.STRING_EMPTY;

    /** NOME DA MOEDA - PLURAL */
    private String descrmoedaplural = SiteUtil.STRING_EMPTY;

    /** CODIGO DA MOEDA NO BACEN */
    public String cindcdfontecons = SiteUtil.STRING_EMPTY;

    /** DESCRICAO DA SIGLA - ISO/SWIFT. */
    private String isgleconmmoeda = SiteUtil.STRING_EMPTY;
    
    /** SIMBOLO DA MOEDA EM OPERACAO */
    private String simbleconmmoeda = SiteUtil.STRING_EMPTY;

    /** CODIGO INDICADOR DE MOEDA  */
    private Integer cindcdeconmmoeda = 0;
    
    /** UNIDADE FRACIONÁRIA DA MOEDA - SINGULAR */
    private String descrmoedafracaosingular = SiteUtil.STRING_EMPTY;

    /** UNIDADE FRACIONÁRIA DA MOEDA - PLURAL */
    private String descrmoedafracaoplural = SiteUtil.STRING_EMPTY;

    /** Variavel do tipo String. */
    private String iindcdeconmoeda = SiteUtil.STRING_EMPTY;

	/**
	 * @return the descrmoedasingular
	 */
	public String getDescrmoedasingular() {
		return descrmoedasingular;
	}

	/**
	 * @param descrmoedasingular the descrmoedasingular to set
	 */
	public void setDescrmoedasingular(String descrmoedasingular) {
		this.descrmoedasingular = descrmoedasingular;
	}

	/**
	 * @return the descrmoedaplural
	 */
	public String getDescrmoedaplural() {
		return descrmoedaplural;
	}

	/**
	 * @param descrmoedaplural the descrmoedaplural to set
	 */
	public void setDescrmoedaplural(String descrmoedaplural) {
		this.descrmoedaplural = descrmoedaplural;
	}

	/**
	 * @return the cindcdfontecons
	 */
	public String getCindcdfontecons() {
		return cindcdfontecons;
	}

	/**
	 * @param cindcdfontecons the cindcdfontecons to set
	 */
	public void setCindcdfontecons(String cindcdfontecons) {
		this.cindcdfontecons = cindcdfontecons;
	}

	/**
	 * @return the isgleconmmoeda
	 */
	public String getIsgleconmmoeda() {
		return isgleconmmoeda;
	}

	/**
	 * @param isgleconmmoeda the isgleconmmoeda to set
	 */
	public void setIsgleconmmoeda(String isgleconmmoeda) {
		this.isgleconmmoeda = isgleconmmoeda;
	}

	/**
	 * @return the simbleconmmoeda
	 */
	public String getSimbleconmmoeda() {
		return simbleconmmoeda;
	}

	/**
	 * @param simbleconmmoeda the simbleconmmoeda to set
	 */
	public void setSimbleconmmoeda(String simbleconmmoeda) {
		this.simbleconmmoeda = simbleconmmoeda;
	}

	/**
	 * @return the cindcdeconmmoeda
	 */
	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	/**
	 * @param cindcdeconmmoeda the cindcdeconmmoeda to set
	 */
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	/**
	 * @return the descrmoedafracaosingular
	 */
	public String getDescrmoedafracaosingular() {
		return descrmoedafracaosingular;
	}

	/**
	 * @param descrmoedafracaosingular the descrmoedafracaosingular to set
	 */
	public void setDescrmoedafracaosingular(String descrmoedafracaosingular) {
		this.descrmoedafracaosingular = descrmoedafracaosingular;
	}

	/**
	 * @return the descrmoedafracaoplural
	 */
	public String getDescrmoedafracaoplural() {
		return descrmoedafracaoplural;
	}

	/**
	 * @param descrmoedafracaoplural the descrmoedafracaoplural to set
	 */
	public void setDescrmoedafracaoplural(String descrmoedafracaoplural) {
		this.descrmoedafracaoplural = descrmoedafracaoplural;
	}

	/**
	 * @return the iindcdeconmoeda
	 */
	public String getIindcdeconmoeda() {
		return iindcdeconmoeda;
	}

	/**
	 * @param iindcdeconmoeda the iindcdeconmoeda to set
	 */
	public void setIindcdeconmoeda(String iindcdeconmoeda) {
		this.iindcdeconmoeda = iindcdeconmoeda;
	}


}
