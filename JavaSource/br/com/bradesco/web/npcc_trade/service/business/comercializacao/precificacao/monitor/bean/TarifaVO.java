package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.util.ArrayList;
import java.util.List;

public class TarifaVO {
	
	/**
	 * TOTAL DE TARIFA + DESPESA EM USD
	 */
	private Integer totusdtrfadeps;
	
	/**
	 * TOTAL DE TARIFA + DESPESA EM BRL
	 */
	private Integer totbrltrfadeps;
	
	/**
	 * IDENT. DE DESPESA OU TARIFA 1 = TARIFA | 2 = DESPESA
	 */
	private Integer cindcddesptarf;
	
	/**
	 * CONDICAO ECONOMICA TARIFA
	 */
	private Integer ccondceconc;
	
	/**
	 * NUMERO TARIFA BOLETO
	 */
	private Integer ntarifbletocmbio;
	
	/**
	 * TIPO DESPESA CAMBIO
	 */
	private Integer ctpodespcmbio;
	
	/**
	 * NUMERO DESPESA BOLETO CAMBIO
	 */
	private Long ndespbletocmbio;
	
	/**
	 * DESCRICAO DA TARIFA/DESPESA
	 */
	private String itpodespcmbio;
	
	/**
	 * CODIGO DA MOEDA
	 */
	private Integer cindcdeconmmoeda;
	
	/**
	 * VALOR DA TARIFA/DESPESA 
	 */
	private String vdespbletocmbio;
	
	/**
	 * TOTAL EM BRL
	 */
	private String totbrldesptarf;
	
	/**
	 * TOTAL EM USD
	 */
	private String totusddesptarf;
	
	
	private List<TarifaVO> lista = new ArrayList<TarifaVO>();
	
	/**
	 * DESCRICAO DA MOEDA
	 */
	private String isglindcdfonte;

	public Integer getTotusdtrfadeps() {
		return totusdtrfadeps;
	}

	public void setTotusdtrfadeps(Integer totusdtrfadeps) {
		this.totusdtrfadeps = totusdtrfadeps;
	}

	public Integer getTotbrltrfadeps() {
		return totbrltrfadeps;
	}

	public void setTotbrltrfadeps(Integer totbrltrfadeps) {
		this.totbrltrfadeps = totbrltrfadeps;
	}

	public Integer getCindcddesptarf() {
		return cindcddesptarf;
	}

	public void setCindcddesptarf(Integer cindcddesptarf) {
		this.cindcddesptarf = cindcddesptarf;
	}

	public Integer getCcondceconc() {
		return ccondceconc;
	}

	public void setCcondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}

	public Integer getNtarifbletocmbio() {
		return ntarifbletocmbio;
	}

	public void setNtarifbletocmbio(Integer ntarifbletocmbio) {
		this.ntarifbletocmbio = ntarifbletocmbio;
	}

	public Integer getCtpodespcmbio() {
		return ctpodespcmbio;
	}

	public void setCtpodespcmbio(Integer ctpodespcmbio) {
		this.ctpodespcmbio = ctpodespcmbio;
	}

	public Long getNdespbletocmbio() {
		return ndespbletocmbio;
	}

	public void setNdespbletocmbio(Long ndespbletocmbio) {
		this.ndespbletocmbio = ndespbletocmbio;
	}

	public String getItpodespcmbio() {
		return itpodespcmbio;
	}

	public void setItpodespcmbio(String itpodespcmbio) {
		this.itpodespcmbio = itpodespcmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getVdespbletocmbio() {
		return vdespbletocmbio;
	}

	public void setVdespbletocmbio(String vdespbletocmbio) {
		this.vdespbletocmbio = vdespbletocmbio;
	}

	public String getTotbrldesptarf() {
		return totbrldesptarf;
	}

	public void setTotbrldesptarf(String totbrldesptarf) {
		this.totbrldesptarf = totbrldesptarf;
	}

	public String getTotusddesptarf() {
		return totusddesptarf;
	}

	public void setTotusddesptarf(String totusddesptarf) {
		this.totusddesptarf = totusddesptarf;
	}

	public List<TarifaVO> getLista() {
		return lista;
	}

	public void setLista(List<TarifaVO> lista) {
		this.lista = lista;
	}

	public String getIsglindcdfonte() {
		return isglindcdfonte;
	}

	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}
	
	
}
