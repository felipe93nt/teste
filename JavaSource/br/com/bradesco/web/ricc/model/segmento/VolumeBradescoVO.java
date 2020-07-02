package br.com.bradesco.web.ricc.model.segmento;


//11. Reciprocidades não capturadas na aba "reciprocidade" no CLIM/ANAC
public class VolumeBradescoVO {

	private String ano;
	private String mes;

	private String cobrancaValor;
	private String cobrancaQuantidade;
	private String cobrancaResultLiq;

	private String pagforValor;
	private String pagforQuantidade;
	private String pagforResultLiq;

	private String ptrbValor;
	private String ptrbQuantidade;

	private String netEmpresaValor;
	private String netEmpresaQuantidade;

	private String folhaPabValor;
	private String folhaPabQtdFuncionarios;
	private String folhaPabResultado;

	private String creditoConsignadoValor;
	private String creditoConsignadoQtdFuncionarios;
	private String creditoConsignadoResultado;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getCobrancaValor() {
		return cobrancaValor;
	}

	public void setCobrancaValor(String cobrancaValor) {
		this.cobrancaValor = cobrancaValor;
	}

	public String getCobrancaQuantidade() {
		return cobrancaQuantidade;
	}

	public void setCobrancaQuantidade(String cobrancaQuantidade) {
		this.cobrancaQuantidade = cobrancaQuantidade;
	}

	public String getCobrancaResultLiq() {
		return cobrancaResultLiq;
	}

	public void setCobrancaResultLiq(String cobrancaResultLiq) {
		this.cobrancaResultLiq = cobrancaResultLiq;
	}

	public String getPagforValor() {
		return pagforValor;
	}

	public void setPagforValor(String pagforValor) {
		this.pagforValor = pagforValor;
	}

	public String getPagforQuantidade() {
		return pagforQuantidade;
	}

	public void setPagforQuantidade(String pagforQuantidade) {
		this.pagforQuantidade = pagforQuantidade;
	}

	public String getPagforResultLiq() {
		return pagforResultLiq;
	}

	public void setPagforResultLiq(String pagforResultLiq) {
		this.pagforResultLiq = pagforResultLiq;
	}

	public String getPtrbValor() {
		return ptrbValor;
	}

	public void setPtrbValor(String ptrbValor) {
		this.ptrbValor = ptrbValor;
	}

	public String getPtrbQuantidade() {
		return ptrbQuantidade;
	}

	public void setPtrbQuantidade(String ptrbQuantidade) {
		this.ptrbQuantidade = ptrbQuantidade;
	}

	public String getNetEmpresaValor() {
		return netEmpresaValor;
	}

	public void setNetEmpresaValor(String netEmpresaValor) {
		this.netEmpresaValor = netEmpresaValor;
	}

	public String getNetEmpresaQuantidade() {
		return netEmpresaQuantidade;
	}

	public void setNetEmpresaQuantidade(String netEmpresaQuantidade) {
		this.netEmpresaQuantidade = netEmpresaQuantidade;
	}

	public String getFolhaPabValor() {
		return folhaPabValor;
	}

	public void setFolhaPabValor(String folhaPabValor) {
		this.folhaPabValor = folhaPabValor;
	}

	public String getFolhaPabQtdFuncionarios() {
		return folhaPabQtdFuncionarios;
	}

	public void setFolhaPabQtdFuncionarios(String folhaPabQtdFuncionarios) {
		this.folhaPabQtdFuncionarios = folhaPabQtdFuncionarios;
	}

	public String getFolhaPabResultado() {
		return folhaPabResultado;
	}

	public void setFolhaPabResultado(String folhaPabResultado) {
		this.folhaPabResultado = folhaPabResultado;
	}

	public String getCreditoConsignadoValor() {
		return creditoConsignadoValor;
	}

	public void setCreditoConsignadoValor(String creditoConsignadoValor) {
		this.creditoConsignadoValor = creditoConsignadoValor;
	}

	public String getCreditoConsignadoQtdFuncionarios() {
		return creditoConsignadoQtdFuncionarios;
	}

	public void setCreditoConsignadoQtdFuncionarios(
			String creditoConsignadoQtdFuncionarios) {
		this.creditoConsignadoQtdFuncionarios = creditoConsignadoQtdFuncionarios;
	}

	public String getCreditoConsignadoResultado() {
		return creditoConsignadoResultado;
	}

