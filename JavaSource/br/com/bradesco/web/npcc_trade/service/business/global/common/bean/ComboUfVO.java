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
 * Nome: ComboUfVO.java
 * 
 * Propósito: Campos de pais
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
public class ComboUfVO {
	
	/** Variavel do tipo String. */
	private String coduf = null;

	/** Variavel do tipo String. */
	private String sigluf = null;

	/** Variavel do tipo String. */
	private String nomeuf = null;
	
    /**
     * Construtor
     * 
     * @param
     */
    public ComboUfVO() {
        super();
    }

	/**
	 * @return o valor do coduf
	 */
	public String getCoduf() {
		return coduf;
	}

	/**
	 * @param coduf seta o novo valor para o campo coduf
	 */
	public void setCoduf(String coduf) {
		this.coduf = coduf;
	}

	/**
	 * @return o valor do sigluf
	 */
	public String getSigluf() {
		return sigluf;
	}

	/**
	 * @param sigluf seta o novo valor para o campo sigluf
	 */
	public void setSigluf(String sigluf) {
		this.sigluf = sigluf;
	}

	/**
	 * @return o valor do nomeuf
	 */
	public String getNomeuf() {
		return nomeuf;
	}

	/**
	 * @param nomeuf seta o novo valor para o campo nomeuf
	 */
	public void setNomeuf(String nomeuf) {
		this.nomeuf = nomeuf;
	}

}