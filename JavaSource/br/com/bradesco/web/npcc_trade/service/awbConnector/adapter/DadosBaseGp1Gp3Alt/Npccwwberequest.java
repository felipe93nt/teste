package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBaseGp1Gp3Alt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 12:35
 */
public class Npccwwberequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWBE-HEADER.NPCCWWBE-COD-LAYOUT")
	private String codlayout = "NPCCWWBE";

	@Adapter(transactionField = "NPCCWWBE-HEADER.NPCCWWBE-TAM-LAYOUT")
	private Integer tamlayout = 2007;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CUSUAR-MANUT")
	private String cusuarmanut = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NBLETO-CMBIO-ORIGE")
	private Long nbletocmbioorige = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CADITV-BLETO-CMBIO")
	private Integer caditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DFCHTO-BLETO-CMBIO")
	private String dfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CPSSOA-JURID")
	private Long cpssoajurid = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CTPO-CANAL")
	private Integer ctpocanal = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NTPO-CLASF-PSSOA")
	private Integer ntpoclasfpssoa = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CPSSOA-ANLSE-CREDT")
	private Long cpssoaanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DANO-SOLTC-ANLSE")
	private Integer danosoltcanlse = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NSOLTC-ANLSE-CREDT")
	private Long nsoltcanlsecredt = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NSEQ-SOLTC-ANLSE")
	private Integer nseqsoltcanlse = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VUTLZD-LIM-GERC")
	private String vutlzdlimgerc = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VSDO-LIM-SENSI")
	private String vsdolimsensi = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CMOTVO-BLETO-CMBIO")
	private Integer cmotvobletocmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CUSUAR-INCL")
	private String cusuarincl = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CPSSOA-JURID-CLI")
	private Long cpssoajuridcli = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NSEQ-UND-CLI")
	private Integer nsequndcli = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DVALDD-LIM-CMBIO")
	private String dvalddlimcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CRTING")
	private String crting = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CECONM-MOEDA-EQUAL")
	private Integer ceconmmoedaequal = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CMOEDA-ECONM-RECTA")
	private Integer cmoedaeconmrecta = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CECONM-MOEDA-DSEMB")
	private Integer ceconmmoedadsemb = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CUNIC-PSSOA-CTA")
	private Long cunicpssoacta = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-NCTA-BCRIA-CMBIO")
	private Integer nctabcriacmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DINIC-VALDD-CMBIO")
	private String dinicvalddcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DFIM-NEGOC-CMBIO")
	private String dfimnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CNEGOC-CMBIO-INDMD")
	private String cnegoccmbioindmd = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DLIM-EMBRQ-CMBIO")
	private String dlimembrqcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DLIM-DOCTO-EMBRQ")
	private String dlimdoctoembrq = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DPREVT-GARNT-EXPDI")
	private String dprevtgarntexpdi = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-TDIA-VALDD-CARTA")
	private Integer tdiavalddcarta = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-TDIA-VALDD-LETRA")
	private Integer tdiavalddletra = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-QPREVT-EMBRQ-CMBIO")
	private Integer qprevtembrqcmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-QPRZ-MED-CMBIO")
	private Integer qprzmedcmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-QREG-EXPOR-CMBIO")
	private Integer qregexporcmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DVALDD-NEGOC-CMBIO")
	private String dvalddnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CNEGOC-SWAP-FLUXO")
	private String cnegocswapfluxo = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CNEGOC-SWAP-ESTRG")
	private String cnegocswapestrg = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-NEGOC-CARTA")
	private String cindcdnegoccarta = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CCOMIS-CARTA-NACIO")
	private String ccomiscartanacio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-NEGOC-ARBTR")
	private String cindcdnegocarbtr = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-EMBRQ-PCIAL")
	private String cindcdembrqpcial = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CPERM-TRNSF-CARTA")
	private String cpermtrnsfcarta = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-CARTA-CNFDO")
	private String cindcdcartacnfdo = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-CARTA-IDPDT")
	private String cindcdcartaidpdt = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CCARTA-CONVE-RECDD")
	private String ccartaconverecdd = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CCOBR-COMIS-ADCIO")
	private String ccobrcomisadcio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-LASTR-CARTA")
	private String cindcdlastrcarta = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-LASTR-AGRIC")
	private String cindcdlastragric = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CSEGUR-TRNSP-MCADO")
	private String csegurtrnspmcado = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CSEGUR-MCADO-ORGNZ")
	private String csegurmcadoorgnz = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-NEGOC-LIBOR")
	private String cindcdnegoclibor = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CPERM-VAR-CMBIO")
	private String cpermvarcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CTPO-COTAC-TX")
	private Integer ctpocotactx = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CTPO-EMBRQ-CMBIO")
	private Integer ctpoembrqcmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CIDTFD-BNDES-PORTE")
	private Integer cidtfdbndesporte = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CIDTFD-BNDES-GRP")
	private Integer cidtfdbndesgrp = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CPRZ-NEGOC-CMBIO")
	private Integer cprznegoccmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CIDTFD-CARTA-CSNDO")
	private Integer cidtfdcartacsndo = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CTPO-JURO-TRADE")
	private Integer ctpojurotrade = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CCOBR-COMIS-MTORI")
	private Integer ccobrcomismtori = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CIDTFD-FORMA-COMIS")
	private Integer cidtfdformacomis = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CCOBR-COMIS-AGTE")
	private Integer ccobrcomisagte = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VMOEDA-LIM-GERC")
	private String vmoedalimgerc = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VPREVT-CMBIO-EQUAL")
	private String vprevtcmbioequal = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VPREVT-RECTA-CMBIO")
	private String vprevtrectacmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VTX-REMUN-BNDES")
	private String vtxremunbndes = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VTX-REMUN-CMBIO")
	private String vtxremuncmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VLIM-COBER-VAR")
	private String vlimcobervar = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PCOBER-VAR-PRODT")
	private String pcobervarprodt = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PTX-SWAP-CMPDO")
	private String ptxswapcmpdo = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PTX-CDI-FINAN")
	private String ptxcdifinan = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PCDI-MAIS-CMBIO")
	private String pcdimaiscmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PFIXA-JURO-CMBIO")
	private String pfixajurocmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PTOT-JURO-CMBIO")
	private String ptotjurocmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PCOMIS-MTORI-CMBIO")
	private String pcomismtoricmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PAGTE-FINCR-CMBIO")
	private String pagtefincrcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-PTX-EQUAL-CMBIO")
	private String ptxequalcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VIMPST-NEGOC-CMBIO")
	private String vimpstnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VMULTA-NEGOC-CMBIO")
	private String vmultanegoccmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-IORG-EXTER-CMBIO")
	private String iorgextercmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VIOF-NEGOC-CMBIO")
	private String viofnegoccmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VTX-MORA-CMBIO")
	private String vtxmoracmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CBASE-JURO-MORA")
	private Integer cbasejuromora = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CFLUXO-PERDC-CMBIO")
	private Integer cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DPREVT-INIC-EMBRQ")
	private String dprevtinicembrq = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DPREVT-FIM-EMBRQ")
	private String dprevtfimembrq = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-CNTRA-GARNT")
	private String cindcdcntragarnt = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-TDIA-CNTRA-GARNT")
	private Integer tdiacntragarnt = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DVCTO-CNTRA-GARNT")
	private String dvctocntragarnt = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DABERT-CNTRA-GARNT")
	private String dabertcntragarnt = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-RENOV-CNTRA")
	private String cindcdrenovcntra = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-QDIA-ALERT-CNTRA")
	private Integer qdiaalertcntra = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DALERT-VCTO-CNTRA")
	private String dalertvctocntra = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CINDCD-CUSTO-EXTER")
	private String cindcdcustoexter = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CUNIC-PSSOA-CMBIO-T")
	private Long cunicpssoacmbiot = 0L;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-RJUSTF-DQMTO")
	private String rjustfdqmto = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DPREVT-EMBRQ")
	private String dprevtembrq = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DLIM-ENVIO-RSUMO")
	private String dlimenviorsumo = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DINIC-VALDD-PPSTA")
	private String dinicvalddppsta = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-DFIM-VALDD-PPSTA")
	private String dfimvalddppsta = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VTX-SPREAD-TOT")
	private Double vtxspreadtot = 0D;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-CTPO-PRZ-CMBIO")
	private Integer ctpoprzcmbio = 0;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VAGTE-FINCR-CMBIO")
	private String vagtefincrcmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-VBCO-MTORI-CMBIO")
	private String vbcomtoricmbio = null;

	@Adapter(transactionField = "NPCCWWBE-REGISTRO.NPCCWWBE-INFO-COMPL-BNDES")
	private String infocomplbndes = null;

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

	public String getCusuarmanut() {
		return cusuarmanut;
	}
	public void setCusuarmanut(String cusuarmanut) {
		this.cusuarmanut = cusuarmanut;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public Long getNbletocmbioorige() {
		return nbletocmbioorige;
	}
	public void setNbletocmbioorige(Long nbletocmbioorige) {
		this.nbletocmbioorige = nbletocmbioorige;
	}

	public Integer getDanobase() {
		return danobase;
	}
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
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

	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}
	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}
	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
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

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getCtpocanal() {
		return ctpocanal;
	}
	public void setCtpocanal(Integer ctpocanal) {
		this.ctpocanal = ctpocanal;
	}

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}

	public Integer getNtpoclasfpssoa() {
		return ntpoclasfpssoa;
	}
	public void setNtpoclasfpssoa(Integer ntpoclasfpssoa) {
		this.ntpoclasfpssoa = ntpoclasfpssoa;
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

	public Integer getCeconmmoedalim() {
		return ceconmmoedalim;
	}
	public void setCeconmmoedalim(Integer ceconmmoedalim) {
		this.ceconmmoedalim = ceconmmoedalim;
	}

	public String getVutlzdlimgerc() {
		return vutlzdlimgerc;
	}
	public void setVutlzdlimgerc(String vutlzdlimgerc) {
		this.vutlzdlimgerc = vutlzdlimgerc;
	}

	public String getVsdolimsensi() {
		return vsdolimsensi;
	}
	public void setVsdolimsensi(String vsdolimsensi) {
		this.vsdolimsensi = vsdolimsensi;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}

	public Integer getCmotvobletocmbio() {
		return cmotvobletocmbio;
	}
	public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
		this.cmotvobletocmbio = cmotvobletocmbio;
	}

	public String getCusuarincl() {
		return cusuarincl;
	}
	public void setCusuarincl(String cusuarincl) {
		this.cusuarincl = cusuarincl;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	public Long getCpssoajuridcli() {
		return cpssoajuridcli;
	}
	public void setCpssoajuridcli(Long cpssoajuridcli) {
		this.cpssoajuridcli = cpssoajuridcli;
	}

	public Integer getNsequndcli() {
		return nsequndcli;
	}
	public void setNsequndcli(Integer nsequndcli) {
		this.nsequndcli = nsequndcli;
	}

	public String getDvalddlimcmbio() {
		return dvalddlimcmbio;
	}
	public void setDvalddlimcmbio(String dvalddlimcmbio) {
		this.dvalddlimcmbio = dvalddlimcmbio;
	}

	public String getCrting() {
		return crting;
	}
	public void setCrting(String crting) {
		this.crting = crting;
	}

	public Long getNppstapontucmbio() {
		return nppstapontucmbio;
	}
	public void setNppstapontucmbio(Long nppstapontucmbio) {
		this.nppstapontucmbio = nppstapontucmbio;
	}

	public Integer getCeconmmoedaequal() {
		return ceconmmoedaequal;
	}
	public void setCeconmmoedaequal(Integer ceconmmoedaequal) {
		this.ceconmmoedaequal = ceconmmoedaequal;
	}

	public Integer getCmoedaeconmrecta() {
		return cmoedaeconmrecta;
	}
	public void setCmoedaeconmrecta(Integer cmoedaeconmrecta) {
		this.cmoedaeconmrecta = cmoedaeconmrecta;
	}

	public Integer getCeconmmoedadsemb() {
		return ceconmmoedadsemb;
	}
	public void setCeconmmoedadsemb(Integer ceconmmoedadsemb) {
		this.ceconmmoedadsemb = ceconmmoedadsemb;
	}

	public Long getCunicpssoacta() {
		return cunicpssoacta;
	}
	public void setCunicpssoacta(Long cunicpssoacta) {
		this.cunicpssoacta = cunicpssoacta;
	}

	public Integer getNctabcriacmbio() {
		return nctabcriacmbio;
	}
	public void setNctabcriacmbio(Integer nctabcriacmbio) {
		this.nctabcriacmbio = nctabcriacmbio;
	}

	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}

	public String getDinicvalddcmbio() {
		return dinicvalddcmbio;
	}
	public void setDinicvalddcmbio(String dinicvalddcmbio) {
		this.dinicvalddcmbio = dinicvalddcmbio;
	}

	public String getDfimnegoccmbio() {
		return dfimnegoccmbio;
	}
	public void setDfimnegoccmbio(String dfimnegoccmbio) {
		this.dfimnegoccmbio = dfimnegoccmbio;
	}

	public String getCnegoccmbioindmd() {
		return cnegoccmbioindmd;
	}
	public void setCnegoccmbioindmd(String cnegoccmbioindmd) {
		this.cnegoccmbioindmd = cnegoccmbioindmd;
	}

	public String getDlimembrqcmbio() {
		return dlimembrqcmbio;
	}
	public void setDlimembrqcmbio(String dlimembrqcmbio) {
		this.dlimembrqcmbio = dlimembrqcmbio;
	}

	public String getDlimdoctoembrq() {
		return dlimdoctoembrq;
	}
	public void setDlimdoctoembrq(String dlimdoctoembrq) {
		this.dlimdoctoembrq = dlimdoctoembrq;
	}

	public String getDprevtgarntexpdi() {
		return dprevtgarntexpdi;
	}
	public void setDprevtgarntexpdi(String dprevtgarntexpdi) {
		this.dprevtgarntexpdi = dprevtgarntexpdi;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public Integer getTdiavalddcarta() {
		return tdiavalddcarta;
	}
	public void setTdiavalddcarta(Integer tdiavalddcarta) {
		this.tdiavalddcarta = tdiavalddcarta;
	}

	public Integer getTdiavalddletra() {
		return tdiavalddletra;
	}
	public void setTdiavalddletra(Integer tdiavalddletra) {
		this.tdiavalddletra = tdiavalddletra;
	}

	public Integer getQprevtembrqcmbio() {
		return qprevtembrqcmbio;
	}
	public void setQprevtembrqcmbio(Integer qprevtembrqcmbio) {
		this.qprevtembrqcmbio = qprevtembrqcmbio;
	}

	public Integer getQprzmedcmbio() {
		return qprzmedcmbio;
	}
	public void setQprzmedcmbio(Integer qprzmedcmbio) {
		this.qprzmedcmbio = qprzmedcmbio;
	}

	public Integer getQregexporcmbio() {
		return qregexporcmbio;
	}
	public void setQregexporcmbio(Integer qregexporcmbio) {
		this.qregexporcmbio = qregexporcmbio;
	}

	public String getDvalddnegoccmbio() {
		return dvalddnegoccmbio;
	}
	public void setDvalddnegoccmbio(String dvalddnegoccmbio) {
		this.dvalddnegoccmbio = dvalddnegoccmbio;
	}

	public String getCindcdnegocswap() {
		return cindcdnegocswap;
	}
	public void setCindcdnegocswap(String cindcdnegocswap) {
		this.cindcdnegocswap = cindcdnegocswap;
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

	public String getCindcdnegoccarta() {
		return cindcdnegoccarta;
	}
	public void setCindcdnegoccarta(String cindcdnegoccarta) {
		this.cindcdnegoccarta = cindcdnegoccarta;
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

	public String getCindcdembrqpcial() {
		return cindcdembrqpcial;
	}
	public void setCindcdembrqpcial(String cindcdembrqpcial) {
		this.cindcdembrqpcial = cindcdembrqpcial;
	}

	public String getCpermtrnsfcarta() {
		return cpermtrnsfcarta;
	}
	public void setCpermtrnsfcarta(String cpermtrnsfcarta) {
		this.cpermtrnsfcarta = cpermtrnsfcarta;
	}

	public String getCindcdcartacnfdo() {
		return cindcdcartacnfdo;
	}
	public void setCindcdcartacnfdo(String cindcdcartacnfdo) {
		this.cindcdcartacnfdo = cindcdcartacnfdo;
	}

	public String getCindcdcartaidpdt() {
		return cindcdcartaidpdt;
	}
	public void setCindcdcartaidpdt(String cindcdcartaidpdt) {
		this.cindcdcartaidpdt = cindcdcartaidpdt;
	}

	public String getCcartaconverecdd() {
		return ccartaconverecdd;
	}
	public void setCcartaconverecdd(String ccartaconverecdd) {
		this.ccartaconverecdd = ccartaconverecdd;
	}

	public String getCcobrcomisadcio() {
		return ccobrcomisadcio;
	}
	public void setCcobrcomisadcio(String ccobrcomisadcio) {
		this.ccobrcomisadcio = ccobrcomisadcio;
	}

	public String getCindcdlastrcarta() {
		return cindcdlastrcarta;
	}
	public void setCindcdlastrcarta(String cindcdlastrcarta) {
		this.cindcdlastrcarta = cindcdlastrcarta;
	}

	public String getCindcdlastragric() {
		return cindcdlastragric;
	}
	public void setCindcdlastragric(String cindcdlastragric) {
		this.cindcdlastragric = cindcdlastragric;
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

	public String getCindcdnegoclibor() {
		return cindcdnegoclibor;
	}
	public void setCindcdnegoclibor(String cindcdnegoclibor) {
		this.cindcdnegoclibor = cindcdnegoclibor;
	}

	public String getCpermvarcmbio() {
		return cpermvarcmbio;
	}
	public void setCpermvarcmbio(String cpermvarcmbio) {
		this.cpermvarcmbio = cpermvarcmbio;
	}

	public Integer getCtpocotactx() {
		return ctpocotactx;
	}
	public void setCtpocotactx(Integer ctpocotactx) {
		this.ctpocotactx = ctpocotactx;
	}

	public Integer getCtpoembrqcmbio() {
		return ctpoembrqcmbio;
	}
	public void setCtpoembrqcmbio(Integer ctpoembrqcmbio) {
		this.ctpoembrqcmbio = ctpoembrqcmbio;
	}

	public Integer getCidtfdbndesporte() {
		return cidtfdbndesporte;
	}
	public void setCidtfdbndesporte(Integer cidtfdbndesporte) {
		this.cidtfdbndesporte = cidtfdbndesporte;
	}

	public Integer getCidtfdbndesgrp() {
		return cidtfdbndesgrp;
	}
	public void setCidtfdbndesgrp(Integer cidtfdbndesgrp) {
		this.cidtfdbndesgrp = cidtfdbndesgrp;
	}

	public Integer getCtponegoccmbio() {
		return ctponegoccmbio;
	}
	public void setCtponegoccmbio(Integer ctponegoccmbio) {
		this.ctponegoccmbio = ctponegoccmbio;
	}

	public Integer getCprznegoccmbio() {
		return cprznegoccmbio;
	}
	public void setCprznegoccmbio(Integer cprznegoccmbio) {
		this.cprznegoccmbio = cprznegoccmbio;
	}

	public Integer getCidtfdcartacsndo() {
		return cidtfdcartacsndo;
	}
	public void setCidtfdcartacsndo(Integer cidtfdcartacsndo) {
		this.cidtfdcartacsndo = cidtfdcartacsndo;
	}

	public Integer getCtpojurotrade() {
		return ctpojurotrade;
	}
	public void setCtpojurotrade(Integer ctpojurotrade) {
		this.ctpojurotrade = ctpojurotrade;
	}

	public Integer getCcobrcomismtori() {
		return ccobrcomismtori;
	}
	public void setCcobrcomismtori(Integer ccobrcomismtori) {
		this.ccobrcomismtori = ccobrcomismtori;
	}

	public Integer getCidtfdformacomis() {
		return cidtfdformacomis;
	}
	public void setCidtfdformacomis(Integer cidtfdformacomis) {
		this.cidtfdformacomis = cidtfdformacomis;
	}

	public Integer getCcobrcomisagte() {
		return ccobrcomisagte;
	}
	public void setCcobrcomisagte(Integer ccobrcomisagte) {
		this.ccobrcomisagte = ccobrcomisagte;
	}

	public String getVmoedalimgerc() {
		return vmoedalimgerc;
	}
	public void setVmoedalimgerc(String vmoedalimgerc) {
		this.vmoedalimgerc = vmoedalimgerc;
	}

	public String getVprevtcmbioequal() {
		return vprevtcmbioequal;
	}
	public void setVprevtcmbioequal(String vprevtcmbioequal) {
		this.vprevtcmbioequal = vprevtcmbioequal;
	}

	public String getVprevtrectacmbio() {
		return vprevtrectacmbio;
	}
	public void setVprevtrectacmbio(String vprevtrectacmbio) {
		this.vprevtrectacmbio = vprevtrectacmbio;
	}

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public String getVtxremunbndes() {
		return vtxremunbndes;
	}
	public void setVtxremunbndes(String vtxremunbndes) {
		this.vtxremunbndes = vtxremunbndes;
	}

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public String getVtxremuncmbio() {
		return vtxremuncmbio;
	}
	public void setVtxremuncmbio(String vtxremuncmbio) {
		this.vtxremuncmbio = vtxremuncmbio;
	}

	public String getVlimcobervar() {
		return vlimcobervar;
	}
	public void setVlimcobervar(String vlimcobervar) {
		this.vlimcobervar = vlimcobervar;
	}

	public String getPcobervarprodt() {
		return pcobervarprodt;
	}
	public void setPcobervarprodt(String pcobervarprodt) {
		this.pcobervarprodt = pcobervarprodt;
	}

	public String getPtxswapcmpdo() {
		return ptxswapcmpdo;
	}
	public void setPtxswapcmpdo(String ptxswapcmpdo) {
		this.ptxswapcmpdo = ptxswapcmpdo;
	}

	public String getPtxcdifinan() {
		return ptxcdifinan;
	}
	public void setPtxcdifinan(String ptxcdifinan) {
		this.ptxcdifinan = ptxcdifinan;
	}

	public String getPcdimaiscmbio() {
		return pcdimaiscmbio;
	}
	public void setPcdimaiscmbio(String pcdimaiscmbio) {
		this.pcdimaiscmbio = pcdimaiscmbio;
	}

	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public String getPfixajurocmbio() {
		return pfixajurocmbio;
	}
	public void setPfixajurocmbio(String pfixajurocmbio) {
		this.pfixajurocmbio = pfixajurocmbio;
	}

	public String getPtotjurocmbio() {
		return ptotjurocmbio;
	}
	public void setPtotjurocmbio(String ptotjurocmbio) {
		this.ptotjurocmbio = ptotjurocmbio;
	}

	public String getPcomismtoricmbio() {
		return pcomismtoricmbio;
	}
	public void setPcomismtoricmbio(String pcomismtoricmbio) {
		this.pcomismtoricmbio = pcomismtoricmbio;
	}

	public String getPagtefincrcmbio() {
		return pagtefincrcmbio;
	}
	public void setPagtefincrcmbio(String pagtefincrcmbio) {
		this.pagtefincrcmbio = pagtefincrcmbio;
	}

	public String getPtxequalcmbio() {
		return ptxequalcmbio;
	}
	public void setPtxequalcmbio(String ptxequalcmbio) {
		this.ptxequalcmbio = ptxequalcmbio;
	}

	public String getVimpstnegoccmbio() {
		return vimpstnegoccmbio;
	}
	public void setVimpstnegoccmbio(String vimpstnegoccmbio) {
		this.vimpstnegoccmbio = vimpstnegoccmbio;
	}

	public String getVmultanegoccmbio() {
		return vmultanegoccmbio;
	}
	public void setVmultanegoccmbio(String vmultanegoccmbio) {
		this.vmultanegoccmbio = vmultanegoccmbio;
	}

	public String getIorgextercmbio() {
		return iorgextercmbio;
	}
	public void setIorgextercmbio(String iorgextercmbio) {
		this.iorgextercmbio = iorgextercmbio;
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

	public Integer getCbasejuromora() {
		return cbasejuromora;
	}
	public void setCbasejuromora(Integer cbasejuromora) {
		this.cbasejuromora = cbasejuromora;
	}

	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}

	public String getDprevtinicembrq() {
		return dprevtinicembrq;
	}
	public void setDprevtinicembrq(String dprevtinicembrq) {
		this.dprevtinicembrq = dprevtinicembrq;
	}

	public String getDprevtfimembrq() {
		return dprevtfimembrq;
	}
	public void setDprevtfimembrq(String dprevtfimembrq) {
		this.dprevtfimembrq = dprevtfimembrq;
	}

	public String getCindcdcntragarnt() {
		return cindcdcntragarnt;
	}
	public void setCindcdcntragarnt(String cindcdcntragarnt) {
		this.cindcdcntragarnt = cindcdcntragarnt;
	}

	public Integer getTdiacntragarnt() {
		return tdiacntragarnt;
	}
	public void setTdiacntragarnt(Integer tdiacntragarnt) {
		this.tdiacntragarnt = tdiacntragarnt;
	}

	public String getDvctocntragarnt() {
		return dvctocntragarnt;
	}
	public void setDvctocntragarnt(String dvctocntragarnt) {
		this.dvctocntragarnt = dvctocntragarnt;
	}

	public String getDabertcntragarnt() {
		return dabertcntragarnt;
	}
	public void setDabertcntragarnt(String dabertcntragarnt) {
		this.dabertcntragarnt = dabertcntragarnt;
	}

	public String getCindcdrenovcntra() {
		return cindcdrenovcntra;
	}
	public void setCindcdrenovcntra(String cindcdrenovcntra) {
		this.cindcdrenovcntra = cindcdrenovcntra;
	}

	public Integer getQdiaalertcntra() {
		return qdiaalertcntra;
	}
	public void setQdiaalertcntra(Integer qdiaalertcntra) {
		this.qdiaalertcntra = qdiaalertcntra;
	}

	public String getDalertvctocntra() {
		return dalertvctocntra;
	}
	public void setDalertvctocntra(String dalertvctocntra) {
		this.dalertvctocntra = dalertvctocntra;
	}

	public String getCindcdcustoexter() {
		return cindcdcustoexter;
	}
	public void setCindcdcustoexter(String cindcdcustoexter) {
		this.cindcdcustoexter = cindcdcustoexter;
	}

	public Long getCunicpssoacmbiot() {
		return cunicpssoacmbiot;
	}
	public void setCunicpssoacmbiot(Long cunicpssoacmbiot) {
		this.cunicpssoacmbiot = cunicpssoacmbiot;
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

	public String getDlimenviorsumo() {
		return dlimenviorsumo;
	}
	public void setDlimenviorsumo(String dlimenviorsumo) {
		this.dlimenviorsumo = dlimenviorsumo;
	}

	public String getDinicvalddppsta() {
		return dinicvalddppsta;
	}
	public void setDinicvalddppsta(String dinicvalddppsta) {
		this.dinicvalddppsta = dinicvalddppsta;
	}

	public String getDfimvalddppsta() {
		return dfimvalddppsta;
	}
	public void setDfimvalddppsta(String dfimvalddppsta) {
		this.dfimvalddppsta = dfimvalddppsta;
	}

	public Double getVtxspreadtot() {
		return vtxspreadtot;
	}
	public void setVtxspreadtot(Double vtxspreadtot) {
		this.vtxspreadtot = vtxspreadtot;
	}

	public Integer getCtpoprzcmbio() {
		return ctpoprzcmbio;
	}
	public void setCtpoprzcmbio(Integer ctpoprzcmbio) {
		this.ctpoprzcmbio = ctpoprzcmbio;
	}

	public String getVagtefincrcmbio() {
		return vagtefincrcmbio;
	}
	public void setVagtefincrcmbio(String vagtefincrcmbio) {
		this.vagtefincrcmbio = vagtefincrcmbio;
	}

	public String getVbcomtoricmbio() {
		return vbcomtoricmbio;
	}
	public void setVbcomtoricmbio(String vbcomtoricmbio) {
		this.vbcomtoricmbio = vbcomtoricmbio;
	}

	public String getInfocomplbndes() {
		return infocomplbndes;
	}

	public void setInfocomplbndes(String infocomplbndes) {
		this.infocomplbndes = infocomplbndes;
	}

}