package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class ObrasAndamentoVO implements Comparable<ObrasAndamentoVO>,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3454185477321370672L;

	// Dados Obra
	private String incorporadora = "";
	private String nomeEmpreendimento = "";
	private String uf = "";
	private String cidade = "";
	private String bairro = "";
	private String porcPartEmpreendimento = "";
	private String dataLancamento = "";
	private String previsaoEntrega = "";
	private String porcentagemObra = "";

	// Custo
	private String totalObra = "";
	private String aIncorrer = "";

	// VGV
	private String vgvTotal = "";
	private String vgvSemPermutas = "";

	// Total Unidades
	private String totalUnidadesEstoque = "";
	private String totalUnidadesSemPermutas = "";
	private String totalUnidadesComPermutas = "";

	// Vendas Realizadas
	private String porcentagemVendas = "";
	private String porcentagemDistratos = "";
	private String valoresRecebidos = "";
	private String valoresAteChaves = "";
	private String valoresPosChaves = "";

	// Financiamento
	private String agenteFinanceiro = "";
	private String valorContrato = "";
	private String saldoALiberar = "";
	private String saldoDevedor = "";

	private String descObrasAndamento = "";
	
	private String numSequencial = "0";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();
	
	//Inicio Formatados
	
	public String getTotalObraFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalObra);
	}

	public String getaIncorrerFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(aIncorrer);
	}

	public String getVgvTotalFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(vgvTotal);
	}

	public String getVgvSemPermutasFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(vgvSemPermutas);
	}

	public String getTotalUnidadesEstoqueFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalUnidadesEstoque);
	}

	public String getTotalUnidadesSemPermutasFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalUnidadesSemPermutas);
	}

	public String getTotalUnidadesComPermutasFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(totalUnidadesComPermutas);
	}

	public String getValoresRecebidosFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valoresRecebidos);
	}

	public String getValoresAteChavesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valoresAteChaves);
	}

	public String getValoresPosChavesFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valoresPosChaves);
	}

	public String getValorContratoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valorContrato);
	}

	public String getSaldoALiberarFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(saldoALiberar);
	}

	public String getSaldoDevedorFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(saldoDevedor);
	}

	//Fim Formatados

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

	public String getPorcPartEmpreendimento() {
		return porcPartEmpreendimento;
	}

	public void setPorcPartEmpreendimento(String porcPartEmpreendimento) {
		this.porcPartEmpreendimento = porcPartEmpreendimento;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(String previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}

	public String getPorcentagemObra() {
		return porcentagemObra;
	}

	public void setPorcentagemObra(String porcentagemObra) {
		this.porcentagemObra = porcentagemObra;
	}

	public String getTotalObra() {
		return totalObra;
	}

	public void setTotalObra(String totalObra) {
		this.totalObra = totalObra;
	}

	public String getaIncorrer() {
		return aIncorrer;
	}

	public void setaIncorrer(String aIncorrer) {
		this.aIncorrer = aIncorrer;
	}

	public String getVgvTotal() {
		return vgvTotal;
	}

	public void setVgvTotal(String vgvTotal) {
		this.vgvTotal = vgvTotal;
	}

	public String getVgvSemPermutas() {
		return vgvSemPermutas;
	}

	public void setVgvSemPermutas(String vgvSemPermutas) {
		this.vgvSemPermutas = vgvSemPermutas;
	}

	public String getTotalUnidadesEstoque() {
		return totalUnidadesEstoque;
	}

	public void setTotalUnidadesEstoque(String totalUnidadesEstoque) {
		this.totalUnidadesEstoque = totalUnidadesEstoque;
	}

	public String getTotalUnidadesSemPermutas() {
		return totalUnidadesSemPermutas;
	}

	public void setTotalUnidadesSemPermutas(String totalUnidadesSemPermutas) {
		this.totalUnidadesSemPermutas = totalUnidadesSemPermutas;
	}

	public String getTotalUnidadesComPermutas() {
		return totalUnidadesComPermutas;
	}

	public void setTotalUnidadesComPermutas(String totalUnidadesComPermutas) {
		this.totalUnidadesComPermutas = totalUnidadesComPermutas;
	}

	public String getPorcentagemVendas() {
		return porcentagemVendas;
	}

	public void setPorcentagemVendas(String porcentagemVendas) {
		this.porcentagemVendas = porcentagemVendas;
	}

	public String getPorcentagemDistratos() {
		return porcentagemDistratos;
	}

	public void setPorcentagemDistratos(String porcentagemDistratos) {
		this.porcentagemDistratos = porcentagemDistratos;
	}

	public String getValoresRecebidos() {
		return valoresRecebidos;
	}

	public void setValoresRecebidos(String valoresRecebidos) {
		this.valoresRecebidos = valoresRecebidos;
	}

	public String getValoresAteChaves() {
		return valoresAteChaves;
	}

	public void setValoresAteChaves(String valoresAteChaves) {
		this.valoresAteChaves = valoresAteChaves;
	}

	public String getValoresPosChaves() {
		return valoresPosChaves;
	}

	public void setValoresPosChaves(String valoresPosChaves) {
		this.valoresPosChaves = valoresPosChaves;
	}

	public String getAgenteFinanceiro() {
		return agenteFinanceiro;
	}

	public void setAgenteFinanceiro(String agenteFinanceiro) {
		this.agenteFinanceiro = agenteFinanceiro;
	}

	public String getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(String valorContrato) {
		this.valorContrato = valorContrato;
	}

	public String getSaldoALiberar() {
		return saldoALiberar;
	}

	public void setSaldoALiberar(String saldoALiberar) {
		this.saldoALiberar = saldoALiberar;
	}

	public String getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(String saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	public String getDescObrasAndamento() {
		return descObrasAndamento;
	}

	public void setDescObrasAndamento(String descObrasAndamento) {
		this.descObrasAndamento = descObrasAndamento;
	}
	
	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aIncorrer == null) ? 0 : aIncorrer.hashCode());
		result = prime
				* result
				+ ((agenteFinanceiro == null) ? 0 : agenteFinanceiro.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((dataLancamento == null) ? 0 : dataLancamento.hashCode());
		result = prime * result
				+ ((incorporadora == null) ? 0 : incorporadora.hashCode());
		result = prime
				* result
				+ ((nomeEmpreendimento == null) ? 0 : nomeEmpreendimento
						.hashCode());
		result = prime
				* result
				+ ((porcPartEmpreendimento == null) ? 0
						: porcPartEmpreendimento.hashCode());
		result = prime
				* result
				+ ((porcentagemDistratos == null) ? 0 : porcentagemDistratos
						.hashCode());
		result = prime * result
				+ ((porcentagemObra == null) ? 0 : porcentagemObra.hashCode());
		result = prime
				* result
				+ ((porcentagemVendas == null) ? 0 : porcentagemVendas
						.hashCode());
		result = prime * result
				+ ((previsaoEntrega == null) ? 0 : previsaoEntrega.hashCode());
		result = prime * result
				+ ((saldoALiberar == null) ? 0 : saldoALiberar.hashCode());
		result = prime * result
				+ ((totalObra == null) ? 0 : totalObra.hashCode());
		result = prime
				* result
				+ ((totalUnidadesComPermutas == null) ? 0
						: totalUnidadesComPermutas.hashCode());
		result = prime
				* result
				+ ((totalUnidadesEstoque == null) ? 0 : totalUnidadesEstoque
						.hashCode());
		result = prime
				* result
				+ ((totalUnidadesSemPermutas == null) ? 0
						: totalUnidadesSemPermutas.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result
				+ ((valorContrato == null) ? 0 : valorContrato.hashCode());
		result = prime
				* result
				+ ((valoresAteChaves == null) ? 0 : valoresAteChaves.hashCode());
		result = prime
				* result
				+ ((valoresPosChaves == null) ? 0 : valoresPosChaves.hashCode());
		result = prime
				* result
				+ ((valoresRecebidos == null) ? 0 : valoresRecebidos.hashCode());
		result = prime * result
				+ ((vgvSemPermutas == null) ? 0 : vgvSemPermutas.hashCode());
		result = prime * result
				+ ((vgvTotal == null) ? 0 : vgvTotal.hashCode());
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
		ObrasAndamentoVO other = (ObrasAndamentoVO) obj;
		if (aIncorrer == null) {
			if (other.aIncorrer != null)
				return false;
		} else if (!aIncorrer.equals(other.aIncorrer))
			return false;
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
		if (dataLancamento == null) {
			if (other.dataLancamento != null)
				return false;
		} else if (!dataLancamento.equals(other.dataLancamento.replace(".", "/")))
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
		if (porcPartEmpreendimento == null) {
			if (other.porcPartEmpreendimento != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcPartEmpreendimento).equals(other.porcPartEmpreendimento))
			return false;
		if (porcentagemDistratos == null) {
			if (other.porcentagemDistratos != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcentagemDistratos).equals(other.porcentagemDistratos))
			return false;
		if (porcentagemObra == null) {
			if (other.porcentagemObra != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcentagemObra).equals(other.porcentagemObra))
			return false;
		if (porcentagemVendas == null) {
			if (other.porcentagemVendas != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(porcentagemVendas).equals(other.porcentagemVendas))
			return false;
		if (previsaoEntrega == null) {
			if (other.previsaoEntrega != null)
				return false;
		} else if (!previsaoEntrega.equals(other.previsaoEntrega.replace(".", "/")))
			return false;
		if (saldoALiberar == null) {
			if (other.saldoALiberar != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(saldoALiberar).equals(other.saldoALiberar))
			return false;
		if (totalObra == null) {
			if (other.totalObra != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(totalObra).equals(other.totalObra))
			return false;
		if (totalUnidadesComPermutas == null) {
			if (other.totalUnidadesComPermutas != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(totalUnidadesComPermutas)
				.equals(other.totalUnidadesComPermutas))
			return false;
		if (totalUnidadesEstoque == null) {
			if (other.totalUnidadesEstoque != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(totalUnidadesEstoque).equals(other.totalUnidadesEstoque))
			return false;
		if (totalUnidadesSemPermutas == null) {
			if (other.totalUnidadesSemPermutas != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(totalUnidadesSemPermutas)
				.equals(other.totalUnidadesSemPermutas))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (valorContrato == null) {
			if (other.valorContrato != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valorContrato).equals(other.valorContrato))
			return false;
		if (valoresAteChaves == null) {
			if (other.valoresAteChaves != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valoresAteChaves).equals(other.valoresAteChaves))
			return false;
		if (valoresPosChaves == null) {
			if (other.valoresPosChaves != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valoresPosChaves).equals(other.valoresPosChaves))
			return false;
		if (valoresRecebidos == null) {
			if (other.valoresRecebidos != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valoresRecebidos).equals(other.valoresRecebidos))
			return false;
		if (vgvSemPermutas == null) {
			if (other.vgvSemPermutas != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(vgvSemPermutas).equals(other.vgvSemPermutas))
			return false;
		if (vgvTotal == null) {
			if (other.vgvTotal != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(vgvTotal).equals(other.vgvTotal))
			return false;
		return true;
	}

	@Override
	public int compareTo(ObrasAndamentoVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}
}
