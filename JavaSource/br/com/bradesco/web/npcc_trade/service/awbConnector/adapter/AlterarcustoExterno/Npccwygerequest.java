package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 11:39
 */
public class Npccwygerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYGE-HEADER.NPCCWYGE-COD-LAYOUT")
	private String codlayout = "NPCCWYGE";

	@Adapter(transactionField = "NPCCWYGE-HEADER.NPCCWYGE-TAM-LAYOUT")
	private Integer tamlayout = 742;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-ATUA-COMISS")
	private String atuacomiss = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-IORG-EXTER-CMBIO")
	private String iorgextercmbio = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-DLIM-FNDNG-CMBIO")
	private String dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-CBANQR-CMBIO-FNDNG")
	private Long cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-CBANQR-CMBIO-RCDOR")
	private Long cbanqrcmbiorcdor = 0L;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-PTX-FIXA-CMBIO")
	private String ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-TMES-LIBOR-CMBIO")
	private Integer tmesliborcmbio = 0;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-OBSERVACAO")
	private String observacao = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-VLR-COMIS-DSEMB")
	private String vlrcomisdsemb = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWYGE-REGISTRO.NPCCWYGE-CPRODT-SERVC")
	private Integer cprodtservc = 0;
	
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

	public String getAtuacomiss() {
		return atuacomiss;
	}
	public void setAtuacomiss(String atuacomiss) {
		this.atuacomiss = atuacomiss;
	}

	public String getIorgextercmbio() {
		return iorgextercmbio;
	}
	public void setIorgextercmbio(String iorgextercmbio) {
		this.iorgextercmbio = iorgextercmbio;
	}

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getDlimfndngcmbio() {
		return dlimfndngcmbio;
	}
	public void setDlimfndngcmbio(String dlimfndngcmbio) {
		this.dlimfndngcmbio = dlimfndngcmbio;
	}

	public Long getCbanqrcmbiofndng() {
		return cbanqrcmbiofndng;
	}
	public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
		this.cbanqrcmbiofndng = cbanqrcmbiofndng;
	}

	public Long getCbanqrcmbiorcdor() {
		return cbanqrcmbiorcdor;
	}
	public void setCbanqrcmbiorcdor(Long cbanqrcmbiorcdor) {
		this.cbanqrcmbiorcdor = cbanqrcmbiorcdor;
	}

	public String getPtxfixacmbio() {
		return ptxfixacmbio;
	}
	public void setPtxfixacmbio(String ptxfixacmbio) {
		this.ptxfixacmbio = ptxfixacmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getTmesliborcmbio() {
		return tmesliborcmbio;
	}
	public void setTmesliborcmbio(Integer tmesliborcmbio) {
		this.tmesliborcmbio = tmesliborcmbio;
	}

	public String getVtxliborcmbio() {
		return vtxliborcmbio;
	}
	public void setVtxliborcmbio(String vtxliborcmbio) {
		this.vtxliborcmbio = vtxliborcmbio;
	}

	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getVlrcomisdsemb() {
		return vlrcomisdsemb;
	}
	public void setVlrcomisdsemb(String vlrcomisdsemb) {
		this.vlrcomisdsemb = vlrcomisdsemb;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}
    
}