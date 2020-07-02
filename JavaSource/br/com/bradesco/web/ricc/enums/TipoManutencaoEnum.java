package br.com.bradesco.web.ricc.enums;

/**
 * @name TipoManutencaoEnum
 * @author Foursys
 * @see TipoManutencaoEnum.java
 * @version 1.0
 * @since 07/09/2018
 */
public enum TipoManutencaoEnum {

	MANUTENCAO(0, "Manuten��o"),
	INCLUSAO (1, "Inclus�o"),
	EXCLUSAO (2, "Exclus�o"),
	ALTERACAO (3, "Altera��o");

	private Integer codigo = null;
	private String descricao = null;

	private TipoManutencaoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCodigoString() {
		return String.valueOf(codigo);
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
