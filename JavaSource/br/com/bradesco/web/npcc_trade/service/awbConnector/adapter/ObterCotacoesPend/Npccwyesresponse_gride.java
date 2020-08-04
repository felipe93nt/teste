package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 12:50
 */
public class Npccwyesresponse_gride extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-NBLETO-CMBIO-ANO")
	private Long gride_snbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-NBLETO-NEGOC-CMBIO")
	private Long gride_snbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-DT-COTACAO")
	private String gride_sdtcotacao = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CUNIC-CLI-CMBIO")
	private Long gride_scunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-NCUNIC-CLI-CMBIO")
	private String gride_sncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-TP-PESSOA")
	private String gride_stppessoa = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CPF-CNPJ")
	private Integer gride_scpfcnpj = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CFLIAL")
	private Integer gride_scflial = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CCTRL")
	private Integer gride_scctrl = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-NSEQ-UND-ORGNZ")
	private Integer gride_snsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-NOME-UND-ORGNZ")
	private String gride_snomeundorgnz = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CBCO-EXT-CMBIO")
	private Long gride_scbcoextcmbio = 0L;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-DBCO-EXT-CMBIO")
	private String gride_sdbcoextcmbio = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CINDCD-ECONM-MOEDA")
	private Integer gride_scindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-SIMBL-ECONM-MOEDA")
	private String gride_ssimbleconmmoeda = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-VLR-MOEDA-ESTRANG")
	private String gride_svlrmoedaestrang = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CPRODT-SERVC")
	private Integer gride_scprodtservc = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-DPRODT-SERVC")
	private String gride_sdprodtservc = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CMODLD-PRODT-CMBIO")
	private Integer gride_scmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CMODLD-PRODT-DESC")
	private String gride_scmodldprodtdesc = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CSIT-BLETO-CMBIO")
	private Integer gride_scsitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-DSIT-BLETO-CMBIO")
	private String gride_sdsitbletocmbio = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CUSUAR-INCLT")
	private String gride_scusuarinclt = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-NUSUAR-INCLT")
	private String gride_snusuarinclt = null;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE.NPCCWYES-S-CSIT-BLETO-APROV")
	private Integer gride_scsitbletoaprov = 0;
	
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

	public String getGride_sdtcotacao() {
		return gride_sdtcotacao;
	}
	public void setGride_sdtcotacao(String gride_sdtcotacao) {
		this.gride_sdtcotacao = gride_sdtcotacao;
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

	public Integer getGride_scsitbletoaprov() {
		return gride_scsitbletoaprov;
	}
	public void setGride_scsitbletoaprov(Integer gride_scsitbletoaprov) {
		this.gride_scsitbletoaprov = gride_scsitbletoaprov;
	}
    
}