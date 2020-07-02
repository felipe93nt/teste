package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class FornecedorVO implements Comparable<FornecedorVO> {

	private String fornecedor;
	private String porcentagem;
	private String tipoCliente;
	private String numSequencial = "0";

	private SiteUtil siteUtil = SiteUtil.getInstance();
	
	public FornecedorVO() {

	}

	public FornecedorVO(String fornecedor, String porcentagem) {
		super();
		this.fornecedor = fornecedor;
		this.porcentagem = porcentagem;
	}
	
	public String getPorcentagemFormatado() {
		return SiteUtil.getInstance().formatValoresToString(porcentagem);
	}

	public String getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getPorcentagem() {
		return porcentagem;
	}
	
	public void setPorcentagem(String porcentagem) {
		this.porcentagem = porcentagem;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	@Override
	public int compareTo(FornecedorVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		result = prime * result
				+ ((porcentagem == null) ? 0 : porcentagem.hashCode());
		result = prime * result
				+ ((tipoCliente == null) ? 0 : tipoCliente.hashCode());
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
		FornecedorVO other = (FornecedorVO) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (porcentagem == null) {
			if (other.porcentagem != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcentagem).equals(other.porcentagem))
			return false;
		if (tipoCliente == null) {
			if (other.tipoCliente != null)
				return false;
		} else if (!tipoCliente.equals(other.tipoCliente))
			return false;
		return true;
	}

	
}
