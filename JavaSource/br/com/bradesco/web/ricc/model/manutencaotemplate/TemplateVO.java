package br.com.bradesco.web.ricc.model.manutencaotemplate;

import br.com.bradesco.web.ricc.model.manutencaotemplate.TemplateVO;

public class TemplateVO implements Comparable<TemplateVO>{
	
	// Campos tabela
	private String codigoTemplate = "";
	private String descricao = "";
	private String referencia = "";
	private String data = "";
	private String dataManutencao = "";
	
	public String getCodigoTemplate() {
		return codigoTemplate;
	}

	public void setCodigoTemplate(String codigoTemplate) {
		this.codigoTemplate = codigoTemplate;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(String dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	@Override
	public int compareTo(TemplateVO o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
