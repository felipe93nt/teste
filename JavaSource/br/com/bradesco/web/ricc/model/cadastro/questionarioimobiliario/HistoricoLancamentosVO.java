package br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario;

import java.io.Serializable;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class HistoricoLancamentosVO implements
		Comparable<HistoricoLancamentosVO>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2925093832655247791L;

	private Integer numSequencial = 0;
	private String ano = "";
	private String vgvLancado = "";
	private String qtdeEmpreendimentos = "";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public HistoricoLancamentosVO() {
		super();
	}

	public HistoricoLancamentosVO(String ano, String vgvLancado,
			String qtdeEmpreendimentos) {
		super();
		this.ano = ano;
		this.vgvLancado = vgvLancado;
		this.qtdeEmpreendimentos = qtdeEmpreendimentos;
	}
	
	public String getVgvLancadoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(vgvLancado);
	}
	
	public String getQtdeEmpreendimentosFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(qtdeEmpreendimentos);
	}

	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getVgvLancado() {
		return vgvLancado;
	}

	public void setVgvLancado(String vgvLancado) {
		this.vgvLancado = vgvLancado;
	}

	public String getQtdeEmpreendimentos() {
		return qtdeEmpreendimentos;
	}

	public void setQtdeEmpreendimentos(String qtdeEmpreendimentos) {
		this.qtdeEmpreendimentos = qtdeEmpreendimentos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime
				* result
				+ ((qtdeEmpreendimentos == null) ? 0 : qtdeEmpreendimentos
						.hashCode());
		result = prime * result
				+ ((vgvLancado == null) ? 0 : vgvLancado.hashCode());
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
		HistoricoLancamentosVO other = (HistoricoLancamentosVO) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (qtdeEmpreendimentos == null) {
			if (other.qtdeEmpreendimentos != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(qtdeEmpreendimentos).equals(other.qtdeEmpreendimentos))
			return false;
		if (vgvLancado == null) {
			if (other.vgvLancado != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(vgvLancado).equals(other.vgvLancado))
			return false;
		return true;
	}

	@Override
	public int compareTo(HistoricoLancamentosVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

}
