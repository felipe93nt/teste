package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import java.io.Serializable;

/**
 * @name QuestionarioAgronegocioVO
 * @author Foursys
 * @see QuestionarioAgronegocioVO.java
 * @version 1.0
 * @since 11/09/2018
 */
public class QuestionarioAgronegocioVO implements Serializable {

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = -6905718663241730715L;
	/**
	 * Atributo codGrupo Tipo String
	 */
	private String codGrupo = "";
	/**
	 * Atributo descGrupo Tipo String
	 */
	private String descGrupo = "";
	/**
	 * Atributo codSegmento Tipo String
	 */
	private String codSegmento = "";
	/**
	 * Atributo codRelatorio Tipo String
	 */
	private String codRelatorio = "";
	/**
	 * Atributo abaGraos Tipo GraosFibrasVO
	 */
	private GraosFibrasVO abaGraos = new GraosFibrasVO();
	/**
	 * Atributo abaUsinas Tipo UsinasVO
	 */
	private UsinasVO abaUsinas = new UsinasVO();
	/**
	 * Atributo versaoOrigem Tipo String
	 */
	private String versaoOrigem = "";

	/**
	 * @description
	 * @name getGrupoFormatado
	 * @see QuestionarioAgronegocioVO
	 * @return
	 * @return String
	 */
	public String getGrupoFormatado() {
		return this.codGrupo + " - " + this.descGrupo;
	}

	/**
	 * @return the codGrupo
	 */
	public String getCodGrupo() {
		return codGrupo;
	}

	/**
	 * @param codGrupo
	 *            the codGrupo to set
	 */
	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	/**
	 * @return the descGrupo
	 */
	public String getDescGrupo() {
		return descGrupo;
	}

	/**
	 * @param descGrupo
	 *            the descGrupo to set
	 */
	public void setDescGrupo(String descGrupo) {
		this.descGrupo = descGrupo;
	}

	/**
	 * @return the codSegmento
	 */
	public String getCodSegmento() {
		return codSegmento;
	}

	/**
	 * @param codSegmento
	 *            the codSegmento to set
	 */
	public void setCodSegmento(String codSegmento) {
		this.codSegmento = codSegmento;
	}

	/**
	 * @return the codRelatorio
	 */
	public String getCodRelatorio() {
		return codRelatorio;
	}

	/**
	 * @param codRelatorio
	 *            the codRelatorio to set
	 */
	public void setCodRelatorio(String codRelatorio) {
		this.codRelatorio = codRelatorio;
	}

	/**
	 * @return the abaGraos
	 */
	public GraosFibrasVO getAbaGraos() {
		return abaGraos;
	}

	/**
	 * @param abaGraos
	 *            the abaGraos to set
	 */
	public void setAbaGraos(GraosFibrasVO abaGraos) {
		this.abaGraos = abaGraos;
	}

	/**
	 * @return the abaUsinas
	 */
	public UsinasVO getAbaUsinas() {
		return abaUsinas;
	}

	/**
	 * @param abaUsinas
	 *            the abaUsinas to set
	 */
	public void setAbaUsinas(UsinasVO abaUsinas) {
		this.abaUsinas = abaUsinas;
	}

	/**
	 * @return the getVersaoOrigem
	 */
	public String getVersaoOrigem() {
		return versaoOrigem;
	}

	/**
	 * @param versaoOrigem
	 * 				the versaoOrigem to set
	 */
	public void setVersaoOrigem(String versaoOrigem) {
		this.versaoOrigem = versaoOrigem;
	}

}
