package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class MoagemUsinasVO {

	private String ano = "";
	private String capacidadeMoagem = "";
	private String canaAreaPropria = "";
	private String canaAreaArrendada = "";
	private String canaTerceiros = "";
	private String totalMoagem = "";

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCapacidadeMoagem() {
		return capacidadeMoagem;
	}

	public void setCapacidadeMoagem(String capacidadeMoagem) {
		this.capacidadeMoagem = capacidadeMoagem;
	}

	public String getCanaAreaPropria() {
		return canaAreaPropria;
	}

	public void setCanaAreaPropria(String canaAreaPropria) {
		this.canaAreaPropria = canaAreaPropria;
	}

	public String getCanaAreaArrendada() {
		return canaAreaArrendada;
	}

	public void setCanaAreaArrendada(String canaAreaArrendada) {
		this.canaAreaArrendada = canaAreaArrendada;
	}

	public String getCanaTerceiros() {
		return canaTerceiros;
	}

	public void setCanaTerceiros(String canaTerceiros) {
		this.canaTerceiros = canaTerceiros;
	}

	public String getTotalMoagem() {
		return totalMoagem;
	}
	
	public String getTotalMoagemFormatado() {
		return SiteUtil.getInstance().formatValoresToString(totalMoagem);
	}
	
	public void setTotalMoagem(String totalMoagem) {
		this.totalMoagem = totalMoagem;
	}

}
