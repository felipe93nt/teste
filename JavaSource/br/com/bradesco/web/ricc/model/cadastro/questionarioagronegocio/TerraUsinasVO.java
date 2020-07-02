package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class TerraUsinasVO {

	private String ano = "";
	private String areaPropria = "";
	private String areaArrendada = "";
	private String areaTotal = "";
	private String areaRenovacao = "";
	private String areaExpansao = "";

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAreaPropria() {
		return areaPropria;
	}

	public void setAreaPropria(String areaPropria) {
		this.areaPropria = areaPropria;
	}

	public String getAreaArrendada() {
		return areaArrendada;
	}

	public void setAreaArrendada(String areaArrendada) {
		this.areaArrendada = areaArrendada;
	}

	public String getAreaTotal() {
		return areaTotal;
	}

	public String getAreaTotalFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(areaTotal);
	}
	
	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
	}

	public String getAreaRenovacao() {
		return areaRenovacao;
	}

	public void setAreaRenovacao(String areaRenovacao) {
		this.areaRenovacao = areaRenovacao;
	}

	public String getAreaExpansao() {
		return areaExpansao;
	}

	public void setAreaExpansao(String areaExpansao) {
		this.areaExpansao = areaExpansao;
	}

}
