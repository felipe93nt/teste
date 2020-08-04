package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos;

import java.util.List;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 31/07/18 09:11
 */
public class Npccwx1sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX1S-HEADER.NPCCWX1S-COD-LAYOUT")
	private String codlayout = "NPCCWX1S";

	@Adapter(transactionField = "NPCCWX1S-HEADER.NPCCWX1S-TAM-LAYOUT")
	private Integer tamlayout = 10355;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DINCL-REG")
	private String dinclreg = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NCUNIC-CLI-CMBIO")
	private String ncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TP-PESSOA")
	private String tppessoa = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CPF-CNPJ")
	private Integer cpfcnpj = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CFLIAL")
	private Integer cflial = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CCTRL")
	private Integer cctrl = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NCTA-BCRIA-CMBIO")
	private Integer nctabcriacmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CBCO")
	private Integer cbco = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NOME-SOCIAL")
	private String nomesocial = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CAG-BCRIA")
	private Integer cagbcria = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CCTA-BCRIA-CMBIO")
	private Long cctabcriacmbio = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DIGT-CCTA-BCRIA")
	private String digtcctabcria = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CIDADE")
	private String cidade = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-ESTADO")
	private String estado = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CPSSOA-JURID")
	private Long cpssoajurid = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NOME-UND-ORGNZ")
	private String nomeundorgnz = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CRTING")
	private String crting = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CADITV-BLETO-CMBIO")
	private Integer caditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DTPO-SGMTO-CLI")
	private String dtposgmtocli = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DPRODT-SERVC")
	private String dprodtservc = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DMODLD-PRODT-CMBIO")
	private String dmodldprodtcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CTPO-NEGOC-CMBIO")
	private Integer ctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DSIT-BLETO-CMBIO")
	private String dsitbletocmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DVALDD-NEGOC-CMBIO")
	private String dvalddnegoccmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CUSUAR-INCLT")
	private String cusuarinclt = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NUSUAR-INCLT")
	private String nusuarinclt = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-SIMBL-ECONM-MOEDA")
	private String simbleconmmoeda = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DESCR-ECONM-MOEDA")
	private String descreconmmoeda = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VNEGOC-MOEDA-ESTRG")
	private Double vnegocmoedaestrg = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CECONM-MOEDA-DSEMB")
	private Integer ceconmmoedadsemb = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-SIMBL-ECONM-DSEMB")
	private String simbleconmdsemb = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DESCR-ECONM-DSEMB")
	private String descreconmdsemb = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-SIMBL-ECONM-LIM")
	private String simbleconmlim = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DESCR-ECONM-LIM")
	private String descreconmlim = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VMOEDA-LIM-GERC")
	private Double vmoedalimgerc = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-NEGOC-SWAP")
	private String cindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-NEGOC-LIBOR")
	private String cindcdnegoclibor = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CNEGOC-SWAP-FLUXO")
	private String cnegocswapfluxo = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CNEGOC-SWAP-ESTRG")
	private String cnegocswapestrg = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CTPO-COTAC-TX")
	private Integer ctpocotactx = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PTX-SWAP-CMPDO")
	private Double ptxswapcmpdo = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-NEGOC-CARTA")
	private String cindcdnegoccarta = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TDIA-VALDD-LETRA")
	private Integer tdiavalddletra = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CCOMIS-CARTA-NACIO")
	private String ccomiscartanacio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-NEGOC-ARBTR")
	private String cindcdnegocarbtr = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CBANQR-CMBIO-FNDNG")
	private Long cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CBANQR-CMBIO-RCDOR")
	private Long cbanqrcmbiorcdor = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DBCO-EXT-CMBIO")
	private String dbcoextcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DBCO-RECEBEDOR")
	private String dbcorecebedor = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DBCO-CRED")
	private String dbcocred = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TDIA-CMBIO-PRCF")
	private Integer tdiacmbioprcf = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DCOTAC-FNDNG-CMBIO")
	private String dcotacfndngcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PTX-FIXA-CMBIO")
	private Double ptxfixacmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-ECONM-LIBOR")
	private Integer cindcdeconmlibor = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-SIMBL-ECONM-LIBOR")
	private String simbleconmlibor = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TMES-LIBOR-CMBIO")
	private Integer tmesliborcmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTX-LIBOR-CMBIO")
	private Double vtxliborcmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTRAVA-LIBOR-CMBIO")
	private Double vtravaliborcmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VIMPST-NEGOC-CMBIO")
	private Double vimpstnegoccmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VIOF-NEGOC-CMBIO")
	private Double viofnegoccmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTX-MORA-CMBIO")
	private Double vtxmoracmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTX-SPREAD-APROV")
	private Double vtxspreadaprov = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTX-SPREAD-NEGOC")
	private Double vtxspreadnegoc = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CBASE-JURO-MORA")
	private Integer cbasejuromora = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VMULTA-NEGOC-CMBIO")
	private Double vmultanegoccmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CSEGUR-TRNSP-MCADO")
	private String csegurtrnspmcado = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CSEGUR-MCADO-ORGNZ")
	private String csegurmcadoorgnz = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DMOD-CONTR-CMBIO")
	private String dmodcontrcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QPRZ-MED-CMBIO")
	private Integer qprzmedcmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QPRZ-MED-CMBIO-ANO")
	private Double qprzmedcmbioano = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CUSTO-TOTAL")
	private Double custototal = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DESC-CTOTAL")
	private String descctotal = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CUNIC-PSSOA-CMBIO-T")
	private Long cunicpssoacmbiot = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NCUNIC-PSOA-CMBIO-T")
	private String ncunicpsoacmbiot = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CUNIC-PSSOA-INDICA")
	private Long cunicpssoaindica = 0L;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DLIM-FNDNG-CMBIO")
	private String dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CMOVTC-INCEL")
	private String cmovtcincel = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-RRTING-LVGEM-DNHE")
	private String rrtinglvgemdnhe = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PERC-RE-ENTRG")
	private Double percreentrg = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-RCLASF-EXPORT-ENTRG")
	private String rclasfexportentrg = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PERC-DI-ENTRG")
	private Double percdientrg = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-RCLASF-IMPORT-ENTRG")
	private String rclasfimportentrg = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-CONTR-FALT")
	private Integer cindcdcontrfalt = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DABERT-CTA-CLI")
	private String dabertctacli = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DFUNDC-NASC")
	private String dfundcnasc = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QDIA-VENCD-CONTR")
	private Integer qdiavencdcontr = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QCONTR-DOCTO-PEND")
	private Integer qcontrdoctopend = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DFCHTO-BLETO-CMBIO")
	private String dfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DFCHTO-BLETO-DESC")
	private String dfchtobletodesc = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-IFLUXO-PERDC-CMBIO")
	private String ifluxoperdccmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CPRODT-DESC")
	private String cprodtdesc = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CMODLD-PRODT-DESC")
	private String cmodldprodtdesc = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CECONM-MOEDA-DESC")
	private String ceconmmoedadesc = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VLR-MOEDA-ESTRANG")
	private Double vlrmoedaestrang = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTX-RENTB-CMBIO")
	private String vtxrentbcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TXT-INFORMATIVO")
	private String txtinformativo = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-RINFO-ENVOL-MDIA")
	private String rinfoenvolmdia = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PARECER-OPERADOR")
	private String pareceroperador = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PARECER-DSN")
	private String parecerdsn = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PTX-EQUAL-CMBIO")
	private Double ptxequalcmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CECONM-MOEDA-EQUAL")
	private Integer ceconmmoedaequal = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-SIMBL-MOEDA-EQUAL")
	private String simblmoedaequal = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VPREVT-CMBIO-EQUAL")
	private Double vprevtcmbioequal = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CMOEDA-ECONM-RECTA")
	private Integer cmoedaeconmrecta = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-SIMBL-RECTA-CMBIO")
	private String simblrectacmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VPREVT-RECTA-CMBIO")
	private Double vprevtrectacmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DINIC-VALDD-CMBIO")
	private String dinicvalddcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DFIM-NEGOC-CMBIO")
	private String dfimnegoccmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CIDTFD-BNDES-PORTE")
	private Integer cidtfdbndesporte = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PJURO-NEGOC-CMBIO")
	private Double pjuronegoccmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PAGTE-FINCR-CMBIO")
	private Double pagtefincrcmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTX-REMUN-BNDES")
	private Double vtxremunbndes = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CIDTFD-BNDES-GRP")
	private Integer cidtfdbndesgrp = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PTOT-JURO-CMBIO")
	private Double ptotjurocmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TDIA-CAREN-PRINC")
	private Integer tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CFLUXO-PERDC-CMBIO")
	private Integer cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCOMIS-MTORI-CMBIO")
	private Double pcomismtoricmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DPREVT-INIC-EMBRQ")
	private String dprevtinicembrq = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DPREVT-FIM-EMBRQ")
	private String dprevtfimembrq = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CCOBR-COMIS-MTORI")
	private Integer ccobrcomismtori = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CCOBR-COMIS-AGTE")
	private Integer ccobrcomisagte = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DVCTO-CNTRA-GARNT")
	private String dvctocntragarnt = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QREG-EXPOR-CMBIO")
	private Integer qregexporcmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QPREVT-EMBRQ-CMBIO")
	private Integer qprevtembrqcmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VAGTE-FINCR-CMBIO")
	private Double vagtefincrcmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VBCO-MTORI-CMBIO")
	private Double vbcomtoricmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-INFO-COMPL-BNDES")
	private String infocomplbndes = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-ECON")
	private Integer cindcdecon = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCDI-MAIS-CMBIO")
	private Double pcdimaiscmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PTX-CDI-FINAN")
	private Double ptxcdifinan = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PFIXA-JURO-CMBIO")
	private Double pfixajurocmbio = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-LASTR-AGRIC")
	private String cindcdlastragric = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-IORG-EXTER-CMBIO")
	private String iorgextercmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-LASTR-CARTA")
	private String cindcdlastrcarta = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CPERM-TRNSF-CARTA")
	private String cpermtrnsfcarta = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-CARTA-CNFDO")
	private String cindcdcartacnfdo = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-CARTA-IDPDT")
	private String cindcdcartaidpdt = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CCARTA-CONVE-RECDD")
	private String ccartaconverecdd = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DVCTO-DSEMB-CMBIO")
	private String dvctodsembcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QPCELA-TRADE-PRINC")
	private Integer qpcelatradeprinc = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VLIM-COBER-VAR")
	private Double vlimcobervar = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CPRZ-NEGOC-CMBIO")
	private Integer cprznegoccmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DLIM-EMBRQ-CMBIO")
	private String dlimembrqcmbio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VALDD-CARTA")
	private Integer valddcarta = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-EMBRQ-PCIAL")
	private String cindcdembrqpcial = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CIDTFD-CARTA-CSNDO")
	private Integer cidtfdcartacsndo = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DPREVT-GARNT-EXPDI")
	private String dprevtgarntexpdi = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CNEGOC-CMBIO-INDMD")
	private String cnegoccmbioindmd = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CTPO-JURO-TRADE")
	private Integer ctpojurotrade = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CCOBR-COMIS-ADCIO")
	private String ccobrcomisadcio = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCOBER-VAR-PRODT")
	private String pcobervarprodt = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VALOR-JUROS")
	private String valorjuros = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VALOR-SAQUE")
	private String valorsaque = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TAXA-JUROS")
	private String taxajuros = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TAXA-DESCONTADA")
	private String taxadescontada = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-CNTRA-GARNT")
	private String cindcdcntragarnt = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-TDIA-CNTRA-GARNT")
	private Integer tdiacntragarnt = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DABERT-CNTRA-GARNT")
	private String dabertcntragarnt = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-RENOV-CNTRA")
	private String cindcdrenovcntra = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QDIA-ALERT-CNTRA")
	private Integer qdiaalertcntra = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DALERT-VCTO-CNTRA")
	private String dalertvctocntra = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CINDCD-CUSTO-EXTER")
	private String cindcdcustoexter = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CIDTFD-RESP-DESP")
	private Integer cidtfdrespdesp = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-ENDERECO")
	private String endereco = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PAIS")
	private String pais = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-IND-DQMTO")
	private String inddqmto = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-NOME-COMPLETO-CLI")
	private String nomecompletocli = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QTDE-REST")
	private Integer qtderest = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-QTDE-PCELAS")
	private Integer qtdepcelas = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DLIM-ENVIO-RSUMO")
	private String dlimenviorsumo = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DINIC-VALDD-PPSTA")
	private String dinicvalddppsta = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DFIM-VALDD-PPSTA")
	private String dfimvalddppsta = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PRACA")
	private String praca = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-VTX-SPREAD-TOT")
	private Double vtxspreadtot = 0D;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-DESC-JUROS-BLETO")
	private String descjurosbleto = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-CTPO-PRZ-CMBIO")
	private Integer ctpoprzcmbio = 0;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-RESTRICOES", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Npccwx1sresponse_restricoes")
	private List<Npccwx1sresponse_restricoes> restricoes = null;

	@Adapter(transactionField = "NPCCWX1S-REGISTRO.NPCCWX1S-PCELAS-FNDNG", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos.Npccwx1sresponse_pcelasfndng")
	private List<Npccwx1sresponse_pcelasfndng> pcelasfndng = null;
	
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

	public String getDinclreg() {
		return dinclreg;
	}
	public void setDinclreg(String dinclreg) {
		this.dinclreg = dinclreg;
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

	public Integer getCaditvbletocmbio() {
		return caditvbletocmbio;
	}
	public void setCaditvbletocmbio(Integer caditvbletocmbio) {
		this.caditvbletocmbio = caditvbletocmbio;
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

	public Double getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(Double vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
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

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
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

	public Double getVmoedalimgerc() {
		return vmoedalimgerc;
	}
	public void setVmoedalimgerc(Double vmoedalimgerc) {
		this.vmoedalimgerc = vmoedalimgerc;
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

	public Double getPtxswapcmpdo() {
		return ptxswapcmpdo;
	}
	public void setPtxswapcmpdo(Double ptxswapcmpdo) {
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

	public String getDbcoextcmbio() {
		return dbcoextcmbio;
	}
	public void setDbcoextcmbio(String dbcoextcmbio) {
		this.dbcoextcmbio = dbcoextcmbio;
	}

	public String getDbcorecebedor() {
		return dbcorecebedor;
	}
	public void setDbcorecebedor(String dbcorecebedor) {
		this.dbcorecebedor = dbcorecebedor;
	}

	public String getDbcocred() {
		return dbcocred;
	}
	public void setDbcocred(String dbcocred) {
		this.dbcocred = dbcocred;
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

	public Double getPtxfixacmbio() {
		return ptxfixacmbio;
	}
	public void setPtxfixacmbio(Double ptxfixacmbio) {
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

	public Double getVtxliborcmbio() {
		return vtxliborcmbio;
	}
	public void setVtxliborcmbio(Double vtxliborcmbio) {
		this.vtxliborcmbio = vtxliborcmbio;
	}

	public Double getVtravaliborcmbio() {
		return vtravaliborcmbio;
	}
	public void setVtravaliborcmbio(Double vtravaliborcmbio) {
		this.vtravaliborcmbio = vtravaliborcmbio;
	}

	public Double getVimpstnegoccmbio() {
		return vimpstnegoccmbio;
	}
	public void setVimpstnegoccmbio(Double vimpstnegoccmbio) {
		this.vimpstnegoccmbio = vimpstnegoccmbio;
	}

	public Double getViofnegoccmbio() {
		return viofnegoccmbio;
	}
	public void setViofnegoccmbio(Double viofnegoccmbio) {
		this.viofnegoccmbio = viofnegoccmbio;
	}

	public Double getVtxmoracmbio() {
		return vtxmoracmbio;
	}
	public void setVtxmoracmbio(Double vtxmoracmbio) {
		this.vtxmoracmbio = vtxmoracmbio;
	}

	public Double getVtxspreadaprov() {
		return vtxspreadaprov;
	}
	public void setVtxspreadaprov(Double vtxspreadaprov) {
		this.vtxspreadaprov = vtxspreadaprov;
	}

	public Double getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(Double vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public Integer getCbasejuromora() {
		return cbasejuromora;
	}
	public void setCbasejuromora(Integer cbasejuromora) {
		this.cbasejuromora = cbasejuromora;
	}

	public Double getVmultanegoccmbio() {
		return vmultanegoccmbio;
	}
	public void setVmultanegoccmbio(Double vmultanegoccmbio) {
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

	public String getDmodcontrcmbio() {
		return dmodcontrcmbio;
	}
	public void setDmodcontrcmbio(String dmodcontrcmbio) {
		this.dmodcontrcmbio = dmodcontrcmbio;
	}

	public Integer getQprzmedcmbio() {
		return qprzmedcmbio;
	}
	public void setQprzmedcmbio(Integer qprzmedcmbio) {
		this.qprzmedcmbio = qprzmedcmbio;
	}

	public Double getQprzmedcmbioano() {
		return qprzmedcmbioano;
	}
	public void setQprzmedcmbioano(Double qprzmedcmbioano) {
		this.qprzmedcmbioano = qprzmedcmbioano;
	}

	public Double getCustototal() {
		return custototal;
	}
	public void setCustototal(Double custototal) {
		this.custototal = custototal;
	}

	public String getDescctotal() {
		return descctotal;
	}
	public void setDescctotal(String descctotal) {
		this.descctotal = descctotal;
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

	public Long getCunicpssoaindica() {
		return cunicpssoaindica;
	}
	public void setCunicpssoaindica(Long cunicpssoaindica) {
		this.cunicpssoaindica = cunicpssoaindica;
	}

	public String getDlimfndngcmbio() {
		return dlimfndngcmbio;
	}
	public void setDlimfndngcmbio(String dlimfndngcmbio) {
		this.dlimfndngcmbio = dlimfndngcmbio;
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

	public Double getPercreentrg() {
		return percreentrg;
	}
	public void setPercreentrg(Double percreentrg) {
		this.percreentrg = percreentrg;
	}

	public String getRclasfexportentrg() {
		return rclasfexportentrg;
	}
	public void setRclasfexportentrg(String rclasfexportentrg) {
		this.rclasfexportentrg = rclasfexportentrg;
	}

	public Double getPercdientrg() {
		return percdientrg;
	}
	public void setPercdientrg(Double percdientrg) {
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

	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}
	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}

	public String getDfchtobletodesc() {
		return dfchtobletodesc;
	}
	public void setDfchtobletodesc(String dfchtobletodesc) {
		this.dfchtobletodesc = dfchtobletodesc;
	}

	public String getIfluxoperdccmbio() {
		return ifluxoperdccmbio;
	}
	public void setIfluxoperdccmbio(String ifluxoperdccmbio) {
		this.ifluxoperdccmbio = ifluxoperdccmbio;
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

	public Double getVlrmoedaestrang() {
		return vlrmoedaestrang;
	}
	public void setVlrmoedaestrang(Double vlrmoedaestrang) {
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

	public Double getPtxequalcmbio() {
		return ptxequalcmbio;
	}
	public void setPtxequalcmbio(Double ptxequalcmbio) {
		this.ptxequalcmbio = ptxequalcmbio;
	}

	public Integer getCeconmmoedaequal() {
		return ceconmmoedaequal;
	}
	public void setCeconmmoedaequal(Integer ceconmmoedaequal) {
		this.ceconmmoedaequal = ceconmmoedaequal;
	}

	public String getSimblmoedaequal() {
		return simblmoedaequal;
	}
	public void setSimblmoedaequal(String simblmoedaequal) {
		this.simblmoedaequal = simblmoedaequal;
	}

	public Double getVprevtcmbioequal() {
		return vprevtcmbioequal;
	}
	public void setVprevtcmbioequal(Double vprevtcmbioequal) {
		this.vprevtcmbioequal = vprevtcmbioequal;
	}

	public Integer getCmoedaeconmrecta() {
		return cmoedaeconmrecta;
	}
	public void setCmoedaeconmrecta(Integer cmoedaeconmrecta) {
		this.cmoedaeconmrecta = cmoedaeconmrecta;
	}

	public String getSimblrectacmbio() {
		return simblrectacmbio;
	}
	public void setSimblrectacmbio(String simblrectacmbio) {
		this.simblrectacmbio = simblrectacmbio;
	}

	public Double getVprevtrectacmbio() {
		return vprevtrectacmbio;
	}
	public void setVprevtrectacmbio(Double vprevtrectacmbio) {
		this.vprevtrectacmbio = vprevtrectacmbio;
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

	public Integer getCidtfdbndesporte() {
		return cidtfdbndesporte;
	}
	public void setCidtfdbndesporte(Integer cidtfdbndesporte) {
		this.cidtfdbndesporte = cidtfdbndesporte;
	}

	public Double getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(Double pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public Double getPagtefincrcmbio() {
		return pagtefincrcmbio;
	}
	public void setPagtefincrcmbio(Double pagtefincrcmbio) {
		this.pagtefincrcmbio = pagtefincrcmbio;
	}

	public Double getVtxremunbndes() {
		return vtxremunbndes;
	}
	public void setVtxremunbndes(Double vtxremunbndes) {
		this.vtxremunbndes = vtxremunbndes;
	}

	public Integer getCidtfdbndesgrp() {
		return cidtfdbndesgrp;
	}
	public void setCidtfdbndesgrp(Integer cidtfdbndesgrp) {
		this.cidtfdbndesgrp = cidtfdbndesgrp;
	}

	public Double getPtotjurocmbio() {
		return ptotjurocmbio;
	}
	public void setPtotjurocmbio(Double ptotjurocmbio) {
		this.ptotjurocmbio = ptotjurocmbio;
	}

	public Integer getTdiacarenprinc() {
		return tdiacarenprinc;
	}
	public void setTdiacarenprinc(Integer tdiacarenprinc) {
		this.tdiacarenprinc = tdiacarenprinc;
	}

	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}

	public Double getPcomismtoricmbio() {
		return pcomismtoricmbio;
	}
	public void setPcomismtoricmbio(Double pcomismtoricmbio) {
		this.pcomismtoricmbio = pcomismtoricmbio;
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

	public Integer getCcobrcomismtori() {
		return ccobrcomismtori;
	}
	public void setCcobrcomismtori(Integer ccobrcomismtori) {
		this.ccobrcomismtori = ccobrcomismtori;
	}

	public Integer getCcobrcomisagte() {
		return ccobrcomisagte;
	}
	public void setCcobrcomisagte(Integer ccobrcomisagte) {
		this.ccobrcomisagte = ccobrcomisagte;
	}

	public String getDvctocntragarnt() {
		return dvctocntragarnt;
	}
	public void setDvctocntragarnt(String dvctocntragarnt) {
		this.dvctocntragarnt = dvctocntragarnt;
	}

	public Integer getQregexporcmbio() {
		return qregexporcmbio;
	}
	public void setQregexporcmbio(Integer qregexporcmbio) {
		this.qregexporcmbio = qregexporcmbio;
	}

	public Integer getQprevtembrqcmbio() {
		return qprevtembrqcmbio;
	}
	public void setQprevtembrqcmbio(Integer qprevtembrqcmbio) {
		this.qprevtembrqcmbio = qprevtembrqcmbio;
	}

	public Double getVagtefincrcmbio() {
		return vagtefincrcmbio;
	}
	public void setVagtefincrcmbio(Double vagtefincrcmbio) {
		this.vagtefincrcmbio = vagtefincrcmbio;
	}

	public Double getVbcomtoricmbio() {
		return vbcomtoricmbio;
	}
	public void setVbcomtoricmbio(Double vbcomtoricmbio) {
		this.vbcomtoricmbio = vbcomtoricmbio;
	}

	public String getInfocomplbndes() {
		return infocomplbndes;
	}
	public void setInfocomplbndes(String infocomplbndes) {
		this.infocomplbndes = infocomplbndes;
	}

	public Integer getCindcdecon() {
		return cindcdecon;
	}
	public void setCindcdecon(Integer cindcdecon) {
		this.cindcdecon = cindcdecon;
	}

	public Double getPcdimaiscmbio() {
		return pcdimaiscmbio;
	}
	public void setPcdimaiscmbio(Double pcdimaiscmbio) {
		this.pcdimaiscmbio = pcdimaiscmbio;
	}

	public Double getPtxcdifinan() {
		return ptxcdifinan;
	}
	public void setPtxcdifinan(Double ptxcdifinan) {
		this.ptxcdifinan = ptxcdifinan;
	}

	public Double getPfixajurocmbio() {
		return pfixajurocmbio;
	}
	public void setPfixajurocmbio(Double pfixajurocmbio) {
		this.pfixajurocmbio = pfixajurocmbio;
	}

	public String getCindcdlastragric() {
		return cindcdlastragric;
	}
	public void setCindcdlastragric(String cindcdlastragric) {
		this.cindcdlastragric = cindcdlastragric;
	}

	public String getIorgextercmbio() {
		return iorgextercmbio;
	}
	public void setIorgextercmbio(String iorgextercmbio) {
		this.iorgextercmbio = iorgextercmbio;
	}

	public String getCindcdlastrcarta() {
		return cindcdlastrcarta;
	}
	public void setCindcdlastrcarta(String cindcdlastrcarta) {
		this.cindcdlastrcarta = cindcdlastrcarta;
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

	public String getDvctodsembcmbio() {
		return dvctodsembcmbio;
	}
	public void setDvctodsembcmbio(String dvctodsembcmbio) {
		this.dvctodsembcmbio = dvctodsembcmbio;
	}

	public Integer getQpcelatradeprinc() {
		return qpcelatradeprinc;
	}
	public void setQpcelatradeprinc(Integer qpcelatradeprinc) {
		this.qpcelatradeprinc = qpcelatradeprinc;
	}

	public Double getVlimcobervar() {
		return vlimcobervar;
	}
	public void setVlimcobervar(Double vlimcobervar) {
		this.vlimcobervar = vlimcobervar;
	}

	public Integer getCprznegoccmbio() {
		return cprznegoccmbio;
	}
	public void setCprznegoccmbio(Integer cprznegoccmbio) {
		this.cprznegoccmbio = cprznegoccmbio;
	}

	public String getDlimembrqcmbio() {
		return dlimembrqcmbio;
	}
	public void setDlimembrqcmbio(String dlimembrqcmbio) {
		this.dlimembrqcmbio = dlimembrqcmbio;
	}

	public Integer getValddcarta() {
		return valddcarta;
	}
	public void setValddcarta(Integer valddcarta) {
		this.valddcarta = valddcarta;
	}

	public String getCindcdembrqpcial() {
		return cindcdembrqpcial;
	}
	public void setCindcdembrqpcial(String cindcdembrqpcial) {
		this.cindcdembrqpcial = cindcdembrqpcial;
	}

	public Integer getCidtfdcartacsndo() {
		return cidtfdcartacsndo;
	}
	public void setCidtfdcartacsndo(Integer cidtfdcartacsndo) {
		this.cidtfdcartacsndo = cidtfdcartacsndo;
	}

	public String getDprevtgarntexpdi() {
		return dprevtgarntexpdi;
	}
	public void setDprevtgarntexpdi(String dprevtgarntexpdi) {
		this.dprevtgarntexpdi = dprevtgarntexpdi;
	}

	public String getCnegoccmbioindmd() {
		return cnegoccmbioindmd;
	}
	public void setCnegoccmbioindmd(String cnegoccmbioindmd) {
		this.cnegoccmbioindmd = cnegoccmbioindmd;
	}

	public Integer getCtpojurotrade() {
		return ctpojurotrade;
	}
	public void setCtpojurotrade(Integer ctpojurotrade) {
		this.ctpojurotrade = ctpojurotrade;
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

	public Integer getCidtfdrespdesp() {
		return cidtfdrespdesp;
	}
	public void setCidtfdrespdesp(Integer cidtfdrespdesp) {
		this.cidtfdrespdesp = cidtfdrespdesp;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getInddqmto() {
		return inddqmto;
	}
	public void setInddqmto(String inddqmto) {
		this.inddqmto = inddqmto;
	}

	public String getNomecompletocli() {
		return nomecompletocli;
	}
	public void setNomecompletocli(String nomecompletocli) {
		this.nomecompletocli = nomecompletocli;
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

	public String getPraca() {
		return praca;
	}
	public void setPraca(String praca) {
		this.praca = praca;
	}

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}

	public Double getVtxspreadtot() {
		return vtxspreadtot;
	}
	public void setVtxspreadtot(Double vtxspreadtot) {
		this.vtxspreadtot = vtxspreadtot;
	}

	public String getDescjurosbleto() {
		return descjurosbleto;
	}
	public void setDescjurosbleto(String descjurosbleto) {
		this.descjurosbleto = descjurosbleto;
	}

	public Integer getCtpoprzcmbio() {
		return ctpoprzcmbio;
	}
	public void setCtpoprzcmbio(Integer ctpoprzcmbio) {
		this.ctpoprzcmbio = ctpoprzcmbio;
	}

	public List<Npccwx1sresponse_restricoes> getRestricoes() {
		return restricoes;
	}
	public void setRestricoes( List<Npccwx1sresponse_restricoes> restricoes) {
		this.restricoes = restricoes;
	}

	public List<Npccwx1sresponse_pcelasfndng> getPcelasfndng() {
		return pcelasfndng;
	}
	public void setPcelasfndng( List<Npccwx1sresponse_pcelasfndng> pcelasfndng) {
		this.pcelasfndng = pcelasfndng;
	}
    
}