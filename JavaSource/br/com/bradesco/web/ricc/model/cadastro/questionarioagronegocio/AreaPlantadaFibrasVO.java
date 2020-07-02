package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class AreaPlantadaFibrasVO implements Comparable<AreaPlantadaFibrasVO> {

	private int codTipoRamo = 0;
	private String ano = "";

	private String areaPropria = "";
	private String areaArrendada = "";
	private String areaTotal = "";

	private String plumaHectare = "";
	private String carocoHectare = "";
	private String fibrilhaHectare = "";
	private String totalHectare = "";

	private String plumaProducao = "";
	private String carocoProducao = "";
	private String fibrilhaProducao = "";
	private String totalProducao = "";

	// RP - Realizado/Projetado
	private String mediaPlumaRP = "";
	private String mediaCarocoRP = "";
	private String mediaFibrilhaRP = "";
	private String porcentagemVolumePluma = "";
	private String precoFixadoMomento = "";
	private String custoProducaoRP = "";

	//totais formatados
	public String getAreaTotalFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(areaTotal);
	}
	
	public String getTotalHectareFormatado() {
		return SiteUtil.getInstance().formatValoresToString(totalHectare);
	}
	
	public String getPlumaProducaoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(plumaProducao);
	}
	
	public String getCarocoProducaoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(carocoProducao);
	}
	
	public String getFibrilhaProducaoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(fibrilhaProducao);
	}
	
	public String getTotalProducaoFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(totalProducao);
	}
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAreaPropria() {
		return areaPropria;
	}

	public void setAreaPropria(String areaPropria) {
		this.areaPropria = areaPropria;
	}

	public String getAreaArrendada() {
		return areaArrendada;
	}

	public void setAreaArrendada(String areaArrendada) {
		this.areaArrendada = areaArrendada;
	}

	public String getAreaTotal() {
		return areaTotal;
	}
	
	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
	}

	public String getPlumaHectare() {
		return plumaHectare;
	}

	public void setPlumaHectare(String plumaHectare) {
		this.plumaHectare = plumaHectare;
	}

	public String getCarocoHectare() {
		return carocoHectare;
	}

	public void setCarocoHectare(String carocoHectare) {
		this.carocoHectare = carocoHectare;
	}

	public String getFibrilhaHectare() {
		return fibrilhaHectare;
	}

	public void setFibrilhaHectare(String fibrilhaHectare) {
		this.fibrilhaHectare = fibrilhaHectare;
	}

	public String getTotalHectare() {
		return totalHectare;
	}

	public void setTotalHectare(String totalHectare) {
		this.totalHectare = totalHectare;
	}

	public String getPlumaProducao() {
		return plumaProducao;
	}

	public void setPlumaProducao(String plumaProducao) {
		this.plumaProducao = plumaProducao;
	}

	public String getCarocoProducao() {
		return carocoProducao;
	}
	
	public void setCarocoProducao(String carocoProducao) {
		this.carocoProducao = carocoProducao;
	}

	public String getFibrilhaProducao() {
		return fibrilhaProducao;
	}

	public void setFibrilhaProducao(String fibrilhaProducao) {
		this.fibrilhaProducao = fibrilhaProducao;
	}
	
	public String getTotalProducao() {
		return totalProducao;
	}

	public void setTotalProducao(String totalProducao) {
		this.totalProducao = totalProducao;
	}

	public String getMediaPlumaRP() {
		return mediaPlumaRP;
	}

	public void setMediaPlumaRP(String mediaPlumaRP) {
		this.mediaPlumaRP = mediaPlumaRP;
	}

	public String getMediaCarocoRP() {
		return mediaCarocoRP;
	}

	public void setMediaCarocoRP(String mediaCarocoRP) {
		this.mediaCarocoRP = mediaCarocoRP;
	}

	public String getMediaFibrilhaRP() {
		return mediaFibrilhaRP;
	}

	public void setMediaFibrilhaRP(String mediaFibrilhaRP) {
		this.mediaFibrilhaRP = mediaFibrilhaRP;
	}

	public String getPorcentagemVolumePluma() {
		return porcentagemVolumePluma;
	}

	public void setPorcentagemVolumePluma(String porcentagemVolumePluma) {
		this.porcentagemVolumePluma = porcentagemVolumePluma;
	}

	public String getPrecoFixadoMomento() {
		return precoFixadoMomento;
	}

	public void setPrecoFixadoMomento(String precoFixadoMomento) {
		this.precoFixadoMomento = precoFixadoMomento;
	}

	public String getCustoProducaoRP() {
		return custoProducaoRP;
	}

	public void setCustoProducaoRP(String custoProducaoRP) {
		this.custoProducaoRP = custoProducaoRP;
	}

	public int getCodTipoRamo() {
		return codTipoRamo;
	}

	public void setCodTipoRamo(int codTipoRamo) {
		this.codTipoRamo = codTipoRamo;
	}

	@Override
	public int compareTo(AreaPlantadaFibrasVO o) {
		return this.hashCode() == o.hashCode() ? 0 : this.hashCode()
				- o.hashCode();
	}

}
