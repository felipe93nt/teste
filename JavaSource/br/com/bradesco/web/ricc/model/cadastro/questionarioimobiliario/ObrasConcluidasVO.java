package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class ObrasConcluidasVO implements Comparable<ObrasConcluidasVO>,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8797668904756201033L;

	private Integer numSequencial = 0;

	private String incorporadora = "";
	private String nomeEmpreendimento = "";
	private String uf = "";
	private String cidade = "";
	private String bairro = "";
	private String dataEntrega = "";

	private String valoresRecebidos = "";
	private String valoresAte12Meses = "";
	private String valoresDe12Ate36Meses = "";
	private String valoresApos36Meses = "";

	private String qtdeUnidades = "";
	private String valorEstoque = "";
	private String porcentagemVendas = "";

	private String agenteFinanceiro = "";
	private String saldoDevedor = "";

	private String descObrasConcluidas = "";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();
	
	//Inicio Formatados
	
	public String getValoresRecebidosFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valoresRecebidos);
	}
	
	public String getValoresAte12MesesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valoresAte12Meses);
	}

	public String getValoresDe12Ate36MesesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valoresDe12Ate36Meses);
	}

	public String getValoresApos36MesesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valoresApos36Meses);
	}

	public String getQtdeUnidadesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(qtdeUnidades);
	}

	public String getValorEstoqueFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valorEstoque);
	}

	public String getSaldoDevedorFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(saldoDevedor);
	}
	
	//Fim Formatados

	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getIncorporadora() {
		return incorporadora;
	}

	public void setIncorporadora(String incorporadora) {
		this.incorporadora = incorporadora;
	}

	public String getNomeEmpreendimento() {
		return nomeEmpreendimento;
	}

	public void setNomeEmpreendimento(String nomeEmpreendimento) {
		this.nomeEmpreendimento = nomeEmpreendimento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getValoresRecebidos() {
		return valoresRecebidos;
	}

	public void setValoresRecebidos(String valoresRecebidos) {
		this.valoresRecebidos = valoresRecebidos;
	}

	public String getValoresAte12Meses() {
		return valoresAte12Meses;
	}

	public void setValoresAte12Meses(String valoresAte12Meses) {
		this.valoresAte12Meses = valoresAte12Meses;
	}

	public String getValoresDe12Ate36Meses() {
		return valoresDe12Ate36Meses;
	}

	public void setValoresDe12Ate36Meses(String valoresDe12Ate36Meses) {
		this.valoresDe12Ate36Meses = valoresDe12Ate36Meses;
	}

	public String getValoresApos36Meses() {
		return valoresApos36Meses;
	}

	public void setValoresApos36Meses(String valoresApos36Meses) {
		this.valoresApos36Meses = valoresApos36Meses;
	}

	public String getQtdeUnidades() {
		return qtdeUnidades;
	}

	public void setQtdeUnidades(String qtdeUnidades) {
		this.qtdeUnidades = qtdeUnidades;
	}

	public String getValorEstoque() {
		return valorEstoque;
	}

	public void setValorEstoque(String valorEstoque) {
		this.valorEstoque = valorEstoque;
	}

	public String getPorcentagemVendas() {
		return porcentagemVendas;
	}

	public void setPorcentagemVendas(String porcentagemVendas) {
		this.porcentagemVendas = porcentagemVendas;
	}

	public String getAgenteFinanceiro() {
		return agenteFinanceiro;
	}

	public void setAgenteFinanceiro(String agenteFinanceiro) {
		this.agenteFinanceiro = agenteFinanceiro;
	}

	public String getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(String saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescObrasConcluidas() {
		return descObrasConcluidas;
	}

	public void setDescObrasConcluidas(String descObrasConcluidas) {
		this.descObrasConcluidas = descObrasConcluidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((agenteFinanceiro == null) ? 0 : agenteFinanceiro.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
		result = prime * result
				+ ((incorporadora == null) ? 0 : incorporadora.hashCode());
		result = prime
				* result
				+ ((nomeEmpreendimento == null) ? 0 : nomeEmpreendimento
						.hashCode());
		result = prime
				* result
				+ ((porcentagemVendas == null) ? 0 : porcentagemVendas
						.hashCode());
		result = prime * result
				+ ((qtdeUnidades == null) ? 0 : qtdeUnidades.hashCode());
		result = prime * result
				+ ((saldoDevedor == null) ? 0 : saldoDevedor.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result
				+ ((valorEstoque == null) ? 0 : valorEstoque.hashCode());
		result = prime
				* result
				+ ((valoresApos36Meses == null) ? 0 : valoresApos36Meses
						.hashCode());
		result = prime
				* result
				+ ((valoresAte12Meses == null) ? 0 : valoresAte12Meses
						.hashCode());
		result = prime
				* result
				+ ((valoresDe12Ate36Meses == null) ? 0 : valoresDe12Ate36Meses
						.hashCode());
		result = prime
				* result
				+ ((valoresRecebidos == null) ? 0 : valoresRecebidos.hashCode());
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
		ObrasConcluidasVO other = (ObrasConcluidasVO) obj;
		if (agenteFinanceiro == null) {
			if (other.agenteFinanceiro != null)
				return false;
		} else if (!agenteFinanceiro.equals(other.agenteFinanceiro))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (dataEntrega == null) {
			if (other.dataEntrega != null)
				return false;
		} else if (!dataEntrega.equals(other.dataEntrega.replace(".", "/")))
			return false;
		if (incorporadora == null) {
			if (other.incorporadora != null)
				return false;
		} else if (!incorporadora.equals(other.incorporadora))
			return false;
		if (nomeEmpreendimento == null) {
			if (other.nomeEmpreendimento != null)
				return false;
		} else if (!nomeEmpreendimento.equals(other.nomeEmpreendimento))
			return false;
		if (porcentagemVendas == null) {
			if (other.porcentagemVendas != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcentagemVendas).equals(other.porcentagemVendas))
			return false;
		if (qtdeUnidades == null) {
			if (other.qtdeUnidades != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(qtdeUnidades).equals(other.qtdeUnidades))
			return false;
		if (saldoDevedor == null) {
			if (other.saldoDevedor != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(saldoDevedor).equals(other.saldoDevedor))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (valorEstoque == null) {
			if (other.valorEstoque != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valorEstoque).equals(other.valorEstoque))
			return false;
		if (valoresApos36Meses == null) {
			if (other.valoresApos36Meses != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valoresApos36Meses).equals(other.valoresApos36Meses))
			return false;
		if (valoresAte12Meses == null) {
			if (other.valoresAte12Meses != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valoresAte12Meses).equals(other.valoresAte12Meses))
			return false;
		if (valoresDe12Ate36Meses == null) {
			if (other.valoresDe12Ate36Meses != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valoresDe12Ate36Meses).equals(other.valoresDe12Ate36Meses))
			return false;
		if (valoresRecebidos == null) {
			if (other.valoresRecebidos != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valoresRecebidos).equals(other.valoresRecebidos))
			return false;
		return true;
	}

	@Override
	public int compareTo(ObrasConcluidasVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}
}
