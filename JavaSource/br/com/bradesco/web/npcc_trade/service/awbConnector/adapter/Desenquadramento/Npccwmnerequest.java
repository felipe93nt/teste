package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Npccwmnerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMNE-HEADER.NPCCWMNE-COD-LAYOUT")
	private String codlayout = "NPCCWMNE";

	@Adapter(transactionField = "NPCCWMNE-HEADER.NPCCWMNE-TAM-LAYOUT")
	private Integer tamlayout = 419;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-CIDTFD-MESA-CMBIO")
	private Integer cidtfdmesacmbio = 0;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-PSPREAD-TX-CMBIO")
	private Double pspreadtxcmbio = 0D;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-PTX-PARIDADE")
	private Double ptxparidade = 0D;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-CINDCD-NEGOC-CARTA")
	private String cindcdnegoccarta = null;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-CINDCD-CARTA-IDPDT")
	private String cindcdcartaidpdt = null;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-DPREVT-EMBRQ")
	private String dprevtembrq = null;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-TDIA-VALDD-CARTA")
	private Integer tdiavalddcarta = 0;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-VLIM-COBER-VAR")
	private Double vlimcobervar = 0D;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-QTDE-DESEMB")
	private Integer qtdedesemb = 0;

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-LISTA-SPREAD", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnerequest_listaspread")
	private List<Npccwmnerequest_listaspread> listaspread = null;
	
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

	public Integer getCidtfdmesacmbio() {
		return cidtfdmesacmbio;
	}
	public void setCidtfdmesacmbio(Integer cidtfdmesacmbio) {
		this.cidtfdmesacmbio = cidtfdmesacmbio;
	}

	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}
	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}

	public Long getNppstapontucmbio() {
		return nppstapontucmbio;
	}
	public void setNppstapontucmbio(Long nppstapontucmbio) {
		this.nppstapontucmbio = nppstapontucmbio;
	}

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
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

	public Double getPspreadtxcmbio() {
		return pspreadtxcmbio;
	}
	public void setPspreadtxcmbio(Double pspreadtxcmbio) {
		this.pspreadtxcmbio = pspreadtxcmbio;
	}

	public Double getPtxparidade() {
		return ptxparidade;
	}
	public void setPtxparidade(Double ptxparidade) {
		this.ptxparidade = ptxparidade;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getCindcdnegoccarta() {
		return cindcdnegoccarta;
	}
	public void setCindcdnegoccarta(String cindcdnegoccarta) {
		this.cindcdnegoccarta = cindcdnegoccarta;
	}

	public String getCindcdcartaidpdt() {
		return cindcdcartaidpdt;
	}
	public void setCindcdcartaidpdt(String cindcdcartaidpdt) {
		this.cindcdcartaidpdt = cindcdcartaidpdt;
	}

	public String getDprevtembrq() {
		return dprevtembrq;
	}
	public void setDprevtembrq(String dprevtembrq) {
		this.dprevtembrq = dprevtembrq;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public Integer getTdiavalddcarta() {
		return tdiavalddcarta;
	}
	public void setTdiavalddcarta(Integer tdiavalddcarta) {
		this.tdiavalddcarta = tdiavalddcarta;
	}

	public Double getVlimcobervar() {
		return vlimcobervar;
	}
	public void setVlimcobervar(Double vlimcobervar) {
		this.vlimcobervar = vlimcobervar;
	}

	public Integer getQtdedesemb() {
		return qtdedesemb;
	}
	public void setQtdedesemb(Integer qtdedesemb) {
		this.qtdedesemb = qtdedesemb;
	}

	public List<Npccwmnerequest_listaspread> getListaspread() {
		return listaspread;
	}
	public void setListaspread( List<Npccwmnerequest_listaspread> listaspread) {
		this.listaspread = listaspread;
	}
    
}