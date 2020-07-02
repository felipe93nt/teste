package br.com.bradesco.web.ricc.enums;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public enum SituacaoRelatorioEnum {
	PROVISORIO (0, "Provisório"),
	ATIVO (1, "Ativo"),
	PENDENTE (2, "Pendente");
	
	private Integer codigo = null;
	private String descricao = null;
	
	private SituacaoRelatorioEnum(Integer codigo, String descricao) {
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
	
	public static boolean isNotSituacaoProvisorio(String codigo){
		Integer _codidoInteger = SiteUtil.getInstance().nullToInteger(codigo);
		if(PROVISORIO.getCodigo().compareTo(_codidoInteger) != 0){
			return true;
		}
		return false;
	}
}
