package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class CustosOperacionaisVO {

	// -- INICIO % em relação ao custo total
	private String ano = "";

	private String prcCombustiveis = "";
	private String prcMaoDeObra = "";
	private String prcOutros = "";
	private String prcTotal = "";
	// -- FIM % em relação ao custo total
	
	public String getPrcTotalFormatado(){
		if(!SiteUtil.getInstance().valorVazio(prcTotal)){
			return SiteUtil.getInstance().formatValoresToString(prcTotal);
		}
		return null;
	}
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPrcCombustiveis() {
		return prcCombustiveis;
	}

	public void setPrcCombustiveis(String prcCombustiveis) {
		this.prcCombustiveis = prcCombustiveis;
	}

	public String getPrcMaoDeObra() {
		return prcMaoDeObra;
	}

	public void setPrcMaoDeObra(String prcMaoDeObra) {
		this.prcMaoDeObra = prcMaoDeObra;
	}

	public String getPrcOutros() {
		return prcOutros;
	}

	public void setPrcOutros(String prcOutros) {
		this.prcOutros = prcOutros;
	}

	public String getPrcTotal() {
		return prcTotal;
	}

	public void setPrcTotal(String prcTotal) {
		this.prcTotal = prcTotal;
	}

}
