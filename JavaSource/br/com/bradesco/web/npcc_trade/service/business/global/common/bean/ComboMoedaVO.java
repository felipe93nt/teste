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
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
 * Nome: ComboMoedaVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class ComboMoedaVO {

    /**
     * Construtor
     * 
     * @param
     */
    public ComboMoedaVO() {
        super();
    }

    /** CODIGO INDICADOR DE MOEDA - PIC 9(005) */
    public Integer cindcdeconmmoeda = null;

    /** DESCRICAO DA SIGLA - PIC X(010). */
    public String isglindcdeconm = null;

    /** CODIGO BACEN - PIC X(020). */
    public String cindcdfontecons = null;
    
    /** Variavel do tipo Integer. */
    private Integer cindcdeconm = 0;

	/** Variavel do tipo String. */
	private String iindcdeconm = null;

    /**
     * @return o valor do cindcdeconmmoeda
     */
    public Integer getCindcdeconmmoeda() {
        return cindcdeconmmoeda;
    }

    /**
     * @param cindcdeconmmoeda seta o novo valor para o campo cindcdeconmmoeda
     */
    public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
        this.cindcdeconmmoeda = cindcdeconmmoeda;
    }


    /**
     * @return the isglindcdeconm
     */
    public String getIsglindcdeconm() {
        return isglindcdeconm;
    }

    /**
     * @param isglindcdeconm the isglindcdeconm to set
     */
    public void setIsglindcdeconm(String isglindcdeconm) {
        this.isglindcdeconm = isglindcdeconm;
    }

    /**
     * @return o valor do cindcdfontecons
     */
    public String getCindcdfontecons() {
        return cindcdfontecons;
    }

    /**
     * @param cindcdfontecons seta o novo valor para o campo cindcdfontecons
     */
    public void setCindcdfontecons(String cindcdfontecons) {
        this.cindcdfontecons = cindcdfontecons;
    }

	/**
	 * @return o valor do cindcdeconm
	 */
	public Integer getCindcdeconm() {
		return cindcdeconm;
	}

	/**
	 * @param cindcdeconm seta o novo valor para o campo cindcdeconm
	 */
	public void setCindcdeconm(Integer cindcdeconm) {
		this.cindcdeconm = cindcdeconm;
	}

	/**
	 * @return o valor do iindcdeconm
	 */
	public String getIindcdeconm() {
		return iindcdeconm;
	}

	/**
	 * @param iindcdeconm seta o novo valor para o campo iindcdeconm
	 */
	public void setIindcdeconm(String iindcdeconm) {
		this.iindcdeconm = iindcdeconm;
	}

}
