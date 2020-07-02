package br.com.bradesco.web.ricc.model.segmento;

//10. Perspectivas
public class PerspectivasVO {

	private String faturamento;
	private String ebitda;
	private String lucroLiquido;
	private String dividaBancaria;
	private String posicaoCaixa;

	public String getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(String faturamento) {
		this.faturamento = faturamento;
	}

	public String getEbitda() {
		return ebitda;
	}

	public void setEbitda(String ebitda) {
		this.ebitda = ebitda;
	}

	public String getLucroLiquido() {
		return lucroLiquido;
	}

	public void setLucroLiquido(String lucroLiquido) {
		this.lucroLiquido = lucroLiquido;
	}

	public String getDividaBancaria() {
		return dividaBancaria;
	}

	public void setDividaBancaria(String dividaBancaria) {
		this.dividaBancaria = dividaBancaria;
	}

	public String getPosicaoCaixa() {
		return posicaoCaixa;
	}

	public void setPosicaoCaixa(String posicaoCaixa) {
		this.posicaoCaixa = posicaoCaixa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dividaBancaria == null) ? 0 : dividaBancaria.hashCode());
		result = prime * result + ((ebitda == null) ? 0 : ebitda.hashCode());
		result = prime * result
				+ ((faturamento == null) ? 0 : faturamento.hashCode());
		result = prime * result
				+ ((lucroLiquido == null) ? 0 : lucroLiquido.hashCode());
		result = prime * result
				+ ((posicaoCaixa == null) ? 0 : posicaoCaixa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerspectivasVO other = (PerspectivasVO) obj;
		if (dividaBancaria == null) {
			if (other.dividaBancaria != null)
				return false;
		} else if (!dividaBancaria.equals(other.dividaBancaria))
			return false;
		if (ebitda == null) {
			if (other.ebitda != null)
				return false;
		} else if (!ebitda.equals(other.ebitda))
			return false;
		if (faturamento == null) {
			if (other.faturamento != null)
				return false;
		} else if (!faturamento.equals(other.faturamento))
			return false;
		if (lucroLiquido == null) {
			if (other.lucroLiquido != null)
				return false;
		} else if (!lucroLiquido.equals(other.lucroLiquido))
			return false;
		if (posicaoCaixa == null) {
			if (other.posicaoCaixa != null)
				return false;
		} else if (!posicaoCaixa.equals(other.posicaoCaixa))
			return false;
		return true;
	}
	
}
