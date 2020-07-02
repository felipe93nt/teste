package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class TransportesCargasVO {

	private String ano = "";

	private String prcPropria = "";
	private String prcAgregados = "";
	private String prcTerceiros = "";
	private String prcTotal = "";
	
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

	public String getPrcPropria() {
		return prcPropria;
	}

	public void setPrcPropria(String prcPropria) {
		this.prcPropria = prcPropria;
	}

	public String getPrcAgregados() {
		return prcAgregados;
	}

	public void setPrcAgregados(String prcAgregados) {
		this.prcAgregados = prcAgregados;
	}

	public String getPrcTerceiros() {
		return prcTerceiros;
	}

	public void setPrcTerceiros(String prcTerceiros) {
		this.prcTerceiros = prcTerceiros;
	}

	public String getPrcTotal() {
		return prcTotal;
	}

	public void setPrcTotal(String prcTotal) {
		this.prcTotal = prcTotal;
	}

}
