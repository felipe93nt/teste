/**
 *
 * Nome: BanqueirosFiltroVo.java
 * Propósito: <p> </p>
 *
 * @author :  Bradesco S.A.<BR/>
 * Equipe : Centro de Desenvolvimento - Curitiba<BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 */
package br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean;

/**
 *
 * Nome: BanqueirosFiltroVo.java Propósito:
 * <p>
 * </p>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 */
public class BanqueirosFiltroVo {

	/** Variavel do tipo Integer. */
	private Integer tipoPesquisaUm = null;

	/** Variavel do tipo Integer. */
	private Integer tipoPesquisaDois = null;

	/** Variavel do tipo Integer. */
	private Integer tipoPesquisaCadastro = null;

	/** Variavel do tipo Integer. */
	private Integer tipoPesquisaManutencao = null;

	/** Variavel do tipo String. */
	private String descricao = null;

	/** Variavel do tipo Integer. */
	private Integer cpais = null;

	/** Variavel do tipo Long. */
	private Long cmunintlcmbio = null;

	/** Variavel do tipo String. */
	private String coduf = null;

	/**
	 * Método construtor da classe.
	 */
	public BanqueirosFiltroVo() {
		super();

	}

	/**
	 * @return o valor do tipoPesquisaUm
	 */
	public Integer getTipoPesquisaUm() {
		return tipoPesquisaUm;
	}

	/**
	 * @param tipoPesquisaUm
	 *            seta o novo valor para o campo tipoPesquisaUm
	 */
	public void setTipoPesquisaUm(Integer tipoPesquisaUm) {
		this.tipoPesquisaUm = tipoPesquisaUm;
	}

	/**
	 * @return o valor do tipoPesquisaDois
	 */
	public Integer getTipoPesquisaDois() {
		return tipoPesquisaDois;
	}

	/**
	 * @param tipoPesquisaDois
	 *            seta o novo valor para o campo tipoPesquisaDois
	 */
	public void setTipoPesquisaDois(Integer tipoPesquisaDois) {
		this.tipoPesquisaDois = tipoPesquisaDois;
	}

	/**
	 * @return o valor do descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            seta o novo valor para o campo descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return o valor do tipoPesquisaManutencao
	 */
	public Integer getTipoPesquisaManutencao() {
		return tipoPesquisaManutencao;
	}

	/**
	 * @param tipoPesquisaManutencao
	 *            seta o novo valor para o campo tipoPesquisaManutencao
	 */
	public void setTipoPesquisaManutencao(Integer tipoPesquisaManutencao) {
		this.tipoPesquisaManutencao = tipoPesquisaManutencao;
	}

	/**
	 * @return o valor do tipoPesquisaCadastro
	 */
	public Integer getTipoPesquisaCadastro() {
		return tipoPesquisaCadastro;
	}

	/**
	 * @param tipoPesquisaCadastro
	 *            seta o novo valor para o campo tipoPesquisaCadastro
	 */
	public void setTipoPesquisaCadastro(Integer tipoPesquisaCadastro) {
		this.tipoPesquisaCadastro = tipoPesquisaCadastro;
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

}
