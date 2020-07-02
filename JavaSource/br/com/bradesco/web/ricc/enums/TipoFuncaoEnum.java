package br.com.bradesco.web.ricc.enums;

public enum TipoFuncaoEnum {

	NOVO (1, "Novo"),
	SALVAR (2, "Salvar"),
	CONCLUIR (3, "Concluir");
	
	private Integer codigo = null;
	private String descricao = null;
	
	private TipoFuncaoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
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
