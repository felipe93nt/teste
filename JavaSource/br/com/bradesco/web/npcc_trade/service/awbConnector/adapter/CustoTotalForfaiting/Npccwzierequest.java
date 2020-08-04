package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:58
 */
public class Npccwzierequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZIE-HEADER.NPCCWZIE-COD-LAYOUT")
	private String codlayout = "NPCCWZIE";

	@Adapter(transactionField = "NPCCWZIE-HEADER.NPCCWZIE-TAM-LAYOUT")
	private Integer tamlayout = 430;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-PRZ-LIBOR-CMBIO")
	private Integer przliborcmbio = 0;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-PTX-FIXA-CMBIO")
	private String ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-VLR-COMIS-DSEMB")
	private String vlrcomisdsemb = null;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-QTD-COMIS-ADIC")
	private Integer qtdcomisadic = 0;

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-LST-CADIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting.Npccwzierequest_lstcadis")
	private List<Npccwzierequest_lstcadis> lstcadis = null;
	
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

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public Integer getPrzliborcmbio() {
		return przliborcmbio;
	}
	public void setPrzliborcmbio(Integer przliborcmbio) {
		this.przliborcmbio = przliborcmbio;
	}

	public String getVtxliborcmbio() {
		return vtxliborcmbio;
	}
	public void setVtxliborcmbio(String vtxliborcmbio) {
		this.vtxliborcmbio = vtxliborcmbio;
	}

	public String getPtxfixacmbio() {
		return ptxfixacmbio;
	}
	public void setPtxfixacmbio(String ptxfixacmbio) {
		this.ptxfixacmbio = ptxfixacmbio;
	}

	public String getVlrcomisdsemb() {
		return vlrcomisdsemb;
	}
	public void setVlrcomisdsemb(String vlrcomisdsemb) {
		this.vlrcomisdsemb = vlrcomisdsemb;
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

	public Integer getQtdcomisadic() {
		return qtdcomisadic;
	}
	public void setQtdcomisadic(Integer qtdcomisadic) {
		this.qtdcomisadic = qtdcomisadic;
	}

	public List<Npccwzierequest_lstcadis> getLstcadis() {
		return lstcadis;
	}
	public void setLstcadis( List<Npccwzierequest_lstcadis> lstcadis) {
		this.lstcadis = lstcadis;
	}
    
}