package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class AreaPropriaAgronegocioVO implements Comparable<AreaPropriaAgronegocioVO> {

	private Integer numSequencial = 0;
	private String descricao;
	private String areaTotal;
	private String areaProdutiva;
	private String cidade;
	private String valorMercado;
	private String valorMercadoHectare;
	private String isAreaCedida;
	
	private SiteUtil siteUtil = SiteUtil.getInstance();

	public AreaPropriaAgronegocioVO() {
		super();
	}

	public AreaPropriaAgronegocioVO(String descricao, String areaTotal,
			String areaProdutiva, String cidade, String valorMercado,
			String valorMercadoHectare, String isAreaCedida) {
		super();
		this.descricao = descricao;
		this.areaTotal = areaTotal;
		this.areaProdutiva = areaProdutiva;
		this.cidade = cidade;
		this.valorMercado = valorMercado;
		this.valorMercadoHectare = valorMercadoHectare;
		this.isAreaCedida = isAreaCedida;
	}

	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
	}

	public String getAreaProdutiva() {
		return areaProdutiva;
	}

	public void setAreaProdutiva(String areaProdutiva) {
		this.areaProdutiva = areaProdutiva;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(String valorMercado) {
		this.valorMercado = valorMercado;
	}

	public String getValorMercadoHectare() {
		return valorMercadoHectare;
	}

	public void setValorMercadoHectare(String valorMercadoHectare) {
		this.valorMercadoHectare = valorMercadoHectare;
	}

	public String getIsAreaCedida() {
		return isAreaCedida;
	}
	
	public String getIsAreaCedidaSN() {
		if(this.isAreaCedida.equals("1")){
			return "Sim";
		}else if(this.isAreaCedida.equals("2")){
			return "Não";
		}
		return "";
	}

	public void setIsAreaCedida(String isAreaCedida) {
		this.isAreaCedida = isAreaCedida;
	}

	@Override
	public int compareTo(AreaPropriaAgronegocioVO o) {
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
				+ ((areaProdutiva == null) ? 0 : areaProdutiva.hashCode());
		result = prime * result
				+ ((areaTotal == null) ? 0 : areaTotal.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((valorMercado == null) ? 0 : valorMercado.hashCode());
		result = prime
				* result
				+ ((valorMercadoHectare == null) ? 0 : valorMercadoHectare
						.hashCode());
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
		AreaPropriaAgronegocioVO other = (AreaPropriaAgronegocioVO) obj;
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
		if (valorMercado == null) {
			if (other.valorMercado != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valorMercado).equals(other.valorMercado))
			return false;
		if (valorMercadoHectare == null) {
			if (other.valorMercadoHectare != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valorMercadoHectare).equals(other.valorMercadoHectare))
			return false;
		if(isAreaCedida == null){
			if (other.isAreaCedida != null)
				return false;
		}else if (!isAreaCedida.equals(other.isAreaCedida))
			return false;
		return true;
	}
	
}
