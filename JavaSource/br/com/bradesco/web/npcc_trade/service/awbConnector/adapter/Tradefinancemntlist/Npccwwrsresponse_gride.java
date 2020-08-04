package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/07/16 15:26
 */
public class Npccwwrsresponse_gride extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CSIT-BLETO-CMBIO")
	private Integer gride_scsitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DSIT-BLETO-CMBIO")
	private String gride_sdsitbletocmbio = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CSIT-BLETO-APROV")
	private Integer gride_scsitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DT-COTACAO")
	private String gride_sdtcotacao = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CUSUAR-INCLT")
	private String gride_scusuarinclt = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-NUSUAR-INCLT")
	private String gride_snusuarinclt = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-NBLETO-CMBIO-ANO")
	private Long gride_snbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-NBLETO-NEGOC-CMBIO")
	private Long gride_snbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CUNIC-CLI-CMBIO")
	private Long gride_scunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-NCUNIC-CLI-CMBIO")
	private String gride_sncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-TP-PESSOA")
	private String gride_stppessoa = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CPF-CNPJ")
	private Integer gride_scpfcnpj = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CFLIAL")
	private Integer gride_scflial = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CCTRL")
	private Integer gride_scctrl = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CTPO-SGMTO-CLI")
	private Integer gride_sctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DTPO-SGMTO-CLI")
	private String gride_sdtposgmtocli = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CTPO-NEGOC-CMBIO")
	private Integer gride_sctponegoccmbio = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-NSEQ-UND-ORGNZ")
	private Integer gride_snsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-NOME-UND-ORGNZ")
	private String gride_snomeundorgnz = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-AG-CMRCL")
	private Integer gride_sagcmrcl = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CPRODT-SERVC")
	private Integer gride_scprodtservc = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DPRODT-SERVC")
	private String gride_sdprodtservc = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CMODLD-PRODT-CMBIO")
	private Integer gride_scmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CMODLD-PRODT-DESC")
	private String gride_scmodldprodtdesc = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CINDCD-ECONM-MOEDA")
	private Integer gride_scindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-SIMBL-ECONM-MOEDA")
	private String gride_ssimbleconmmoeda = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-VLR-MOEDA-ESTRANG")
	private String gride_svlrmoedaestrang = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-VLR-EQVLNTE-DOLAR")
	private String gride_svlreqvlntedolar = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CINDCD-NEGOC-SWAP")
	private String gride_scindcdnegocswap = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-TDIA-OPER-CMBIO")
	private Integer gride_stdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-QPRZ-MED-CMBIO")
	private Integer gride_sqprzmedcmbio = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-NSEQ-CONTR-LIM")
	private Long gride_snseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-VTX-SPREAD-APROV")
	private String gride_svtxspreadaprov = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CUSTO")
	private String gride_scusto = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-VTX-SPREAD-NEGOC")
	private String gride_svtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-PTX-SWAP-CMPDO")
	private String gride_sptxswapcmpdo = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-SPREAD-DOLAR")
	private String gride_sspreaddolar = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CBCO-EXT-CMBIO")
	private Long gride_scbcoextcmbio = 0L;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DBCO-EXT-CMBIO")
	private String gride_sdbcoextcmbio = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DFCHTO-BLETO-CMBIO")
	private String gride_sdfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CADITV-BLETO-CMBIO")
	private Integer gride_scaditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CPAIS")
	private Integer gride_scpais = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DPAIS")
	private String gride_sdpais = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CPAIS-EMBRQ")
	private Integer gride_scpaisembrq = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-DPAIS-EMBRQ")
	private String gride_sdpaisembrq = null;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE.NPCCWWRS-S-CMOD-CONTR-CMBIO")
	private Integer gride_scmodcontrcmbio = 0;
	
	public Integer getGride_scsitbletocmbio() {
		return gride_scsitbletocmbio;
	}
	public void setGride_scsitbletocmbio(Integer gride_scsitbletocmbio) {
		this.gride_scsitbletocmbio = gride_scsitbletocmbio;
	}

	public String getGride_sdsitbletocmbio() {
		return gride_sdsitbletocmbio;
	}
	public void setGride_sdsitbletocmbio(String gride_sdsitbletocmbio) {
		this.gride_sdsitbletocmbio = gride_sdsitbletocmbio;
	}

	public Integer getGride_scsitbletoaprov() {
		return gride_scsitbletoaprov;
	}
	public void setGride_scsitbletoaprov(Integer gride_scsitbletoaprov) {
		this.gride_scsitbletoaprov = gride_scsitbletoaprov;
	}

	public String getGride_sdtcotacao() {
		return gride_sdtcotacao;
	}
	public void setGride_sdtcotacao(String gride_sdtcotacao) {
		this.gride_sdtcotacao = gride_sdtcotacao;
	}

	public String getGride_scusuarinclt() {
		return gride_scusuarinclt;
	}
	public void setGride_scusuarinclt(String gride_scusuarinclt) {
		this.gride_scusuarinclt = gride_scusuarinclt;
	}

	public String getGride_snusuarinclt() {
		return gride_snusuarinclt;
	}
	public void setGride_snusuarinclt(String gride_snusuarinclt) {
		this.gride_snusuarinclt = gride_snusuarinclt;
	}

	public Long getGride_snbletocmbioano() {
		return gride_snbletocmbioano;
	}
	public void setGride_snbletocmbioano(Long gride_snbletocmbioano) {
		this.gride_snbletocmbioano = gride_snbletocmbioano;
	}

	public Long getGride_snbletonegoccmbio() {
		return gride_snbletonegoccmbio;
	}
	public void setGride_snbletonegoccmbio(Long gride_snbletonegoccmbio) {
		this.gride_snbletonegoccmbio = gride_snbletonegoccmbio;
	}

	public Long getGride_scunicclicmbio() {
		return gride_scunicclicmbio;
	}
	public void setGride_scunicclicmbio(Long gride_scunicclicmbio) {
		this.gride_scunicclicmbio = gride_scunicclicmbio;
	}

	public String getGride_sncunicclicmbio() {
		return gride_sncunicclicmbio;
	}
	public void setGride_sncunicclicmbio(String gride_sncunicclicmbio) {
		this.gride_sncunicclicmbio = gride_sncunicclicmbio;
	}

	public String getGride_stppessoa() {
		return gride_stppessoa;
	}
	public void setGride_stppessoa(String gride_stppessoa) {
		this.gride_stppessoa = gride_stppessoa;
	}

	public Integer getGride_scpfcnpj() {
		return gride_scpfcnpj;
	}
	public void setGride_scpfcnpj(Integer gride_scpfcnpj) {
		this.gride_scpfcnpj = gride_scpfcnpj;
	}

	public Integer getGride_scflial() {
		return gride_scflial;
	}
	public void setGride_scflial(Integer gride_scflial) {
		this.gride_scflial = gride_scflial;
	}

	public Integer getGride_scctrl() {
		return gride_scctrl;
	}
	public void setGride_scctrl(Integer gride_scctrl) {
		this.gride_scctrl = gride_scctrl;
	}

	public Integer getGride_sctposgmtocli() {
		return gride_sctposgmtocli;
	}
	public void setGride_sctposgmtocli(Integer gride_sctposgmtocli) {
		this.gride_sctposgmtocli = gride_sctposgmtocli;
	}

	public String getGride_sdtposgmtocli() {
		return gride_sdtposgmtocli;
	}
	public void setGride_sdtposgmtocli(String gride_sdtposgmtocli) {
		this.gride_sdtposgmtocli = gride_sdtposgmtocli;
	}

	public Integer getGride_sctponegoccmbio() {
		return gride_sctponegoccmbio;
	}
	public void setGride_sctponegoccmbio(Integer gride_sctponegoccmbio) {
		this.gride_sctponegoccmbio = gride_sctponegoccmbio;
	}

	public Integer getGride_snsequndorgnz() {
		return gride_snsequndorgnz;
	}
	public void setGride_snsequndorgnz(Integer gride_snsequndorgnz) {
		this.gride_snsequndorgnz = gride_snsequndorgnz;
	}

	public String getGride_snomeundorgnz() {
		return gride_snomeundorgnz;
	}
	public void setGride_snomeundorgnz(String gride_snomeundorgnz) {
		this.gride_snomeundorgnz = gride_snomeundorgnz;
	}

	public Integer getGride_sagcmrcl() {
		return gride_sagcmrcl;
	}
	public void setGride_sagcmrcl(Integer gride_sagcmrcl) {
		this.gride_sagcmrcl = gride_sagcmrcl;
	}

	public Integer getGride_scprodtservc() {
		return gride_scprodtservc;
	}
	public void setGride_scprodtservc(Integer gride_scprodtservc) {
		this.gride_scprodtservc = gride_scprodtservc;
	}

	public String getGride_sdprodtservc() {
		return gride_sdprodtservc;
	}
	public void setGride_sdprodtservc(String gride_sdprodtservc) {
		this.gride_sdprodtservc = gride_sdprodtservc;
	}

	public Integer getGride_scmodldprodtcmbio() {
		return gride_scmodldprodtcmbio;
	}
	public void setGride_scmodldprodtcmbio(Integer gride_scmodldprodtcmbio) {
		this.gride_scmodldprodtcmbio = gride_scmodldprodtcmbio;
	}

	public String getGride_scmodldprodtdesc() {
		return gride_scmodldprodtdesc;
	}
	public void setGride_scmodldprodtdesc(String gride_scmodldprodtdesc) {
		this.gride_scmodldprodtdesc = gride_scmodldprodtdesc;
	}

	public Integer getGride_scindcdeconmmoeda() {
		return gride_scindcdeconmmoeda;
	}
	public void setGride_scindcdeconmmoeda(Integer gride_scindcdeconmmoeda) {
		this.gride_scindcdeconmmoeda = gride_scindcdeconmmoeda;
	}

	public String getGride_ssimbleconmmoeda() {
		return gride_ssimbleconmmoeda;
	}
	public void setGride_ssimbleconmmoeda(String gride_ssimbleconmmoeda) {
		this.gride_ssimbleconmmoeda = gride_ssimbleconmmoeda;
	}

	public String getGride_svlrmoedaestrang() {
		return gride_svlrmoedaestrang;
	}
	public void setGride_svlrmoedaestrang(String gride_svlrmoedaestrang) {
		this.gride_svlrmoedaestrang = gride_svlrmoedaestrang;
	}

	public String getGride_svlreqvlntedolar() {
		return gride_svlreqvlntedolar;
	}
	public void setGride_svlreqvlntedolar(String gride_svlreqvlntedolar) {
		this.gride_svlreqvlntedolar = gride_svlreqvlntedolar;
	}

	public String getGride_scindcdnegocswap() {
		return gride_scindcdnegocswap;
	}
	public void setGride_scindcdnegocswap(String gride_scindcdnegocswap) {
		this.gride_scindcdnegocswap = gride_scindcdnegocswap;
	}

	public Integer getGride_stdiaopercmbio() {
		return gride_stdiaopercmbio;
	}
	public void setGride_stdiaopercmbio(Integer gride_stdiaopercmbio) {
		this.gride_stdiaopercmbio = gride_stdiaopercmbio;
	}

	public Integer getGride_sqprzmedcmbio() {
		return gride_sqprzmedcmbio;
	}
	public void setGride_sqprzmedcmbio(Integer gride_sqprzmedcmbio) {
		this.gride_sqprzmedcmbio = gride_sqprzmedcmbio;
	}

	public Long getGride_snseqcontrlim() {
		return gride_snseqcontrlim;
	}
	public void setGride_snseqcontrlim(Long gride_snseqcontrlim) {
		this.gride_snseqcontrlim = gride_snseqcontrlim;
	}

	public String getGride_svtxspreadaprov() {
		return gride_svtxspreadaprov;
	}
	public void setGride_svtxspreadaprov(String gride_svtxspreadaprov) {
		this.gride_svtxspreadaprov = gride_svtxspreadaprov;
	}

	public String getGride_scusto() {
		return gride_scusto;
	}
	public void setGride_scusto(String gride_scusto) {
		this.gride_scusto = gride_scusto;
	}

	public String getGride_svtxspreadnegoc() {
		return gride_svtxspreadnegoc;
	}
	public void setGride_svtxspreadnegoc(String gride_svtxspreadnegoc) {
		this.gride_svtxspreadnegoc = gride_svtxspreadnegoc;
	}

	public String getGride_sptxswapcmpdo() {
		return gride_sptxswapcmpdo;
	}
	public void setGride_sptxswapcmpdo(String gride_sptxswapcmpdo) {
		this.gride_sptxswapcmpdo = gride_sptxswapcmpdo;
	}

	public String getGride_sspreaddolar() {
		return gride_sspreaddolar;
	}
	public void setGride_sspreaddolar(String gride_sspreaddolar) {
		this.gride_sspreaddolar = gride_sspreaddolar;
	}

	public Long getGride_scbcoextcmbio() {
		return gride_scbcoextcmbio;
	}
	public void setGride_scbcoextcmbio(Long gride_scbcoextcmbio) {
		this.gride_scbcoextcmbio = gride_scbcoextcmbio;
	}

	public String getGride_sdbcoextcmbio() {
		return gride_sdbcoextcmbio;
	}
	public void setGride_sdbcoextcmbio(String gride_sdbcoextcmbio) {
		this.gride_sdbcoextcmbio = gride_sdbcoextcmbio;
	}

	public String getGride_sdfchtobletocmbio() {
		return gride_sdfchtobletocmbio;
	}
	public void setGride_sdfchtobletocmbio(String gride_sdfchtobletocmbio) {
		this.gride_sdfchtobletocmbio = gride_sdfchtobletocmbio;
	}

	public Integer getGride_scaditvbletocmbio() {
		return gride_scaditvbletocmbio;
	}
	public void setGride_scaditvbletocmbio(Integer gride_scaditvbletocmbio) {
		this.gride_scaditvbletocmbio = gride_scaditvbletocmbio;
	}

	public Integer getGride_scpais() {
		return gride_scpais;
	}
	public void setGride_scpais(Integer gride_scpais) {
		this.gride_scpais = gride_scpais;
	}

	public String getGride_sdpais() {
		return gride_sdpais;
	}
	public void setGride_sdpais(String gride_sdpais) {
		this.gride_sdpais = gride_sdpais;
	}

	public Integer getGride_scpaisembrq() {
		return gride_scpaisembrq;
	}
	public void setGride_scpaisembrq(Integer gride_scpaisembrq) {
		this.gride_scpaisembrq = gride_scpaisembrq;
	}

	public String getGride_sdpaisembrq() {
		return gride_sdpaisembrq;
	}
	public void setGride_sdpaisembrq(String gride_sdpaisembrq) {
		this.gride_sdpaisembrq = gride_sdpaisembrq;
	}

	public Integer getGride_scmodcontrcmbio() {
		return gride_scmodcontrcmbio;
	}
	public void setGride_scmodcontrcmbio(Integer gride_scmodcontrcmbio) {
		this.gride_scmodcontrcmbio = gride_scmodcontrcmbio;
	}
    
}