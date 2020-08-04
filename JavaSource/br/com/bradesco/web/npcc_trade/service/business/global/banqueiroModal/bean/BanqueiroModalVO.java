/**
 *
 * Nome: GrupoBanqueirosListVO.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 06/10/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.bean;

/**
 *
 * Nome: GrupoBanqueirosListVO.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 06/10/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class BanqueiroModalVO {

	/** Variavel do tipo Integer. */
	private Integer tipopesquisa = null;

	/** Variavel do tipo Long. */
	private Long cbanqrcmbio = 0L;

	/** Variavel do tipo String. */
	private String ibanqrcmbio = null;

	/** Variavel do tipo String. */
	private String cidbanqrswift = null;

	private String cflialbanqrswift = null;

	/** Variavel do tipo Integer. */
	private Integer cpais = 0;

	/** Variavel do tipo String. */
	private String ipais = null;

	/** Variavel do tipo Long. */
	private Long cmunintlcmbio = 0L;

	/** Variavel do tipo String. */
	private String imunintlcmbio = null;

	/** Variavel do tipo Integer. */
	private Integer ctrocamsgemswift = 0;

	/** Variavel do tipo Integer. */
	private Integer cindcdbloqueado = 0;

	/** Variavel do tipo String. */
	private String coduf = null;

	/** Variavel do tipo Long. */
	private Long cbanqrcmbiop = null;

	/**
	 * @return o valor do cbanqrcmbio
	 */
	public Long getCbanqrcmbio() {
		return cbanqrcmbio;
	}

	/**
	 * @param cbanqrcmbio
	 *            seta o novo valor para o campo cbanqrcmbio
	 */
	public void setCbanqrcmbio(Long cbanqrcmbio) {
		this.cbanqrcmbio = cbanqrcmbio;
	}

	/**
	 * @return o valor do ibanqrcmbio
	 */
	public String getIbanqrcmbio() {
		return ibanqrcmbio;
	}

	/**
	 * @param ibanqrcmbio
	 *            seta o novo valor para o campo ibanqrcmbio
	 */
	public void setIbanqrcmbio(String ibanqrcmbio) {
		this.ibanqrcmbio = ibanqrcmbio;
	}

	/**
	 * @return o valor do cidbanqrswift
	 */
	public String getCidbanqrswift() {
		return cidbanqrswift;
	}

	/**
	 * @param cidbanqrswift
	 *            seta o novo valor para o campo cidbanqrswift
	 */
	public void setCidbanqrswift(String cidbanqrswift) {
		this.cidbanqrswift = cidbanqrswift;
	}

	/**
	 * @return o valor do tipopesquisa
	 */
	public Integer getTipopesquisa() {
		return tipopesquisa;
	}

	/**
	 * @param tipopesquisa
	 *            seta o novo valor para o campo tipopesquisa
	 */
	public void setTipopesquisa(Integer tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}

	/**
	 * @return o valor do cflialbanqrswift
	 */
	public String getCflialbanqrswift() {
		return cflialbanqrswift;
	}

	/**
	 * @param cflialbanqrswift
	 *            seta o novo valor para o campo cflialbanqrswift
	 */
	public void setCflialbanqrswift(String cflialbanqrswift) {
		this.cflialbanqrswift = cflialbanqrswift;
	}

	/**
	 * @return o valor do cpais
	 */
	public Integer getCpais() {
		return cpais;
	}

	/**
	 * @param cpais
	 *            seta o novo valor para o campo cpais
	 */
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	/**
	 * @return o valor do ipais
	 */
	public String getIpais() {
		return ipais;
	}

	/**
	 * @param ipais
	 *            seta o novo valor para o campo ipais
	 */
	public void setIpais(String ipais) {
		this.ipais = ipais;
	}

	/**
	 * @return o valor do cmunintlcmbio
	 */
	public Long getCmunintlcmbio() {
		return cmunintlcmbio;
	}

	/**
	 * @param cmunintlcmbio
	 *            seta o novo valor para o campo cmunintlcmbio
	 */
	public void setCmunintlcmbio(Long cmunintlcmbio) {
		this.cmunintlcmbio = cmunintlcmbio;
	}

	/**
	 * @return o valor do imunintlcmbio
	 */
	public String getImunintlcmbio() {
		return imunintlcmbio;
	}

	/**
	 * @param imunintlcmbio
	 *            seta o novo valor para o campo imunintlcmbio
	 */
	public void setImunintlcmbio(String imunintlcmbio) {
		this.imunintlcmbio = imunintlcmbio;
	}

	/**
	 * @return o valor do ctrocamsgemswift
	 */
	public Integer getCtrocamsgemswift() {
		return ctrocamsgemswift;
	}

	/**
	 * @param ctrocamsgemswift
	 *            seta o novo valor para o campo ctrocamsgemswift
	 */
	public void setCtrocamsgemswift(Integer ctrocamsgemswift) {
		this.ctrocamsgemswift = ctrocamsgemswift;
	}

	/**
	 * @return o valor do cindcdbloqueado
	 */
	public Integer getCindcdbloqueado() {
		return cindcdbloqueado;
	}

	/**
	 * @param cindcdbloqueado
	 *            seta o novo valor para o campo cindcdbloqueado
	 */
	public void setCindcdbloqueado(Integer cindcdbloqueado) {
		this.cindcdbloqueado = cindcdbloqueado;
	}

	/**
	 * @return o valor do coduf
	 */
	public String getCoduf() {
		return coduf;
	}

	/**
	 * @param coduf
	 *            seta o novo valor para o campo coduf
	 */
	public void setCoduf(String coduf) {
		this.coduf = coduf;
	}

	/**
	 * @return o valor do cbanqrcmbiop
	 */
	public Long getCbanqrcmbiop() {
		return cbanqrcmbiop;
	}

	/**
	 * @param cbanqrcmbiop
	 *            seta o novo valor para o campo cbanqrcmbiop
	 */
	public void setCbanqrcmbiop(Long cbanqrcmbiop) {
		this.cbanqrcmbiop = cbanqrcmbiop;
	}

}
