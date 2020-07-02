package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class AreaArrendadaAgronegocioVO implements
		Comparable<AreaArrendadaAgronegocioVO> {

	private Integer numSequencial = 0;
	private String descricao;
	private String areaTotal;
	private String areaProdutiva;
	private String cidade;
	private String custoArrendamento;
	private String inicioContrato;
	private String fimContrato;
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public AreaArrendadaAgronegocioVO() {
		super();
	}

	public AreaArrendadaAgronegocioVO(String descricao, String areaTotal,
			String areaProdutiva, String cidade, String custoArrendamento,
			String inicioContrato, String fimContrato) {
		super();
		this.descricao = descricao;
		this.areaTotal = areaTotal;
		this.areaProdutiva = areaProdutiva;
		this.cidade = cidade;
		this.custoArrendamento = custoArrendamento;
		this.inicioContrato = inicioContrato;
		this.fimContrato = fimContrato;
	}

	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}

	@Override
	public int compareTo(AreaArrendadaAgronegocioVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}
	
	public String getInicioContratoFormatado() {
		return inicioContrato;
	}

	public String getFimContratoFormatado() {
		return fimContrato;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the areaTotal
	 */
	public String getAreaTotal() {
		return areaTotal;
	}

	/**
	 * @param areaTotal
	 *            the areaTotal to set
	 */
	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
	}

	/**
	 * @return the areaProdutiva
	 */
	public String getAreaProdutiva() {
		return areaProdutiva;
	}

	/**
	 * @param areaProdutiva
	 *            the areaProdutiva to set
	 */
	public void setAreaProdutiva(String areaProdutiva) {
		this.areaProdutiva = areaProdutiva;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the custoArrendamento
	 */
	public String getCustoArrendamento() {
		return custoArrendamento;
	}

	/**
	 * @param custoArrendamento
	 *            the custoArrendamento to set
	 */
	public void setCustoArrendamento(String custoArrendamento) {
		this.custoArrendamento = custoArrendamento;
	}

	/**
	 * @return the inicioContrato
	 */
	public String getInicioContrato() {
		return inicioContrato;
	}

	/**
	 * @param inicioContrato
	 *            the inicioContrato to set
	 */
	public void setInicioContrato(String inicioContrato) {
		this.inicioContrato = inicioContrato;
	}

	/**
	 * @return the fimContrato
	 */
	public String getFimContrato() {
		return fimContrato;
	}

	/**
	 * @param fimContrato
	 *            the fimContrato to set
	 */
	public void setFimContrato(String fimContrato) {
		this.fimContrato = fimContrato;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaArrendadaAgronegocioVO other = (AreaArrendadaAgronegocioVO) obj;
		if (areaProdutiva == null) {
			if (other.areaProdutiva != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(areaProdutiva).equals(other.areaProdutiva))
			return false;
		if (areaTotal == null) {
			if (other.areaTotal != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(areaTotal).equals(other.areaTotal))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (custoArrendamento == null) {
			if (other.custoArrendamento != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(custoArrendamento).equals(other.custoArrendamento))
			return false;
		if (inicioContrato == null) {
			if (other.inicioContrato != null)
				return false;
		} else if (!inicioContrato.equals(other.inicioContrato.replace(".", "/")))
			return false;
		if(fimContrato == null){
			if (other.fimContrato != null)
				return false;
		}else if (!fimContrato.equals(other.fimContrato.replace(".", "/")))
			return false;
		return true;
	}

}
