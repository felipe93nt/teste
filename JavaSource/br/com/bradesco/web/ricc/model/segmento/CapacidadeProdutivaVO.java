package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

//5. Capacidade Produtiva (se aplicável)
public class CapacidadeProdutivaVO implements Comparable<CapacidadeProdutivaVO> {
	
	private String plantas;
	private String producao;
	private String utilizada;
	private String utilizacaoPercentual;
	private String numSequencial = "0";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();
	
	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	public CapacidadeProdutivaVO (){
		
	}
	
	public CapacidadeProdutivaVO(String plantas, String producao,
			String utilizada, String utilizacaoPercentual) {
		super();
		this.plantas = plantas;
		this.producao = producao;
		this.utilizada = utilizada;
		this.utilizacaoPercentual = utilizacaoPercentual;
	}
	
	public String getUtilizadaFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(utilizada);
	}
	
	public String getProducaoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(producao);
	}

	public String getUtilizacaoPercentualFormatado() {
		return SiteUtil.getInstance().formatValoresToString(utilizacaoPercentual);
	}
	
	public String getPlantas() {
		return plantas;
	}

	public void setPlantas(String plantas) {
		this.plantas = plantas;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

	public String getUtilizada() {
		return utilizada;
	}
	
	public void setUtilizada(String utilizada) {
		this.utilizada = utilizada;
	}

	public String getUtilizacaoPercentual() {
		return utilizacaoPercentual;
	}
	
	public void setUtilizacaoPercentual(String utilizacaoPercentual) {
		this.utilizacaoPercentual = utilizacaoPercentual;
	}

	@Override
	public int compareTo(CapacidadeProdutivaVO o) {
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
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		result = prime * result + ((plantas == null) ? 0 : plantas.hashCode());
		result = prime * result
				+ ((producao == null) ? 0 : producao.hashCode());
		result = prime
				* result
				+ ((utilizacaoPercentual == null) ? 0 : utilizacaoPercentual
						.hashCode());
		result = prime * result
				+ ((utilizada == null) ? 0 : utilizada.hashCode());
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
		CapacidadeProdutivaVO other = (CapacidadeProdutivaVO) obj;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (plantas == null) {
			if (other.plantas != null)
				return false;
		} else if (!plantas.equals(other.plantas))
			return false;
		if (producao == null) {
			if (other.producao != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(producao).equals(other.producao))
			return false;
		if (utilizacaoPercentual == null) {
			if (other.utilizacaoPercentual != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(utilizacaoPercentual).equals(other.utilizacaoPercentual))
			return false;
		if (utilizada == null) {
			if (other.utilizada != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(utilizada).equals(other.utilizada))
			return false;
		return true;
	}
	
	

}
