package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/03/17 13:53
 */
public class Npccwwkerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWKE-HEADER.NPCCWWKE-COD-LAYOUT")
	private String codlayout = "NPCCWWKE";

	@Adapter(transactionField = "NPCCWWKE-HEADER.NPCCWWKE-TAM-LAYOUT")
	private Integer tamlayout = 1318;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CADITV-BLETO-CMBIO")
	private Integer caditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CPSSOA-JURID")
	private Long cpssoajurid = 0L;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CPSSOA-ANLSE-CREDT")
	private Long cpssoaanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-DANO-SOLTC-ANLSE")
	private Integer danosoltcanlse = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NSOLTC-ANLSE-CREDT")
	private Long nsoltcanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NSEQ-SOLTC-ANLSE")
	private Integer nseqsoltcanlse = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CRTING")
	private String crting = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-NCTA-BCRIA-CMBIO")
	private Integer nctabcriacmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VMOEDA-LIM-GERC")
	private String vmoedalimgerc = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CECONM-MOEDA-DSEMB")
	private Integer ceconmmoedadsemb = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CINDCD-NEGOC-LIBOR")
	private String cindcdnegoclibor = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CNEGOC-SWAP-FLUXO")
	private String cnegocswapfluxo = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CNEGOC-SWAP-ESTRG")
	private String cnegocswapestrg = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CTPO-COTAC-TX")
	private Integer ctpocotactx = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-PTX-SWAP-CMPDO")
	private String ptxswapcmpdo = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CINDCD-NEGOC-CARTA")
	private String cindcdnegoccarta = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-TDIA-VALDD-LETRA")
	private Integer tdiavalddletra = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-DVALDD-NEGOC-CMBIO")
	private String dvalddnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CCOMIS-CARTA-NACIO")
	private String ccomiscartanacio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CINDCD-NEGOC-ARBTR")
	private String cindcdnegocarbtr = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-QPRZ-MED-CMBIO")
	private Integer qprzmedcmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VIMPST-NEGOC-CMBIO")
	private String vimpstnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VIOF-NEGOC-CMBIO")
	private String viofnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VTX-MORA-CMBIO")
	private String vtxmoracmbio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CBASE-JURO-MORA")
	private Integer cbasejuromora = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VMULTA-NEGOC-CMBIO")
	private String vmultanegoccmbio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CSEGUR-TRNSP-MCADO")
	private String csegurtrnspmcado = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CSEGUR-MCADO-ORGNZ")
	private String csegurmcadoorgnz = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-RJUSTF-DQMTO")
	private String rjustfdqmto = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-DPREVT-EMBRQ")
	private String dprevtembrq = null;

	@Adapter(transactionField = "NPCCWWKE-REGISTRO.NPCCWWKE-VTX-SPREAD-TOT")
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

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
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