package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class TipoContratosVO {

	private String ano = "";

	private String prcAPerformar = "";
	private String prcTakeOrPay = "";
	private String prcLocacao = "";
	private String prcSpot = "";
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

	public String getPrcAPerformar() {
		return prcAPerformar;
	}

	public void setPrcAPerformar(String prcAPerformar) {
		this.prcAPerformar = prcAPerformar;
	}

	public String getPrcTakeOrPay() {
		return prcTakeOrPay;
	}

	public void setPrcTakeOrPay(String prcTakeOrPay) {
		this.prcTakeOrPay = prcTakeOrPay;
	}

	public String getPrcLocacao() {
		return prcLocacao;
	}

	public void setPrcLocacao(String prcLocacao) {
		this.prcLocacao = prcLocacao;
	}

	public String getPrcSpot() {
		return prcSpot;
	}

	public void setPrcSpot(String prcSpot) {
		this.prcSpot = prcSpot;
	}

	public String getPrcTotal() {
		return prcTotal;
	}

	public void setPrcTotal(String prcTotal) {
		this.prcTotal = prcTotal;
	}

}
