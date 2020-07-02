package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

public class CogeracaoEnergiaUsinasVO {
	
	private String ano = "";
	private String potenciaInstalada = "";
	private String totalEnergiaVendida = "";
	private String faturamento = "";

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPotenciaInstalada() {
		return potenciaInstalada;
	}

	public void setPotenciaInstalada(String potenciaInstalada) {
		this.potenciaInstalada = potenciaInstalada;
	}

	public String getTotalEnergiaVendida() {
		return totalEnergiaVendida;
	}

	public void setTotalEnergiaVendida(String totalEnergiaVendida) {
		this.totalEnergiaVendida = totalEnergiaVendida;
	}

	public String getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(String faturamento) {
		this.faturamento = faturamento;
	}

}
