package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean;

import java.util.List;


public class EstatisticasCotacoesFechadaPerdidaVO {

	private String cotfechada;
	private String cotperdida;
	private String cottotal;
	private String fechadovlt;
	private String perdidovlt;
	private String mes;
	
	public String getCotfechada() {
		return cotfechada;
	}
	public void setCotfechada(String cotfechada) {
		this.cotfechada = cotfechada;
	}
	public String getCotperdida() {
		return cotperdida;
	}
	public void setCotperdida(String cotperdida) {
		this.cotperdida = cotperdida;
	}
	public String getCottotal() {
		return cottotal;
	}
	public void setCottotal(String cottotal) {
		this.cottotal = cottotal;
	}
	public String getFechadovlt() {
		return fechadovlt;
	}
	public void setFechadovlt(String fechadovlt) {
		this.fechadovlt = fechadovlt;
	}
	public String getPerdidovlt() {
		return perdidovlt;
	}
	public void setPerdidovlt(String perdidovlt) {
		this.perdidovlt = perdidovlt;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
}
