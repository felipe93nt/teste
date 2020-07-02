package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class ValoresLocadorasVO {

	private String ano = "";

	// -- INICIO % Faturamento
	private String prcLocacao = "";
	private String prcVendaVeiculos = "";
	private String prcOutros = "";
	private String prcTotal = "";
	// -- FIM % Faturamento

	// -- INICIO Frota em unidades
	private String qtdTotal = "";
	private String qtdVendaVeiculosAno = "";
	// -- FIM Frota em unidades

	public String getPrcTotalFormatado(){
		if(!SiteUtil.getInstance().valorVazio(prcTotal)){
			return SiteUtil.getInstance().formatValoresToString(prcTotal);
		}
		return null;
	}
	
	public String getPrcLocacao() {
		return prcLocacao;
	}

	public String getPrcTotal() {
		return prcTotal;
	}

	public void setPrcTotal(String prcTotal) {
		this.prcTotal = prcTotal;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setPrcLocacao(String prcLocacao) {
		this.prcLocacao = prcLocacao;
	}

	public String getPrcVendaVeiculos() {
		return prcVendaVeiculos;
	}

	public void setPrcVendaVeiculos(String prcVendaVeiculos) {
		this.prcVendaVeiculos = prcVendaVeiculos;
	}

	public String getPrcOutros() {
		return prcOutros;
	}

	public void setPrcOutros(String prcOutros) {
		this.prcOutros = prcOutros;
	}

	public String getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(String prcTotal) {
		this.qtdTotal = prcTotal;
	}

	public String getQtdVendaVeiculosAno() {
		return qtdVendaVeiculosAno;
	}

	public void setQtdVendaVeiculosAno(String prcVendaVeiculosAno) {
		this.qtdVendaVeiculosAno = prcVendaVeiculosAno;
	}

}
