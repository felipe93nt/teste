package br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class AreaPlantadaGraosVO implements Comparable<AreaPlantadaGraosVO> {

	private int codigoTipoRamo = 0;
	private String ano = "";
	private String areaPropria = "";
	private String areaArrendada = "";
	private String areaTotal = "";
	private String producaoGraos = "";
	private String producaoSementes = "";
	private String pesoSacaSementes = "";
	private String producaoTotal = "";
	private String produtividade = "";
	private String precoMedioGrao = "";
	private String precoMedioSemente = "";
	private String pesoSacaMediaSemente = "";
	private String porcentagemVolumeGraoFixado = "";
	private String precoMedioGraoFixado = "";
	private String custoProducaoRealizado = "";

	public String getAreaTotalFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(areaTotal);
	}
	
	public String getProducaoTotalFormatado() {
		return SiteUtil.getInstance().formatNumericosToString(producaoTotal);
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

	public String getProducaoGraos() {
		return producaoGraos;
	}

	public void setProducaoGraos(String producaoGraos) {
		this.producaoGraos = producaoGraos;
	}

	public String getProducaoSementes() {
		return producaoSementes;
	}

	public void setProducaoSementes(String producaoSementes) {
		this.producaoSementes = producaoSementes;
	}

	public String getPesoSacaSementes() {
		return pesoSacaSementes;
	}

	public void setPesoSacaSementes(String pesoSacaSementes) {
		this.pesoSacaSementes = pesoSacaSementes;
	}

	public String getPesoSacaMediaSemente() {
		return pesoSacaMediaSemente;
	}

	public void setPesoSacaMediaSemente(String pesoSacaMediaSemente) {
		this.pesoSacaMediaSemente = pesoSacaMediaSemente;
	}

	public String getProducaoTotal() {
		return producaoTotal;
	}
	
	public void setProducaoTotal(String producaoTotal) {
		this.producaoTotal = producaoTotal;
	}

	public String getProdutividade() {
		return produtividade;
	}

	public void setProdutividade(String produtividade) {
		this.produtividade = produtividade;
	}

	public String getPrecoMedioGrao() {
		return precoMedioGrao;
	}

	public void setPrecoMedioGrao(String precoMedioGrao) {
		this.precoMedioGrao = precoMedioGrao;
	}

	public String getPrecoMedioSemente() {
		return precoMedioSemente;
	}

	public void setPrecoMedioSemente(String precoMedioSemente) {
		this.precoMedioSemente = precoMedioSemente;
	}

	public String getPorcentagemVolumeGraoFixado() {
		return porcentagemVolumeGraoFixado;
	}

	public void setPorcentagemVolumeGraoFixado(String porcentagemVolumeGraoFixado) {
		this.porcentagemVolumeGraoFixado = porcentagemVolumeGraoFixado;
	}

	public String getPrecoMedioGraoFixado() {
		return precoMedioGraoFixado;
	}

	public void setPrecoMedioGraoFixado(String precoMedioGraoFixado) {
		this.precoMedioGraoFixado = precoMedioGraoFixado;
	}

	public String getCustoProducaoRealizado() {
		return custoProducaoRealizado;
	}

	public void setCustoProducaoRealizado(String custoProducaoRealizado) {
		this.custoProducaoRealizado = custoProducaoRealizado;
	}

	public int getCodigoTipoRamo() {
		return codigoTipoRamo;
	}

	public void setCodigoTipoRamo(int codigoTipoRamo) {
		this.codigoTipoRamo = codigoTipoRamo;
	}

	@Override
	public int compareTo(AreaPlantadaGraosVO o) {
		return this.hashCode() == o.hashCode() ? 0 : this.hashCode() - o.hashCode();
	}

}
