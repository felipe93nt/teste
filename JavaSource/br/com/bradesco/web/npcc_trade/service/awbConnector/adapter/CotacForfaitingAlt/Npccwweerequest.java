package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacForfaitingAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/03/17 17:58
 */
public class Npccwweerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWEE-HEADER.NPCCWWEE-COD-LAYOUT")
	private String codlayout = "NPCCWWEE";

	@Adapter(transactionField = "NPCCWWEE-HEADER.NPCCWWEE-TAM-LAYOUT")
	private Integer tamlayout = 1403;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CADITV-BLETO-CMBIO")
	private Integer caditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CPSSOA-JURID")
	private Long cpssoajurid = 0L;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CPSSOA-ANLSE-CREDT")
	private Long cpssoaanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DANO-SOLTC-ANLSE")
	private Integer danosoltcanlse = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NSOLTC-ANLSE-CREDT")
	private Long nsoltcanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NSEQ-SOLTC-ANLSE")
	private Integer nseqsoltcanlse = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CRTING")
	private String crting = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-NCTA-BCRIA-CMBIO")
	private Integer nctabcriacmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VMOEDA-LIM-GERC")
	private String vmoedalimgerc = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VSDO-LIM-SENSI")
	private String vsdolimsensi = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CECONM-MOEDA-DSEMB")
	private Integer ceconmmoedadsemb = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CINDCD-NEGOC-LIBOR")
	private String cindcdnegoclibor = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CNEGOC-SWAP-FLUXO")
	private String cnegocswapfluxo = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CNEGOC-SWAP-ESTRG")
	private String cnegocswapestrg = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CTPO-COTAC-TX")
	private Integer ctpocotactx = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CTPO-JURO-TRADE")
	private Integer ctpojurotrade = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-PTX-SWAP-CMPDO")
	private String ptxswapcmpdo = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CINDCD-NEGOC-CARTA")
	private String cindcdnegoccarta = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-TDIA-VALDD-LETRA")
	private Integer tdiavalddletra = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DVALDD-NEGOC-CMBIO")
	private String dvalddnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CCOMIS-CARTA-NACIO")
	private String ccomiscartanacio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CINDCD-NEGOC-ARBTR")
	private String cindcdnegocarbtr = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-QPRZ-MED-CMBIO")
	private Integer qprzmedcmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VIMPST-NEGOC-CMBIO")
	private String vimpstnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VIOF-NEGOC-CMBIO")
	private String viofnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VTX-MORA-CMBIO")
	private String vtxmoracmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CBASE-JURO-MORA")
	private Integer cbasejuromora = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VMULTA-NEGOC-CMBIO")
	private String vmultanegoccmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CSEGUR-TRNSP-MCADO")
	private String csegurtrnspmcado = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CSEGUR-MCADO-ORGNZ")
	private String csegurmcadoorgnz = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DPREVT-GARNT-EXPDI")
	private String dprevtgarntexpdi = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DPREVT-FIM-EMBRQ")
	private String dprevtfimembrq = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DPREVT-INIC-EMBRQ")
	private String dprevtinicembrq = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-PCOBER-VAR-PRODT")
	private String pcobervarprodt = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-CCOBR-COMIS-ADCIO")
	private String ccobrcomisadcio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DABERT-CNTRA-GARNT")
	private String dabertcntragarnt = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DVCTO-CNTRA-GARNT")
	private String dvctocntragarnt = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-RJUSTF-DQMTO")
	private String rjustfdqmto = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-DPREVT-EMBRQ")
	private String dprevtembrq = null;

	@Adapter(transactionField = "NPCCWWEE-REGISTRO.NPCCWWEE-VTX-SPREAD-TOT")
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Integer getNbletocmbioano() {
		return nbletocmbioano;
	}
	public void setNbletocmbioano(Integer nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
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

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
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

	public String getVsdolimsensi() {
		return vsdolimsensi;
	}
	public void setVsdolimsensi(String vsdolimsensi) {
		this.vsdolimsensi = vsdolimsensi;
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

	public String getDprevtembrq() {
		return dprevtembrq;
	}
	public void setDprevtembrq(String dprevtembrq) {
		this.dprevtembrq = dprevtembrq;
	}

	public String getVtxspreadtot() {
		return vtxspreadtot;
	}
	public void setVtxspreadtot(String vtxspreadtot) {
		this.vtxspreadtot = vtxspreadtot;
	}
    
}