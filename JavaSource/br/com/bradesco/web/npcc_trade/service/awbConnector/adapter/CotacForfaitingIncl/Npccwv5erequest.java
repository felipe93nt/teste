package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 21/03/17 15:10
 */
public class Npccwv5erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV5E-HEADER.NPCCWV5E-COD-LAYOUT")
	private String codlayout = "NPCCWV5E";

	@Adapter(transactionField = "NPCCWV5E-HEADER.NPCCWV5E-TAM-LAYOUT")
	private Integer tamlayout = 1354;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CADITV-BLETO-CMBIO")
	private Integer caditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CPSSOA-JURID")
	private Long cpssoajurid = 0L;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CPSSOA-ANLSE-CREDT")
	private Long cpssoaanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DANO-SOLTC-ANLSE")
	private Integer danosoltcanlse = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-NSOLTC-ANLSE-CREDT")
	private Long nsoltcanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-NSEQ-SOLTC-ANLSE")
	private Integer nseqsoltcanlse = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CRTING")
	private String crting = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-NCTA-BCRIA-CMBIO")
	private Integer nctabcriacmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VMOEDA-LIM-GERC")
	private String vmoedalimgerc = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CECONM-MOEDA-DSEMB")
	private Integer ceconmmoedadsemb = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CINDCD-NEGOC-LIBOR")
	private String cindcdnegoclibor = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CNEGOC-SWAP-FLUXO")
	private String cnegocswapfluxo = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CNEGOC-SWAP-ESTRG")
	private String cnegocswapestrg = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CTPO-COTAC-TX")
	private Integer ctpocotactx = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CTPO-JURO-TRADE")
	private Integer ctpojurotrade = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-PTX-SWAP-CMPDO")
	private String ptxswapcmpdo = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CINDCD-NEGOC-CARTA")
	private String cindcdnegoccarta = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-TDIA-VALDD-LETRA")
	private Integer tdiavalddletra = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DVALDD-NEGOC-CMBIO")
	private String dvalddnegoccmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CCOMIS-CARTA-NACIO")
	private String ccomiscartanacio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CINDCD-NEGOC-ARBTR")
	private String cindcdnegocarbtr = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-QPRZ-MED-CMBIO")
	private Integer qprzmedcmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VIMPST-NEGOC-CMBIO")
	private String vimpstnegoccmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VIOF-NEGOC-CMBIO")
	private String viofnegoccmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VTX-MORA-CMBIO")
	private String vtxmoracmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CBASE-JURO-MORA")
	private Integer cbasejuromora = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VMULTA-NEGOC-CMBIO")
	private String vmultanegoccmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CSEGUR-TRNSP-MCADO")
	private String csegurtrnspmcado = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CSEGUR-MCADO-ORGNZ")
	private String csegurmcadoorgnz = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DPREVT-GARNT-EXPDI")
	private String dprevtgarntexpdi = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DPREVT-FIM-EMBRQ")
	private String dprevtfimembrq = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DPREVT-INIC-EMBRQ")
	private String dprevtinicembrq = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-PCOBER-VAR-PRODT")
	private String pcobervarprodt = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-CCOBR-COMIS-ADCIO")
	private String ccobrcomisadcio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DABERT-CNTRA-GARNT")
	private String dabertcntragarnt = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DVCTO-CNTRA-GARNT")
	private String dvctocntragarnt = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-RJUSTF-DQMTO")
	private String rjustfdqmto = null;

	@Adapter(transactionField = "NPCCWV5E-REGISTRO.NPCCWV5E-VTX-SPREAD-TOT")
	private String vtxspreadtot = null;
	
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

	public Integer getCaditvbletocmbio() {
		return caditvbletocmbio;
	}
	public void setCaditvbletocmbio(Integer caditvbletocmbio) {
		this.caditvbletocmbio = caditvbletocmbio;
	}

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public Long getCpssoajurid() {
		return cpssoajurid;
	}
	public void setCpssoajurid(Long cpssoajurid) {
		this.cpssoajurid = cpssoajurid;
	}

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}
	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}

	public Long getCpssoaanlsecredt() {
		return cpssoaanlsecredt;
	}
	public void setCpssoaanlsecredt(Long cpssoaanlsecredt) {
		this.cpssoaanlsecredt = cpssoaanlsecredt;
	}

	public Integer getDanosoltcanlse() {
		return danosoltcanlse;
	}
	public void setDanosoltcanlse(Integer danosoltcanlse) {
		this.danosoltcanlse = danosoltcanlse;
	}

	public Long getNsoltcanlsecredt() {
		return nsoltcanlsecredt;
	}
	public void setNsoltcanlsecredt(Long nsoltcanlsecredt) {
		this.nsoltcanlsecredt = nsoltcanlsecredt;
	}

	public Integer getNseqsoltcanlse() {
		return nseqsoltcanlse;
	}
	public void setNseqsoltcanlse(Integer nseqsoltcanlse) {
		this.nseqsoltcanlse = nseqsoltcanlse;
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

	public Integer getCeconmmoedalim() {
		return ceconmmoedalim;
	}
	public void setCeconmmoedalim(Integer ceconmmoedalim) {
		this.ceconmmoedalim = ceconmmoedalim;
	}

	public String getCrting() {
		return crting;
	}
	public void setCrting(String crting) {
		this.crting = crting;
	}

	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}
	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
	}

	public Long getNppstapontucmbio() {
		return nppstapontucmbio;
	}
	public void setNppstapontucmbio(Long nppstapontucmbio) {
		this.nppstapontucmbio = nppstapontucmbio;
	}

	public Integer getNctabcriacmbio() {
		return nctabcriacmbio;
	}
	public void setNctabcriacmbio(Integer nctabcriacmbio) {
		this.nctabcriacmbio = nctabcriacmbio;
	}

	public Integer getCtponegoccmbio() {
		return ctponegoccmbio;
	}
	public void setCtponegoccmbio(Integer ctponegoccmbio) {
		this.ctponegoccmbio = ctponegoccmbio;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public String getVmoedalimgerc() {
		return vmoedalimgerc;
	}
	public void setVmoedalimgerc(String vmoedalimgerc) {
		this.vmoedalimgerc = vmoedalimgerc;
	}

	public Integer getCeconmmoedadsemb() {
		return ceconmmoedadsemb;
	}
	public void setCeconmmoedadsemb(Integer ceconmmoedadsemb) {
		this.ceconmmoedadsemb = ceconmmoedadsemb;
	}

	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}
	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
	}

	public String getCindcdnegoclibor() {
		return cindcdnegoclibor;
	}
	public void setCindcdnegoclibor(String cindcdnegoclibor) {
		this.cindcdnegoclibor = cindcdnegoclibor;
	}

	public String getCnegocswapfluxo() {
		return cnegocswapfluxo;
	}
	public void setCnegocswapfluxo(String cnegocswapfluxo) {
		this.cnegocswapfluxo = cnegocswapfluxo;
	}

	public String getCnegocswapestrg() {
		return cnegocswapestrg;
	}
	public void setCnegocswapestrg(String cnegocswapestrg) {
		this.cnegocswapestrg = cnegocswapestrg;
	}

	public Integer getCtpocotactx() {
		return ctpocotactx;
	}
	public void setCtpocotactx(Integer ctpocotactx) {
		this.ctpocotactx = ctpocotactx;
	}

	public Integer getCtpojurotrade() {
		return ctpojurotrade;
	}
	public void setCtpojurotrade(Integer ctpojurotrade) {
		this.ctpojurotrade = ctpojurotrade;
	}

	public String getPtxswapcmpdo() {
		return ptxswapcmpdo;
	}
	public void setPtxswapcmpdo(String ptxswapcmpdo) {
		this.ptxswapcmpdo = ptxswapcmpdo;
	}

	public String getCindcdnegoccarta() {
		return cindcdnegoccarta;
	}
	public void setCindcdnegoccarta(String cindcdnegoccarta) {
		this.cindcdnegoccarta = cindcdnegoccarta;
	}

	public Integer getTdiavalddletra() {
		return tdiavalddletra;
	}
	public void setTdiavalddletra(Integer tdiavalddletra) {
		this.tdiavalddletra = tdiavalddletra;
	}

	public String getDvalddnegoccmbio() {
		return dvalddnegoccmbio;
	}
	public void setDvalddnegoccmbio(String dvalddnegoccmbio) {
		this.dvalddnegoccmbio = dvalddnegoccmbio;
	}

	public String getCcomiscartanacio() {
		return ccomiscartanacio;
	}
	public void setCcomiscartanacio(String ccomiscartanacio) {
		this.ccomiscartanacio = ccomiscartanacio;
	}

	public String getCindcdnegocarbtr() {
		return cindcdnegocarbtr;
	}
	public void setCindcdnegocarbtr(String cindcdnegocarbtr) {
		this.cindcdnegocarbtr = cindcdnegocarbtr;
	}

	public Integer getQprzmedcmbio() {
		return qprzmedcmbio;
	}
	public void setQprzmedcmbio(Integer qprzmedcmbio) {
		this.qprzmedcmbio = qprzmedcmbio;
	}

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public String getVimpstnegoccmbio() {
		return vimpstnegoccmbio;
	}
	public void setVimpstnegoccmbio(String vimpstnegoccmbio) {
		this.vimpstnegoccmbio = vimpstnegoccmbio;
	}

	public String getViofnegoccmbio() {
		return viofnegoccmbio;
	}
	public void setViofnegoccmbio(String viofnegoccmbio) {
		this.viofnegoccmbio = viofnegoccmbio;
	}

	public String getVtxmoracmbio() {
		return vtxmoracmbio;
	}
	public void setVtxmoracmbio(String vtxmoracmbio) {
		this.vtxmoracmbio = vtxmoracmbio;
	}

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public Integer getCbasejuromora() {
		return cbasejuromora;
	}
	public void setCbasejuromora(Integer cbasejuromora) {
		this.cbasejuromora = cbasejuromora;
	}

	public String getVmultanegoccmbio() {
		return vmultanegoccmbio;
	}
	public void setVmultanegoccmbio(String vmultanegoccmbio) {
		this.vmultanegoccmbio = vmultanegoccmbio;
	}

	public String getCsegurtrnspmcado() {
		return csegurtrnspmcado;
	}
	public void setCsegurtrnspmcado(String csegurtrnspmcado) {
		this.csegurtrnspmcado = csegurtrnspmcado;
	}

	public String getCsegurmcadoorgnz() {
		return csegurmcadoorgnz;
	}
	public void setCsegurmcadoorgnz(String csegurmcadoorgnz) {
		this.csegurmcadoorgnz = csegurmcadoorgnz;
	}

	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}

	public String getDprevtgarntexpdi() {
		return dprevtgarntexpdi;
	}
	public void setDprevtgarntexpdi(String dprevtgarntexpdi) {
		this.dprevtgarntexpdi = dprevtgarntexpdi;
	}

	public String getDprevtfimembrq() {
		return dprevtfimembrq;
	}
	public void setDprevtfimembrq(String dprevtfimembrq) {
		this.dprevtfimembrq = dprevtfimembrq;
	}

	public String getDprevtinicembrq() {
		return dprevtinicembrq;
	}
	public void setDprevtinicembrq(String dprevtinicembrq) {
		this.dprevtinicembrq = dprevtinicembrq;
	}

	public String getPcobervarprodt() {
		return pcobervarprodt;
	}
	public void setPcobervarprodt(String pcobervarprodt) {
		this.pcobervarprodt = pcobervarprodt;
	}

	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public String getCcobrcomisadcio() {
		return ccobrcomisadcio;
	}
	public void setCcobrcomisadcio(String ccobrcomisadcio) {
		this.ccobrcomisadcio = ccobrcomisadcio;
	}

	public String getDabertcntragarnt() {
		return dabertcntragarnt;
	}
	public void setDabertcntragarnt(String dabertcntragarnt) {
		this.dabertcntragarnt = dabertcntragarnt;
	}

	public String getDvctocntragarnt() {
		return dvctocntragarnt;
	}
	public void setDvctocntragarnt(String dvctocntragarnt) {
		this.dvctocntragarnt = dvctocntragarnt;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public String getRjustfdqmto() {
		return rjustfdqmto;
	}
	public void setRjustfdqmto(String rjustfdqmto) {
		this.rjustfdqmto = rjustfdqmto;
	}

	public String getVtxspreadtot() {
		return vtxspreadtot;
	}
	public void setVtxspreadtot(String vtxspreadtot) {
		this.vtxspreadtot = vtxspreadtot;
	}
    
}