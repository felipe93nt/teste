package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 28/03/17 09:38
 */
public class Npccwxxerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXXE-HEADER.NPCCWXXE-COD-LAYOUT")
	private String codlayout = "NPCCWXXE";

	@Adapter(transactionField = "NPCCWXXE-HEADER.NPCCWXXE-TAM-LAYOUT")
	private Integer tamlayout = 819;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-CCOBR-COMIS-INTRN")
	private Integer ccobrcomisintrn = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-VLX-COMIS-CMBIO")
	private String vlxcomiscmbio = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-VLX-OPERAC-CMBIO")
	private String vlxoperaccmbio = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-PRZ-OPERAC-CMBIO")
	private Integer przoperaccmbio = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-CCOMIS-CARTA-NACIO")
	private String ccomiscartanacio = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-PTX-CUSTO-EXTER")
	private String ptxcustoexter = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-PTX-IMPST-RENDA")
	private String ptximpstrenda = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-PRZ-OPERAC-LIBOR")
	private Integer przoperaclibor = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-VLIM-COBER-VAR")
	private String vlimcobervar = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-PTX-FIXA-CMBIO")
	private String ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-QTDE-PRZO-MEDIO")
	private Integer qtdeprzomedio = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-QTD-COMIS-ADIC")
	private Integer qtdcomisadic = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-QTD-OCORR")
	private Integer qtdocorr = 0;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Npccwxxerequest_lista")
	private List<Npccwxxerequest_lista> lista = null;

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-LST-CADIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Npccwxxerequest_lstcadis")
	private List<Npccwxxerequest_lstcadis> lstcadis = null;
	
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

	public Integer getCcobrcomisintrn() {
		return ccobrcomisintrn;
	}
	public void setCcobrcomisintrn(Integer ccobrcomisintrn) {
		this.ccobrcomisintrn = ccobrcomisintrn;
	}

	public String getVlxcomiscmbio() {
		return vlxcomiscmbio;
	}
	public void setVlxcomiscmbio(String vlxcomiscmbio) {
		this.vlxcomiscmbio = vlxcomiscmbio;
	}

	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getVlxoperaccmbio() {
		return vlxoperaccmbio;
	}
	public void setVlxoperaccmbio(String vlxoperaccmbio) {
		this.vlxoperaccmbio = vlxoperaccmbio;
	}

	public Integer getPrzoperaccmbio() {
		return przoperaccmbio;
	}
	public void setPrzoperaccmbio(Integer przoperaccmbio) {
		this.przoperaccmbio = przoperaccmbio;
	}

	public String getCcomiscartanacio() {
		return ccomiscartanacio;
	}
	public void setCcomiscartanacio(String ccomiscartanacio) {
		this.ccomiscartanacio = ccomiscartanacio;
	}

	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}
	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
	}

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public String getPtxcustoexter() {
		return ptxcustoexter;
	}
	public void setPtxcustoexter(String ptxcustoexter) {
		this.ptxcustoexter = ptxcustoexter;
	}

	public String getPtximpstrenda() {
		return ptximpstrenda;
	}
	public void setPtximpstrenda(String ptximpstrenda) {
		this.ptximpstrenda = ptximpstrenda;
	}

	public Integer getPrzoperaclibor() {
		return przoperaclibor;
	}
	public void setPrzoperaclibor(Integer przoperaclibor) {
		this.przoperaclibor = przoperaclibor;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getVlimcobervar() {
		return vlimcobervar;
	}
	public void setVlimcobervar(String vlimcobervar) {
		this.vlimcobervar = vlimcobervar;
	}

	public String getPtxfixacmbio() {
		return ptxfixacmbio;
	}
	public void setPtxfixacmbio(String ptxfixacmbio) {
		this.ptxfixacmbio = ptxfixacmbio;
	}

	public Integer getQtdeprzomedio() {
		return qtdeprzomedio;
	}
	public void setQtdeprzomedio(Integer qtdeprzomedio) {
		this.qtdeprzomedio = qtdeprzomedio;
	}

	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	public Integer getQtdcomisadic() {
		return qtdcomisadic;
	}
	public void setQtdcomisadic(Integer qtdcomisadic) {
		this.qtdcomisadic = qtdcomisadic;
	}

	public Integer getQtdocorr() {
		return qtdocorr;
	}
	public void setQtdocorr(Integer qtdocorr) {
		this.qtdocorr = qtdocorr;
	}

	public List<Npccwxxerequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxxerequest_lista> lista) {
		this.lista = lista;
	}

	public List<Npccwxxerequest_lstcadis> getLstcadis() {
		return lstcadis;
	}
	public void setLstcadis( List<Npccwxxerequest_lstcadis> lstcadis) {
		this.lstcadis = lstcadis;
	}
    
}