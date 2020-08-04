package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 14/11/17 10:30
 */
public class Npccwx4sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX4S-HEADER.NPCCWX4S-COD-LAYOUT")
	private String codlayout = "NPCCWX4S";

	@Adapter(transactionField = "NPCCWX4S-HEADER.NPCCWX4S-TAM-LAYOUT")
	private Integer tamlayout = 9730;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NCUNIC-CLI-CMBIO")
	private String ncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TP-PESSOA")
	private String tppessoa = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CPF-CNPJ")
	private Integer cpfcnpj = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CFLIAL")
	private Integer cflial = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CCTRL")
	private Integer cctrl = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NCTA-BCRIA-CMBIO")
	private Integer nctabcriacmbio = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CBCO")
	private Integer cbco = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NOME-SOCIAL")
	private String nomesocial = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CAG-BCRIA")
	private Integer cagbcria = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CCTA-BCRIA-CMBIO")
	private Long cctabcriacmbio = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DIGT-CCTA-BCRIA")
	private String digtcctabcria = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CIDADE")
	private String cidade = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-ESTADO")
	private String estado = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CPSSOA-JURID")
	private Long cpssoajurid = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NOME-UND-ORGNZ")
	private String nomeundorgnz = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CRTING")
	private String crting = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DTPO-SGMTO-CLI")
	private String dtposgmtocli = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DPRODT-SERVC")
	private String dprodtservc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DMODLD-PRODT-CMBIO")
	private String dmodldprodtcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DSIT-BLETO-CMBIO")
	private String dsitbletocmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DVALDD-NEGOC-CMBIO")
	private String dvalddnegoccmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CUSUAR-INCLT")
	private String cusuarinclt = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NUSUAR-INCLT")
	private String nusuarinclt = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-SIMBL-ECONM-MOEDA")
	private String simbleconmmoeda = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DESCR-ECONM-MOEDA")
	private String descreconmmoeda = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CECONM-MOEDA-DSEMB")
	private Integer ceconmmoedadsemb = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-SIMBL-ECONM-DSEMB")
	private String simbleconmdsemb = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DESCR-ECONM-DSEMB")
	private String descreconmdsemb = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DPREVT-GARNT-EXPDI")
	private String dprevtgarntexpdi = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DABERT-CNTRA-GARNT")
	private String dabertcntragarnt = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DVCTO-CNTRA-GARNT")
	private String dvctocntragarnt = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DPREVT-INIC-EMBRQ")
	private String dprevtinicembrq = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DPREVT-FIM-EMBRQ")
	private String dprevtfimembrq = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-SIMBL-ECONM-LIM")
	private String simbleconmlim = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DESCR-ECONM-LIM")
	private String descreconmlim = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VMOEDA-LIM-GERC")
	private String vmoedalimgerc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TDIA-VALDD-LETRA")
	private Integer tdiavalddletra = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CBANQR-CMBIO-FNDNG")
	private Long cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DBCO-EXT-CMBIO")
	private String dbcoextcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PRACA")
	private String praca = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CBANQR-CMBIO-RCDOR")
	private Long cbanqrcmbiorcdor = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DBCO-REEMBOLSADOR")
	private String dbcoreembolsador = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PRACA-REEMBOLSADOR")
	private String pracareembolsador = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TDIA-CMBIO-PRCF")
	private Integer tdiacmbioprcf = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DCOTAC-FNDNG-CMBIO")
	private String dcotacfndngcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PTX-FIXA-CMBIO")
	private String ptxfixacmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CINDCD-ECONM-LIBOR")
	private Integer cindcdeconmlibor = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-SIMBL-ECONM-LIBOR")
	private String simbleconmlibor = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TMES-LIBOR-CMBIO")
	private Integer tmesliborcmbio = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VTX-LIBOR-CMBIO")
	private String vtxliborcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VTRAVA-LIBOR-CMBIO")
	private String vtravaliborcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VTX-MORA-CMBIO")
	private String vtxmoracmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CBASE-JURO-MORA")
	private Integer cbasejuromora = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VMULTA-NEGOC-CMBIO")
	private String vmultanegoccmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DMOD-CONTR-CMBIO")
	private String dmodcontrcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CUSTO-TOTAL")
	private String custototal = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VTX-SPREAD-APROV")
	private String vtxspreadaprov = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VALOR-JUROS")
	private String valorjuros = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VALOR-SAQUE")
	private String valorsaque = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TAXA-JUROS")
	private String taxajuros = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TAXA-DESCONTADA")
	private String taxadescontada = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CTPO-JURO-TRADE")
	private Integer ctpojurotrade = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CUNIC-PSSOA-CMBIO-T")
	private Long cunicpssoacmbiot = 0L;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NCUNIC-PSOA-CMBIO-T")
	private String ncunicpsoacmbiot = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CCOBR-COMIS-ADCIO")
	private String ccobrcomisadcio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PCOBER-VAR-PRODT")
	private String pcobervarprodt = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CMOVTC-INCEL")
	private String cmovtcincel = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-RRTING-LVGEM-DNHE")
	private String rrtinglvgemdnhe = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PERC-RE-ENTRG")
	private String percreentrg = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-RCLASF-EXPORT-ENTRG")
	private String rclasfexportentrg = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PERC-DI-ENTRG")
	private String percdientrg = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-RCLASF-IMPORT-ENTRG")
	private String rclasfimportentrg = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CINDCD-CONTR-FALT")
	private Integer cindcdcontrfalt = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DABERT-CTA-CLI")
	private String dabertctacli = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DFUNDC-NASC")
	private String dfundcnasc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-QDIA-VENCD-CONTR")
	private Integer qdiavencdcontr = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-QCONTR-DOCTO-PEND")
	private Integer qcontrdoctopend = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DFCHTO-BLETO-DESC")
	private String dfchtobletodesc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CPRODT-DESC")
	private String cprodtdesc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CMODLD-PRODT-DESC")
	private String cmodldprodtdesc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CECONM-MOEDA-DESC")
	private String ceconmmoedadesc = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VLR-MOEDA-ESTRANG")
	private String vlrmoedaestrang = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VTX-RENTB-CMBIO")
	private String vtxrentbcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-TXT-INFORMATIVO")
	private String txtinformativo = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-RINFO-ENVOL-MDIA")
	private String rinfoenvolmdia = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DINCL-REG")
	private String dinclreg = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-NOME-COMPLETO-CLI")
	private String nomecompletocli = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DFCHTO-BLETO-CMBIO")
	private String dfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DLIM-EMBRQ-CMBIO")
	private String dlimembrqcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DLIM-FNDNG-CMBIO")
	private String dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-IND-DQMTO")
	private String inddqmto = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PARECER-OPERADOR")
	private String pareceroperador = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PARECER-DSN")
	private String parecerdsn = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-QTDE-REST")
	private Integer qtderest = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-QTDE-PCELAS")
	private Integer qtdepcelas = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DESC-CTOTAL")
	private String descctotal = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CINDCD-CARTA-IDPDT")
	private String cindcdcartaidpdt = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-DESC-JURO-BLETO")
	private String descjurobleto = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-COMISSAO-DSEMBLSO")
	private String comissaodsemblso = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VLR-COMIS-DSEMB")
	private String vlrcomisdsemb = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-VTX-SPREAD-TOT")
	private String vtxspreadtot = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-RESTRICOES", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Npccwx4sresponse_restricoes")
	private List<Npccwx4sresponse_restricoes> restricoes = null;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-PCELAS-FNDNG", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting.Npccwx4sresponse_pcelasfndng")
	private List<Npccwx4sresponse_pcelasfndng> pcelasfndng = null;
	
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

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	public String getNcunicclicmbio() {
		return ncunicclicmbio;
	}
	public void setNcunicclicmbio(String ncunicclicmbio) {
		this.ncunicclicmbio = ncunicclicmbio;
	}

	public String getTppessoa() {
		return tppessoa;
	}
	public void setTppessoa(String tppessoa) {
		this.tppessoa = tppessoa;
	}

	public Integer getCpfcnpj() {
		return cpfcnpj;
	}
	public void setCpfcnpj(Integer cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public Integer getCflial() {
		return cflial;
	}
	public void setCflial(Integer cflial) {
		this.cflial = cflial;
	}

	public Integer getCctrl() {
		return cctrl;
	}
	public void setCctrl(Integer cctrl) {
		this.cctrl = cctrl;
	}

	public Integer getNctabcriacmbio() {
		return nctabcriacmbio;
	}
	public void setNctabcriacmbio(Integer nctabcriacmbio) {
		this.nctabcriacmbio = nctabcriacmbio;
	}

	public Integer getCbco() {
		return cbco;
	}
	public void setCbco(Integer cbco) {
		this.cbco = cbco;
	}

	public String getNomesocial() {
		return nomesocial;
	}
	public void setNomesocial(String nomesocial) {
		this.nomesocial = nomesocial;
	}

	public Integer getCagbcria() {
		return cagbcria;
	}
	public void setCagbcria(Integer cagbcria) {
		this.cagbcria = cagbcria;
	}

	public Long getCctabcriacmbio() {
		return cctabcriacmbio;
	}
	public void setCctabcriacmbio(Long cctabcriacmbio) {
		this.cctabcriacmbio = cctabcriacmbio;
	}

	public String getDigtcctabcria() {
		return digtcctabcria;
	}
	public void setDigtcctabcria(String digtcctabcria) {
		this.digtcctabcria = digtcctabcria;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getNomeundorgnz() {
		return nomeundorgnz;
	}
	public void setNomeundorgnz(String nomeundorgnz) {
		this.nomeundorgnz = nomeundorgnz;
	}

	public String getCrting() {
		return crting;
	}
	public void setCrting(String crting) {
		this.crting = crting;
	}

	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}

	public String getDtposgmtocli() {
		return dtposgmtocli;
	}
	public void setDtposgmtocli(String dtposgmtocli) {
		this.dtposgmtocli = dtposgmtocli;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getDprodtservc() {
		return dprodtservc;
	}
	public void setDprodtservc(String dprodtservc) {
		this.dprodtservc = dprodtservc;
	}

	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}
	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
	}

	public String getDmodldprodtcmbio() {
		return dmodldprodtcmbio;
	}
	public void setDmodldprodtcmbio(String dmodldprodtcmbio) {
		this.dmodldprodtcmbio = dmodldprodtcmbio;
	}

	public Integer getCtponegoccmbio() {
		return ctponegoccmbio;
	}
	public void setCtponegoccmbio(Integer ctponegoccmbio) {
		this.ctponegoccmbio = ctponegoccmbio;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getDsitbletocmbio() {
		return dsitbletocmbio;
	}
	public void setDsitbletocmbio(String dsitbletocmbio) {
		this.dsitbletocmbio = dsitbletocmbio;
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

	public String getDvalddnegoccmbio() {
		return dvalddnegoccmbio;
	}
	public void setDvalddnegoccmbio(String dvalddnegoccmbio) {
		this.dvalddnegoccmbio = dvalddnegoccmbio;
	}

	public String getCusuarinclt() {
		return cusuarinclt;
	}
	public void setCusuarinclt(String cusuarinclt) {
		this.cusuarinclt = cusuarinclt;
	}

	public String getNusuarinclt() {
		return nusuarinclt;
	}
	public void setNusuarinclt(String nusuarinclt) {
		this.nusuarinclt = nusuarinclt;
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

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getSimbleconmmoeda() {
		return simbleconmmoeda;
	}
	public void setSimbleconmmoeda(String simbleconmmoeda) {
		this.simbleconmmoeda = simbleconmmoeda;
	}

	public String getDescreconmmoeda() {
		return descreconmmoeda;
	}
	public void setDescreconmmoeda(String descreconmmoeda) {
		this.descreconmmoeda = descreconmmoeda;
	}

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public Integer getCeconmmoedadsemb() {
		return ceconmmoedadsemb;
	}
	public void setCeconmmoedadsemb(Integer ceconmmoedadsemb) {
		this.ceconmmoedadsemb = ceconmmoedadsemb;
	}

	public String getSimbleconmdsemb() {
		return simbleconmdsemb;
	}
	public void setSimbleconmdsemb(String simbleconmdsemb) {
		this.simbleconmdsemb = simbleconmdsemb;
	}

	public String getDescreconmdsemb() {
		return descreconmdsemb;
	}
	public void setDescreconmdsemb(String descreconmdsemb) {
		this.descreconmdsemb = descreconmdsemb;
	}

	public String getDprevtgarntexpdi() {
		return dprevtgarntexpdi;
	}
	public void setDprevtgarntexpdi(String dprevtgarntexpdi) {
		this.dprevtgarntexpdi = dprevtgarntexpdi;
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

	public Integer getCeconmmoedalim() {
		return ceconmmoedalim;
	}
	public void setCeconmmoedalim(Integer ceconmmoedalim) {
		this.ceconmmoedalim = ceconmmoedalim;
	}

	public String getSimbleconmlim() {
		return simbleconmlim;
	}
	public void setSimbleconmlim(String simbleconmlim) {
		this.simbleconmlim = simbleconmlim;
	}

	public String getDescreconmlim() {
		return descreconmlim;
	}
	public void setDescreconmlim(String descreconmlim) {
		this.descreconmlim = descreconmlim;
	}

	public String getVmoedalimgerc() {
		return vmoedalimgerc;
	}
	public void setVmoedalimgerc(String vmoedalimgerc) {
		this.vmoedalimgerc = vmoedalimgerc;
	}

	public Integer getTdiavalddletra() {
		return tdiavalddletra;
	}
	public void setTdiavalddletra(Integer tdiavalddletra) {
		this.tdiavalddletra = tdiavalddletra;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public Long getCbanqrcmbiofndng() {
		return cbanqrcmbiofndng;
	}
	public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
		this.cbanqrcmbiofndng = cbanqrcmbiofndng;
	}

	public String getDbcoextcmbio() {
		return dbcoextcmbio;
	}
	public void setDbcoextcmbio(String dbcoextcmbio) {
		this.dbcoextcmbio = dbcoextcmbio;
	}

	public String getPraca() {
		return praca;
	}
	public void setPraca(String praca) {
		this.praca = praca;
	}

	public Long getCbanqrcmbiorcdor() {
		return cbanqrcmbiorcdor;
	}
	public void setCbanqrcmbiorcdor(Long cbanqrcmbiorcdor) {
		this.cbanqrcmbiorcdor = cbanqrcmbiorcdor;
	}

	public String getDbcoreembolsador() {
		return dbcoreembolsador;
	}
	public void setDbcoreembolsador(String dbcoreembolsador) {
		this.dbcoreembolsador = dbcoreembolsador;
	}

	public String getPracareembolsador() {
		return pracareembolsador;
	}
	public void setPracareembolsador(String pracareembolsador) {
		this.pracareembolsador = pracareembolsador;
	}

	public Integer getTdiacmbioprcf() {
		return tdiacmbioprcf;
	}
	public void setTdiacmbioprcf(Integer tdiacmbioprcf) {
		this.tdiacmbioprcf = tdiacmbioprcf;
	}

	public String getDcotacfndngcmbio() {
		return dcotacfndngcmbio;
	}
	public void setDcotacfndngcmbio(String dcotacfndngcmbio) {
		this.dcotacfndngcmbio = dcotacfndngcmbio;
	}

	public String getPtxfixacmbio() {
		return ptxfixacmbio;
	}
	public void setPtxfixacmbio(String ptxfixacmbio) {
		this.ptxfixacmbio = ptxfixacmbio;
	}

	public Integer getCindcdeconmlibor() {
		return cindcdeconmlibor;
	}
	public void setCindcdeconmlibor(Integer cindcdeconmlibor) {
		this.cindcdeconmlibor = cindcdeconmlibor;
	}

	public String getSimbleconmlibor() {
		return simbleconmlibor;
	}
	public void setSimbleconmlibor(String simbleconmlibor) {
		this.simbleconmlibor = simbleconmlibor;
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

	public String getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(String vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
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

	public String getVmultanegoccmbio() {
		return vmultanegoccmbio;
	}
	public void setVmultanegoccmbio(String vmultanegoccmbio) {
		this.vmultanegoccmbio = vmultanegoccmbio;
	}

	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}

	public String getDmodcontrcmbio() {
		return dmodcontrcmbio;
	}
	public void setDmodcontrcmbio(String dmodcontrcmbio) {
		this.dmodcontrcmbio = dmodcontrcmbio;
	}

	public String getCustototal() {
		return custototal;
	}
	public void setCustototal(String custototal) {
		this.custototal = custototal;
	}

	public String getVtxspreadaprov() {
		return vtxspreadaprov;
	}
	public void setVtxspreadaprov(String vtxspreadaprov) {
		this.vtxspreadaprov = vtxspreadaprov;
	}

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public String getValorjuros() {
		return valorjuros;
	}
	public void setValorjuros(String valorjuros) {
		this.valorjuros = valorjuros;
	}

	public String getValorsaque() {
		return valorsaque;
	}
	public void setValorsaque(String valorsaque) {
		this.valorsaque = valorsaque;
	}

	public String getTaxajuros() {
		return taxajuros;
	}
	public void setTaxajuros(String taxajuros) {
		this.taxajuros = taxajuros;
	}

	public String getTaxadescontada() {
		return taxadescontada;
	}
	public void setTaxadescontada(String taxadescontada) {
		this.taxadescontada = taxadescontada;
	}

	public Integer getCtpojurotrade() {
		return ctpojurotrade;
	}
	public void setCtpojurotrade(Integer ctpojurotrade) {
		this.ctpojurotrade = ctpojurotrade;
	}

	public Long getCunicpssoacmbiot() {
		return cunicpssoacmbiot;
	}
	public void setCunicpssoacmbiot(Long cunicpssoacmbiot) {
		this.cunicpssoacmbiot = cunicpssoacmbiot;
	}

	public String getNcunicpsoacmbiot() {
		return ncunicpsoacmbiot;
	}
	public void setNcunicpsoacmbiot(String ncunicpsoacmbiot) {
		this.ncunicpsoacmbiot = ncunicpsoacmbiot;
	}

	public String getCcobrcomisadcio() {
		return ccobrcomisadcio;
	}
	public void setCcobrcomisadcio(String ccobrcomisadcio) {
		this.ccobrcomisadcio = ccobrcomisadcio;
	}

	public String getPcobervarprodt() {
		return pcobervarprodt;
	}
	public void setPcobervarprodt(String pcobervarprodt) {
		this.pcobervarprodt = pcobervarprodt;
	}

	public String getCmovtcincel() {
		return cmovtcincel;
	}
	public void setCmovtcincel(String cmovtcincel) {
		this.cmovtcincel = cmovtcincel;
	}

	public String getRrtinglvgemdnhe() {
		return rrtinglvgemdnhe;
	}
	public void setRrtinglvgemdnhe(String rrtinglvgemdnhe) {
		this.rrtinglvgemdnhe = rrtinglvgemdnhe;
	}

	public String getPercreentrg() {
		return percreentrg;
	}
	public void setPercreentrg(String percreentrg) {
		this.percreentrg = percreentrg;
	}

	public String getRclasfexportentrg() {
		return rclasfexportentrg;
	}
	public void setRclasfexportentrg(String rclasfexportentrg) {
		this.rclasfexportentrg = rclasfexportentrg;
	}

	public String getPercdientrg() {
		return percdientrg;
	}
	public void setPercdientrg(String percdientrg) {
		this.percdientrg = percdientrg;
	}

	public String getRclasfimportentrg() {
		return rclasfimportentrg;
	}
	public void setRclasfimportentrg(String rclasfimportentrg) {
		this.rclasfimportentrg = rclasfimportentrg;
	}

	public Integer getCindcdcontrfalt() {
		return cindcdcontrfalt;
	}
	public void setCindcdcontrfalt(Integer cindcdcontrfalt) {
		this.cindcdcontrfalt = cindcdcontrfalt;
	}

	public String getDabertctacli() {
		return dabertctacli;
	}
	public void setDabertctacli(String dabertctacli) {
		this.dabertctacli = dabertctacli;
	}

	public String getDfundcnasc() {
		return dfundcnasc;
	}
	public void setDfundcnasc(String dfundcnasc) {
		this.dfundcnasc = dfundcnasc;
	}

	public Integer getQdiavencdcontr() {
		return qdiavencdcontr;
	}
	public void setQdiavencdcontr(Integer qdiavencdcontr) {
		this.qdiavencdcontr = qdiavencdcontr;
	}

	public Integer getQcontrdoctopend() {
		return qcontrdoctopend;
	}
	public void setQcontrdoctopend(Integer qcontrdoctopend) {
		this.qcontrdoctopend = qcontrdoctopend;
	}

	public String getDfchtobletodesc() {
		return dfchtobletodesc;
	}
	public void setDfchtobletodesc(String dfchtobletodesc) {
		this.dfchtobletodesc = dfchtobletodesc;
	}

	public String getCprodtdesc() {
		return cprodtdesc;
	}
	public void setCprodtdesc(String cprodtdesc) {
		this.cprodtdesc = cprodtdesc;
	}

	public String getCmodldprodtdesc() {
		return cmodldprodtdesc;
	}
	public void setCmodldprodtdesc(String cmodldprodtdesc) {
		this.cmodldprodtdesc = cmodldprodtdesc;
	}

	public String getCeconmmoedadesc() {
		return ceconmmoedadesc;
	}
	public void setCeconmmoedadesc(String ceconmmoedadesc) {
		this.ceconmmoedadesc = ceconmmoedadesc;
	}

	public String getVlrmoedaestrang() {
		return vlrmoedaestrang;
	}
	public void setVlrmoedaestrang(String vlrmoedaestrang) {
		this.vlrmoedaestrang = vlrmoedaestrang;
	}

	public String getVtxrentbcmbio() {
		return vtxrentbcmbio;
	}
	public void setVtxrentbcmbio(String vtxrentbcmbio) {
		this.vtxrentbcmbio = vtxrentbcmbio;
	}

	public String getTxtinformativo() {
		return txtinformativo;
	}
	public void setTxtinformativo(String txtinformativo) {
		this.txtinformativo = txtinformativo;
	}

	public String getRinfoenvolmdia() {
		return rinfoenvolmdia;
	}
	public void setRinfoenvolmdia(String rinfoenvolmdia) {
		this.rinfoenvolmdia = rinfoenvolmdia;
	}

	public String getDinclreg() {
		return dinclreg;
	}
	public void setDinclreg(String dinclreg) {
		this.dinclreg = dinclreg;
	}

	public String getNomecompletocli() {
		return nomecompletocli;
	}
	public void setNomecompletocli(String nomecompletocli) {
		this.nomecompletocli = nomecompletocli;
	}

	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}
	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}

	public String getDlimembrqcmbio() {
		return dlimembrqcmbio;
	}
	public void setDlimembrqcmbio(String dlimembrqcmbio) {
		this.dlimembrqcmbio = dlimembrqcmbio;
	}

	public String getDlimfndngcmbio() {
		return dlimfndngcmbio;
	}
	public void setDlimfndngcmbio(String dlimfndngcmbio) {
		this.dlimfndngcmbio = dlimfndngcmbio;
	}

	public String getInddqmto() {
		return inddqmto;
	}
	public void setInddqmto(String inddqmto) {
		this.inddqmto = inddqmto;
	}

	public String getPareceroperador() {
		return pareceroperador;
	}
	public void setPareceroperador(String pareceroperador) {
		this.pareceroperador = pareceroperador;
	}

	public String getParecerdsn() {
		return parecerdsn;
	}
	public void setParecerdsn(String parecerdsn) {
		this.parecerdsn = parecerdsn;
	}

	public Integer getQtderest() {
		return qtderest;
	}
	public void setQtderest(Integer qtderest) {
		this.qtderest = qtderest;
	}

	public Integer getQtdepcelas() {
		return qtdepcelas;
	}
	public void setQtdepcelas(Integer qtdepcelas) {
		this.qtdepcelas = qtdepcelas;
	}

	public String getDescctotal() {
		return descctotal;
	}
	public void setDescctotal(String descctotal) {
		this.descctotal = descctotal;
	}

	public String getCindcdcartaidpdt() {
		return cindcdcartaidpdt;
	}
	public void setCindcdcartaidpdt(String cindcdcartaidpdt) {
		this.cindcdcartaidpdt = cindcdcartaidpdt;
	}

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}

	public String getDescjurobleto() {
		return descjurobleto;
	}
	public void setDescjurobleto(String descjurobleto) {
		this.descjurobleto = descjurobleto;
	}

	public String getComissaodsemblso() {
		return comissaodsemblso;
	}
	public void setComissaodsemblso(String comissaodsemblso) {
		this.comissaodsemblso = comissaodsemblso;
	}

	public String getVlrcomisdsemb() {
		return vlrcomisdsemb;
	}
	public void setVlrcomisdsemb(String vlrcomisdsemb) {
		this.vlrcomisdsemb = vlrcomisdsemb;
	}

	public String getVtxspreadtot() {
		return vtxspreadtot;
	}
	public void setVtxspreadtot(String vtxspreadtot) {
		this.vtxspreadtot = vtxspreadtot;
	}

	public List<Npccwx4sresponse_restricoes> getRestricoes() {
		return restricoes;
	}
	public void setRestricoes( List<Npccwx4sresponse_restricoes> restricoes) {
		this.restricoes = restricoes;
	}

	public List<Npccwx4sresponse_pcelasfndng> getPcelasfndng() {
		return pcelasfndng;
	}
	public void setPcelasfndng( List<Npccwx4sresponse_pcelasfndng> pcelasfndng) {
		this.pcelasfndng = pcelasfndng;
	}
    
}