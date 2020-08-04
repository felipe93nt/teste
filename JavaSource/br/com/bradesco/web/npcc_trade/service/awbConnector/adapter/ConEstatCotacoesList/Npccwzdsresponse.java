package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 25/10/16 17:51
 */
public class Npccwzdsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZDS-HEADER.NPCCWZDS-COD-LAYOUT")
	private String codlayout = "NPCCWZDS";

	@Adapter(transactionField = "NPCCWZDS-HEADER.NPCCWZDS-TAM-LAYOUT")
	private Integer tamlayout = 14654;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-QTD-STFEC")
	private String totqtdstfec = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-VAL-STFEC")
	private String totvalstfec = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-QTD-STPER")
	private String totqtdstper = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-VAL-STPER")
	private String totvalstper = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-QTD-STNFI")
	private String totqtdstnfi = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-VAL-STNFI")
	private String totvalstnfi = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-QTD-STNIN")
	private String totqtdstnin = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-VAL-STNIN")
	private String totvalstnin = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-QTD-STBAI")
	private String totqtdstbai = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-VAL-STBAI")
	private String totvalstbai = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-QTD-TOTAL")
	private String totqtdtotal = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-VAL-TOTAL")
	private String totvaltotal = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-QTD-PERFV")
	private String totqtdperfv = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-TOT-VAL-PERFV")
	private String totvalperfv = null;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZDS-REGISTRO.NPCCWZDS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList.Npccwzdsresponse_lista")
	private List<Npccwzdsresponse_lista> lista = null;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

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

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwzdsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwzdsresponse_lista> lista) {
		this.lista = lista;
	}
    
}