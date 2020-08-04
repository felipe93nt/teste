package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean;

import java.util.ArrayList;
import java.util.List;


public class EstatisticaCotacoesVO {

	private String nomedocampo;
	private String totqtdstfec;
	private String totvalstfec;
	private String totqtdstper;
	private String totvalstper;
	private String totqtdstnfi;
	private String totvalstnfi;
	private String totqtdstnin;
	private String totvalstnin;
	private String totqtdstbai;
	private String totvalstbai;
	private String totqtdtotal;
	private String totvaltotal;
	private String totqtdperfv;
	private String totvalperfv;
	
	private List<CotacoesVO> cotacoes = new ArrayList<CotacoesVO>();

	public String getTotqtdstfec() {
		return totqtdstfec;
	}
	public void setTotqtdstfec(String totqtdstfec) {
		this.totqtdstfec = totqtdstfec;
	}
	public String getTotvalstfec() {
		return totvalstfec;
	}
	public void setTotvalstfec(String totvalstfec) {
		this.totvalstfec = totvalstfec;
	}
	public String getTotqtdstper() {
		return totqtdstper;
	}
	public void setTotqtdstper(String totqtdstper) {
		this.totqtdstper = totqtdstper;
	}
	public String getTotvalstper() {
		return totvalstper;
	}
	public void setTotvalstper(String totvalstper) {
		this.totvalstper = totvalstper;
	}
	public String getTotqtdstnfi() {
		return totqtdstnfi;
	}
	public void setTotqtdstnfi(String totqtdstnfi) {
		this.totqtdstnfi = totqtdstnfi;
	}
	public String getTotvalstnfi() {
		return totvalstnfi;
	}
	public void setTotvalstnfi(String totvalstnfi) {
		this.totvalstnfi = totvalstnfi;
	}
	public String getTotqtdstnin() {
		return totqtdstnin;
	}
	public void setTotqtdstnin(String totqtdstnin) {
		this.totqtdstnin = totqtdstnin;
	}
	public String getTotvalstnin() {
		return totvalstnin;
	}
	public void setTotvalstnin(String totvalstnin) {
		this.totvalstnin = totvalstnin;
	}
	public String getTotqtdstbai() {
		return totqtdstbai;
	}
	public void setTotqtdstbai(String totqtdstbai) {
		this.totqtdstbai = totqtdstbai;
	}
	public String getTotvalstbai() {
		return totvalstbai;
	}
	public void setTotvalstbai(String totvalstbai) {
		this.totvalstbai = totvalstbai;
	}
	public String getTotqtdtotal() {
		return totqtdtotal;
	}
	public void setTotqtdtotal(String totqtdtotal) {
		this.totqtdtotal = totqtdtotal;
	}
	public String getTotvaltotal() {
		return totvaltotal;
	}
	public void setTotvaltotal(String totvaltotal) {
		this.totvaltotal = totvaltotal;
	}
	public String getTotqtdperfv() {
		return totqtdperfv;
	}
	public void setTotqtdperfv(String totqtdperfv) {
		this.totqtdperfv = totqtdperfv;
	}
	public String getTotvalperfv() {
		return totvalperfv;
	}
	public void setTotvalperfv(String totvalperfv) {
		this.totvalperfv = totvalperfv;
	}
	public List<CotacoesVO> getCotacoes() {
		return cotacoes;
	}
	public void setCotacoes(List<CotacoesVO> cotacoes) {
		this.cotacoes = cotacoes;
	}
	public String getNomedocampo() {
		return nomedocampo;
	}
	public void setNomedocampo(String nomedocampo) {
		this.nomedocampo = nomedocampo;
	}

}
