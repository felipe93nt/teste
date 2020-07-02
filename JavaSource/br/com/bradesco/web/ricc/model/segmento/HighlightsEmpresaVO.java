package br.com.bradesco.web.ricc.model.segmento;

import java.util.Date;

public class HighlightsEmpresaVO {

	private Date balanco;
	private String receitaLiquida;
	private String contasAReceber;
	private String estoques;
	private String gerBrutaCaixa;
	private String margemOperacional;
	private String lucroPrejuizoLiquido;
	private String patrimonioLiquido;
	private String endividamentoFinanceiroTotal;
	private String disponibilidades;
	private String endividamentoFinanceiroLiquido;
	private String numSequencial;

	public Date getBalanco() {
		return balanco;
	}

	public void setBalanco(Date balanco) {
		this.balanco = balanco;
	}

	public String getReceitaLiquida() {
		return receitaLiquida;
	}

	public void setReceitaLiquida(String receitaLiquida) {
		this.receitaLiquida = receitaLiquida;
	}

	public String getContasAReceber() {
		return contasAReceber;
	}

	public void setContasAReceber(String contasAReceber) {
		this.contasAReceber = contasAReceber;
	}

	public String getEstoques() {
		return estoques;
	}

	public void setEstoques(String estoques) {
		this.estoques = estoques;
	}

	public String getGerBrutaCaixa() {
		return gerBrutaCaixa;
	}

	public void setGerBrutaCaixa(String gerBrutaCaixa) {
		this.gerBrutaCaixa = gerBrutaCaixa;
	}

	public String getMargemOperacional() {
		return margemOperacional;
	}

	public void setMargemOperacional(String margemOperacional) {
		this.margemOperacional = margemOperacional;
	}

	public String getLucroPrejuizoLiquido() {
		return lucroPrejuizoLiquido;
	}

	public void setLucroPrejuizoLiquido(String lucroPrejuizoLiquido) {
		this.lucroPrejuizoLiquido = lucroPrejuizoLiquido;
	}

	public String getPatrimonioLiquido() {
		return patrimonioLiquido;
	}

	public void setPatrimonioLiquido(String patrimonioLiquido) {
		this.patrimonioLiquido = patrimonioLiquido;
	}

	public String getEndividamentoFinanceiroTotal() {
		return endividamentoFinanceiroTotal;
	}

	public void setEndividamentoFinanceiroTotal(
			String endividamentoFinanceiroTotal) {
		this.endividamentoFinanceiroTotal = endividamentoFinanceiroTotal;
	}

	public String getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(String disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

	public String getEndividamentoFinanceiroLiquido() {
		return endividamentoFinanceiroLiquido;
	}

	public void setEndividamentoFinanceiroLiquido(
			String endividamentoFinanceiroLiquido) {
		this.endividamentoFinanceiroLiquido = endividamentoFinanceiroLiquido;
	}

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balanco == null) ? 0 : balanco.hashCode());
		result = prime * result
				+ ((contasAReceber == null) ? 0 : contasAReceber.hashCode());
		result = prime
				* result
				+ ((disponibilidades == null) ? 0 : disponibilidades.hashCode());
		result = prime
				* result
				+ ((endividamentoFinanceiroLiquido == null) ? 0
						: endividamentoFinanceiroLiquido.hashCode());
		result = prime
				* result
				+ ((endividamentoFinanceiroTotal == null) ? 0
						: endividamentoFinanceiroTotal.hashCode());
		result = prime * result
				+ ((estoques == null) ? 0 : estoques.hashCode());
		result = prime * result
				+ ((gerBrutaCaixa == null) ? 0 : gerBrutaCaixa.hashCode());
		result = prime
				* result
				+ ((lucroPrejuizoLiquido == null) ? 0 : lucroPrejuizoLiquido
						.hashCode());
		result = prime
				* result
				+ ((margemOperacional == null) ? 0 : margemOperacional
						.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		result = prime
				* result
				+ ((patrimonioLiquido == null) ? 0 : patrimonioLiquido
						.hashCode());
		result = prime * result
				+ ((receitaLiquida == null) ? 0 : receitaLiquida.hashCode());
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
		HighlightsEmpresaVO other = (HighlightsEmpresaVO) obj;
		if (balanco == null) {
			if (other.balanco != null)
				return false;
		} else if (!balanco.equals(other.balanco))
			return false;
		if (contasAReceber == null) {
			if (other.contasAReceber != null)
				return false;
		} else if (!contasAReceber.equals(other.contasAReceber))
			return false;
		if (disponibilidades == null) {
			if (other.disponibilidades != null)
				return false;
		} else if (!disponibilidades.equals(other.disponibilidades))
			return false;
		if (endividamentoFinanceiroLiquido == null) {
			if (other.endividamentoFinanceiroLiquido != null)
				return false;
		} else if (!endividamentoFinanceiroLiquido
				.equals(other.endividamentoFinanceiroLiquido))
			return false;
		if (endividamentoFinanceiroTotal == null) {
			if (other.endividamentoFinanceiroTotal != null)
				return false;
		} else if (!endividamentoFinanceiroTotal
				.equals(other.endividamentoFinanceiroTotal))
			return false;
		if (estoques == null) {
			if (other.estoques != null)
				return false;
		} else if (!estoques.equals(other.estoques))
			return false;
		if (gerBrutaCaixa == null) {
			if (other.gerBrutaCaixa != null)
				return false;
		} else if (!gerBrutaCaixa.equals(other.gerBrutaCaixa))
			return false;
		if (lucroPrejuizoLiquido == null) {
			if (other.lucroPrejuizoLiquido != null)
				return false;
		} else if (!lucroPrejuizoLiquido.equals(other.lucroPrejuizoLiquido))
			return false;
		if (margemOperacional == null) {
			if (other.margemOperacional != null)
				return false;
		} else if (!margemOperacional.equals(other.margemOperacional))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (patrimonioLiquido == null) {
			if (other.patrimonioLiquido != null)
				return false;
		} else if (!patrimonioLiquido.equals(other.patrimonioLiquido))
			return false;
		if (receitaLiquida == null) {
			if (other.receitaLiquida != null)
				return false;
		} else if (!receitaLiquida.equals(other.receitaLiquida))
			return false;
		return true;
	}
	
	
}
