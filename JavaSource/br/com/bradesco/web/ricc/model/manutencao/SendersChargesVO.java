package br.com.bradesco.web.ricc.model.manutencao;

import br.com.bradesco.web.ricc.model.manutencao.SendersChargesVO;

public class SendersChargesVO implements Comparable<SendersChargesVO> {

	// Campos tabela
	private String occur = "";
	private String currency = "";
	private String amount = "";

	public String getOccur() {
		return occur;
	}

	public void setOccur(String occur) {
		this.occur = occur;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public int compareTo(SendersChargesVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
