package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

public class CapitalInvestidoVO {

	// -- INICIO CAPEX(R$)
	private String ano = "";

	private String valorRecursosProprios = "";
	private String valorRecursosTerceiros = "";
	// -- FIM CAPEX(R$)

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getValorRecursosProprios() {
		return valorRecursosProprios;
	}

	public void setValorRecursosProprios(String prcRecursosProprios) {
		this.valorRecursosProprios = prcRecursosProprios;
	}

	public String getValorRecursosTerceiros() {
		return valorRecursosTerceiros;
	}

	public void setValorRecursosTerceiros(String prcRecursosTerceiros) {
		this.valorRecursosTerceiros = prcRecursosTerceiros;
	}

}
