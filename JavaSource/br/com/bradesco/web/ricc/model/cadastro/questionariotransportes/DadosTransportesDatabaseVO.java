package br.com.bradesco.web.ricc.model.cadastro.questionariotransportes;

import java.util.Date;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class DadosTransportesDatabaseVO {

	private Date database;
	private String qtdVeiculos = "";
	private String valorFrota = "";
	private String saldoDevedorFinameLeasing = "";
	private String prcGrauAlienacaoFrota = "";
	private String idadeMediaAnos = "";
	private String desembolsoMensalFinameLeasing = "";
	private String desembolsoMensalCagiro = "";
	private String faturamentoMedioMensal = "";
	private String prcGrauComprometimentoReceitasComFinameLeasing = "";
	private String prcGrauComprometimentoReceitasComFinameLeasingCagiro = "";
	private String prcFrotaPropria = "";
	private String prcMargemEbitdaUltimoExercicio = "";

	public String getPrcGrauAlienacaoFrotaFormatado(){
		if(SiteUtil.getInstance().isNotEmptyOrNull(prcGrauAlienacaoFrota)){
			return SiteUtil.getInstance().formatValoresToString(prcGrauAlienacaoFrota);
		}
		return null;
	}
	
	public String getPrcGrauComprometimentoReceitasComFinameLeasingFormatado(){
		if(!SiteUtil.getInstance().valorVazio(prcGrauComprometimentoReceitasComFinameLeasing)){
			return SiteUtil.getInstance().formatValoresToString(prcGrauComprometimentoReceitasComFinameLeasing);
		}
		return null;
	}
	
	public String getPrcGrauComprometimentoReceitasComFinameLeasingCagiroFormatado(){
		if(!SiteUtil.getInstance().valorVazio(prcGrauComprometimentoReceitasComFinameLeasingCagiro)){
			return SiteUtil.getInstance().formatValoresToString(prcGrauComprometimentoReceitasComFinameLeasingCagiro);
		}
		return null;
	}
	
	public String getPrcFrotaPropriaFormatado(){
		if(!SiteUtil.getInstance().valorVazio(prcFrotaPropria)){
			return SiteUtil.getInstance().formatValoresToString(prcFrotaPropria);
		}
		return null;
	}
	
	public Date getDatabase() {
		return database;
	}

	public void setDatabase(Date database) {
		this.database = database;
	}

	public String getQtdVeiculos() {
		return qtdVeiculos;
	}

	public void setQtdVeiculos(String qtdVeiculos) {
		this.qtdVeiculos = qtdVeiculos;
	}

	public String getValorFrota() {
		return valorFrota;
	}

	public void setValorFrota(String valorFrota) {
		this.valorFrota = valorFrota;
	}

	public String getSaldoDevedorFinameLeasing() {
		return saldoDevedorFinameLeasing;
	}

	public void setSaldoDevedorFinameLeasing(String saldoDevedorFinameLeasing) {
		this.saldoDevedorFinameLeasing = saldoDevedorFinameLeasing;
	}

	public String getPrcGrauAlienacaoFrota() {
		return prcGrauAlienacaoFrota;
	}

	public void setPrcGrauAlienacaoFrota(String prcGrauAlienacaoFrota) {
		this.prcGrauAlienacaoFrota = prcGrauAlienacaoFrota;
	}

	public String getIdadeMediaAnos() {
		return idadeMediaAnos;
	}

	public void setIdadeMediaAnos(String idadeMediaAnos) {
		this.idadeMediaAnos = idadeMediaAnos;
	}

	public String getDesembolsoMensalFinameLeasing() {
		return desembolsoMensalFinameLeasing;
	}

	public void setDesembolsoMensalFinameLeasing(
			String desembolsoMensalFinameLeasing) {
		this.desembolsoMensalFinameLeasing = desembolsoMensalFinameLeasing;
	}

	public String getDesembolsoMensalCagiro() {
		return desembolsoMensalCagiro;
	}

	public void setDesembolsoMensalCagiro(String desembolsoMensalCagiro) {
		this.desembolsoMensalCagiro = desembolsoMensalCagiro;
	}

	public String getFaturamentoMedioMensal() {
		return faturamentoMedioMensal;
	}

	public void setFaturamentoMedioMensal(String faturamentoMedioMensal) {
		this.faturamentoMedioMensal = faturamentoMedioMensal;
	}

	public String getPrcGrauComprometimentoReceitasComFinameLeasing() {
		return prcGrauComprometimentoReceitasComFinameLeasing;
	}

	public void setPrcGrauComprometimentoReceitasComFinameLeasing(
			String prcGrauComprometimentoReceitasComFinameLeasing) {
		this.prcGrauComprometimentoReceitasComFinameLeasing = prcGrauComprometimentoReceitasComFinameLeasing;
	}

	public String getPrcGrauComprometimentoReceitasComFinameLeasingCagiro() {
		return prcGrauComprometimentoReceitasComFinameLeasingCagiro;
	}

	public void setPrcGrauComprometimentoReceitasComFinameLeasingCagiro(
			String prcGrauComprometimentoReceitasComFinameLeasingCagiro) {
		this.prcGrauComprometimentoReceitasComFinameLeasingCagiro = prcGrauComprometimentoReceitasComFinameLeasingCagiro;
	}

	public String getPrcFrotaPropria() {
		return prcFrotaPropria;
	}

	public void setPrcFrotaPropria(String prcFrotaPropria) {
		this.prcFrotaPropria = prcFrotaPropria;
	}

	public String getPrcMargemEbitdaUltimoExercicio() {
		return prcMargemEbitdaUltimoExercicio;
	}

	public void setPrcMargemEbitdaUltimoExercicio(
			String prcMargemEbitdaUltimoExercicio) {
		this.prcMargemEbitdaUltimoExercicio = prcMargemEbitdaUltimoExercicio;
	}

}