	public void setCreditoConsignadoResultado(String creditoConsignadoResultado) {
		this.creditoConsignadoResultado = creditoConsignadoResultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((ano == null) ? 0 : ano
						.hashCode());
		result = prime
				* result
				+ ((mes == null) ? 0 : mes
						.hashCode());
		result = prime
				* result
				+ ((cobrancaQuantidade == null) ? 0 : cobrancaQuantidade
						.hashCode());
		result = prime
				* result
				+ ((cobrancaResultLiq == null) ? 0 : cobrancaResultLiq
						.hashCode());
		result = prime * result
				+ ((cobrancaValor == null) ? 0 : cobrancaValor.hashCode());
		result = prime
				* result
				+ ((creditoConsignadoQtdFuncionarios == null) ? 0
						: creditoConsignadoQtdFuncionarios.hashCode());
		result = prime
				* result
				+ ((creditoConsignadoResultado == null) ? 0
						: creditoConsignadoResultado.hashCode());
		result = prime
				* result
				+ ((creditoConsignadoValor == null) ? 0
						: creditoConsignadoValor.hashCode());
		result = prime
				* result
				+ ((folhaPabQtdFuncionarios == null) ? 0
						: folhaPabQtdFuncionarios.hashCode());
		result = prime
				* result
				+ ((folhaPabResultado == null) ? 0 : folhaPabResultado
						.hashCode());
		result = prime * result
				+ ((folhaPabValor == null) ? 0 : folhaPabValor.hashCode());
		result = prime
				* result
				+ ((netEmpresaQuantidade == null) ? 0 : netEmpresaQuantidade
						.hashCode());
		result = prime * result
				+ ((netEmpresaValor == null) ? 0 : netEmpresaValor.hashCode());
		result = prime
				* result
				+ ((pagforQuantidade == null) ? 0 : pagforQuantidade.hashCode());
		result = prime * result
				+ ((pagforResultLiq == null) ? 0 : pagforResultLiq.hashCode());
		result = prime * result
				+ ((pagforValor == null) ? 0 : pagforValor.hashCode());
		result = prime * result
				+ ((ptrbQuantidade == null) ? 0 : ptrbQuantidade.hashCode());
		result = prime * result
				+ ((ptrbValor == null) ? 0 : ptrbValor.hashCode());
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
		VolumeBradescoVO other = (VolumeBradescoVO) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (cobrancaQuantidade == null) {
			if (other.cobrancaQuantidade != null)
				return false;
		} else if (!cobrancaQuantidade.equals(other.cobrancaQuantidade))
			return false;
		if (cobrancaResultLiq == null) {
			if (other.cobrancaResultLiq != null)
				return false;
		} else if (!cobrancaResultLiq.equals(other.cobrancaResultLiq))
			return false;
		if (cobrancaValor == null) {
			if (other.cobrancaValor != null)
				return false;
		} else if (!cobrancaValor.equals(other.cobrancaValor))
			return false;
		if (creditoConsignadoQtdFuncionarios == null) {
			if (other.creditoConsignadoQtdFuncionarios != null)
				return false;
		} else if (!creditoConsignadoQtdFuncionarios
				.equals(other.creditoConsignadoQtdFuncionarios))
			return false;
		if (creditoConsignadoResultado == null) {
			if (other.creditoConsignadoResultado != null)
				return false;
		} else if (!creditoConsignadoResultado
				.equals(other.creditoConsignadoResultado))
			return false;
		if (creditoConsignadoValor == null) {
			if (other.creditoConsignadoValor != null)
				return false;
		} else if (!creditoConsignadoValor.equals(other.creditoConsignadoValor))
			return false;
		if (folhaPabQtdFuncionarios == null) {
			if (other.folhaPabQtdFuncionarios != null)
				return false;
		} else if (!folhaPabQtdFuncionarios
				.equals(other.folhaPabQtdFuncionarios))
			return false;
		if (folhaPabResultado == null) {
			if (other.folhaPabResultado != null)
				return false;
		} else if (!folhaPabResultado.equals(other.folhaPabResultado))
			return false;
		if (folhaPabValor == null) {
			if (other.folhaPabValor != null)
				return false;
		} else if (!folhaPabValor.equals(other.folhaPabValor))
			return false;
		if (netEmpresaQuantidade == null) {
			if (other.netEmpresaQuantidade != null)
				return false;
		} else if (!netEmpresaQuantidade.equals(other.netEmpresaQuantidade))
			return false;
		if (netEmpresaValor == null) {
			if (other.netEmpresaValor != null)
				return false;
		} else if (!netEmpresaValor.equals(other.netEmpresaValor))
			return false;
		if (pagforQuantidade == null) {
			if (other.pagforQuantidade != null)
				return false;
		} else if (!pagforQuantidade.equals(other.pagforQuantidade))
			return false;
		if (pagforResultLiq == null) {
			if (other.pagforResultLiq != null)
				return false;
		} else if (!pagforResultLiq.equals(other.pagforResultLiq))
			return false;
		if (pagforValor == null) {
			if (other.pagforValor != null)
				return false;
		} else if (!pagforValor.equals(other.pagforValor))
			return false;
		if (ptrbQuantidade == null) {
			if (other.ptrbQuantidade != null)
				return false;
		} else if (!ptrbQuantidade.equals(other.ptrbQuantidade))
			return false;
		if (ptrbValor == null) {
			if (other.ptrbValor != null)
				return false;
		} else if (!ptrbValor.equals(other.ptrbValor))
			return false;
		return true;
	}

}
