package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/05/16 20:29
 */
public class Npccwzcerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZCE-HEADER.NPCCWZCE-COD-LAYOUT")
	private String codlayout = "NPCCWZCE";

	@Adapter(transactionField = "NPCCWZCE-HEADER.NPCCWZCE-TAM-LAYOUT")
	private Integer tamlayout = 60;

	@Adapter(transactionField = "NPCCWZCE-REGISTRO.NPCCWZCE-JUROS-EMB-DED")
	private Integer jurosembded = 0;

	@Adapter(transactionField = "NPCCWZCE-REGISTRO.NPCCWZCE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWZCE-REGISTRO.NPCCWZCE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWZCE-REGISTRO.NPCCWZCE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWZCE-REGISTRO.NPCCWZCE-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWZCE-REGISTRO.NPCCWZCE-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;
	
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

	public Integer getJurosembded() {
		return jurosembded;
	}
	public void setJurosembded(Integer jurosembded) {
		this.jurosembded = jurosembded;
	}

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public String getVtxliborcmbio() {
		return vtxliborcmbio;
	}
	public void setVtxliborcmbio(String vtxliborcmbio) {
		this.vtxliborcmbio = vtxliborcmbio;
	}

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}
    
}