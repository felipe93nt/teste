package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/08/16 18:41
 */
public class Npccwztsresponse_gride extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-DT-COTACAO")
	private String gride_sdtcotacao = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-HORARIO")
	private String gride_shorario = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-NBLETO-CMBIO-ANO")
	private Long gride_snbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CSIT-BLETO-CMBIO")
	private Integer gride_scsitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-DSIT-BLETO-CMBIO")
	private String gride_sdsitbletocmbio = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-NSEQ-UND-ORGNZ")
	private Integer gride_snsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-NOME-UND-ORGNZ")
	private String gride_snomeundorgnz = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CAG-BCRIA")
	private Integer gride_scagbcria = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CCTA-BCRIA-CMBIO")
	private Long gride_scctabcriacmbio = 0L;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-DIGT-CCTA-BCRIA")
	private String gride_sdigtcctabcria = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CPRODT-SERVC")
	private Integer gride_scprodtservc = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-DPRODT-SERVC")
	private String gride_sdprodtservc = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CMODLD-PRODT-CMBIO")
	private Integer gride_scmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CMODLD-PRODT-DESC")
	private String gride_scmodldprodtdesc = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CUNIC-CLI-CMBIO")
	private Long gride_scunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-NCUNIC-CLI-CMBIO")
	private String gride_sncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-TP-PESSOA")
	private String gride_stppessoa = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CPF-CNPJ")
	private Integer gride_scpfcnpj = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CFLIAL")
	private Integer gride_scflial = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CCTRL")
	private Integer gride_scctrl = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CRTING")
	private String gride_scrting = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CTPO-SGMTO-CLI")
	private Integer gride_sctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-DTPO-SGMTO-CLI")
	private String gride_sdtposgmtocli = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CINDCD-ECONM-MOEDA")
	private Integer gride_scindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-SIMBL-ECONM-MOEDA")
	private String gride_ssimbleconmmoeda = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-VNEGOC-MOEDA-ESTRG")
	private String gride_svnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-VTX-SPREAD-NEGOC")
	private String gride_svtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-TDIA-OPER-CMBIO")
	private Integer gride_stdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CUSUAR-INCLT")
	private String gride_scusuarinclt = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-NUSUAR-INCLT")
	private String gride_snusuarinclt = null;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-NBLETO-NEGOC-CMBIO")
	private Long gride_snbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE.NPCCWZTS-S-CADITV-BLETO-CMBIO")
	private Integer gride_scaditvbletocmbio = 0;
	
	public String getGride_sdtcotacao() {
		return gride_sdtcotacao;
	}
	public void setGride_sdtcotacao(String gride_sdtcotacao) {
		this.gride_sdtcotacao = gride_sdtcotacao;
	}

	public String getGride_shorario() {
		return gride_shorario;
	}
	public void setGride_shorario(String gride_shorario) {
		this.gride_shorario = gride_shorario;
	}

	public Long getGride_snbletocmbioano() {
		return gride_snbletocmbioano;
	}
	public void setGride_snbletocmbioano(Long gride_snbletocmbioano) {
		this.gride_snbletocmbioano = gride_snbletocmbioano;
	}

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

	public Integer getGride_scagbcria() {
		return gride_scagbcria;
	}
	public void setGride_scagbcria(Integer gride_scagbcria) {
		this.gride_scagbcria = gride_scagbcria;
	}

	public Long getGride_scctabcriacmbio() {
		return gride_scctabcriacmbio;
	}
	public void setGride_scctabcriacmbio(Long gride_scctabcriacmbio) {
		this.gride_scctabcriacmbio = gride_scctabcriacmbio;
	}

	public String getGride_sdigtcctabcria() {
		return gride_sdigtcctabcria;
	}
	public void setGride_sdigtcctabcria(String gride_sdigtcctabcria) {
		this.gride_sdigtcctabcria = gride_sdigtcctabcria;
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

	public String getGride_scrting() {
		return gride_scrting;
	}
	public void setGride_scrting(String gride_scrting) {
		this.gride_scrting = gride_scrting;
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

	public String getGride_svnegocmoedaestrg() {
		return gride_svnegocmoedaestrg;
	}
	public void setGride_svnegocmoedaestrg(String gride_svnegocmoedaestrg) {
		this.gride_svnegocmoedaestrg = gride_svnegocmoedaestrg;
	}

	public String getGride_svtxspreadnegoc() {
		return gride_svtxspreadnegoc;
	}
	public void setGride_svtxspreadnegoc(String gride_svtxspreadnegoc) {
		this.gride_svtxspreadnegoc = gride_svtxspreadnegoc;
	}

	public Integer getGride_stdiaopercmbio() {
		return gride_stdiaopercmbio;
	}
	public void setGride_stdiaopercmbio(Integer gride_stdiaopercmbio) {
		this.gride_stdiaopercmbio = gride_stdiaopercmbio;
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

	public Long getGride_snbletonegoccmbio() {
		return gride_snbletonegoccmbio;
	}
	public void setGride_snbletonegoccmbio(Long gride_snbletonegoccmbio) {
		this.gride_snbletonegoccmbio = gride_snbletonegoccmbio;
	}

	public Integer getGride_scaditvbletocmbio() {
		return gride_scaditvbletocmbio;
	}
	public void setGride_scaditvbletocmbio(Integer gride_scaditvbletocmbio) {
		this.gride_scaditvbletocmbio = gride_scaditvbletocmbio;
	}
    
}