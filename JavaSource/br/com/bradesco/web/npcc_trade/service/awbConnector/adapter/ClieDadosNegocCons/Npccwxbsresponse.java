package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:55
 */
public class Npccwxbsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXBS-HEADER.NPCCWXBS-COD-LAYOUT")
	private String codlayout = "NPCCWXBS";

	@Adapter(transactionField = "NPCCWXBS-HEADER.NPCCWXBS-TAM-LAYOUT")
	private Integer tamlayout = 382;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-ISGMTO")
	private String isgmto = null;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-CRTING")
	private String crting = null;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-CPSSOA-UND-ORGNZ")
	private Long cpssoaundorgnz = 0L;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-IRZ-SCIAL")
	private String irzscial = null;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-ICIDDE-ENDER")
	private String iciddeender = null;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-CSGL-UF")
	private String csgluf = null;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-IBANQR-CMBIO")
	private String ibanqrcmbio = null;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-CBANQR-CMBIO")
	private Long cbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCDWXBS-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-NOME-UND-ORGNZ")
	private String nomeundorgnz = null;

	@Adapter(transactionField = "NPCCWXBS-REGISTRO.NPCCWXBS-IMUN-INTL-CMBIO")
	private String imunintlcmbio = null;
	
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

	public Integer getCtposgmtocli() {
		return ctposgmtocli;
	}
	public void setCtposgmtocli(Integer ctposgmtocli) {
		this.ctposgmtocli = ctposgmtocli;
	}

	public String getIsgmto() {
		return isgmto;
	}
	public void setIsgmto(String isgmto) {
		this.isgmto = isgmto;
	}

	public String getCrting() {
		return crting;
	}
	public void setCrting(String crting) {
		this.crting = crting;
	}

	public Long getCpssoaundorgnz() {
		return cpssoaundorgnz;
	}
	public void setCpssoaundorgnz(Long cpssoaundorgnz) {
		this.cpssoaundorgnz = cpssoaundorgnz;
	}

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public String getIrzscial() {
		return irzscial;
	}
	public void setIrzscial(String irzscial) {
		this.irzscial = irzscial;
	}

	public String getIciddeender() {
		return iciddeender;
	}
	public void setIciddeender(String iciddeender) {
		this.iciddeender = iciddeender;
	}

	public String getCsgluf() {
		return csgluf;
	}
	public void setCsgluf(String csgluf) {
		this.csgluf = csgluf;
	}

	public String getIbanqrcmbio() {
		return ibanqrcmbio;
	}
	public void setIbanqrcmbio(String ibanqrcmbio) {
		this.ibanqrcmbio = ibanqrcmbio;
	}

	public Long getCbanqrcmbio() {
		return cbanqrcmbio;
	}
	public void setCbanqrcmbio(Long cbanqrcmbio) {
		this.cbanqrcmbio = cbanqrcmbio;
	}

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getNomeundorgnz() {
		return nomeundorgnz;
	}
	public void setNomeundorgnz(String nomeundorgnz) {
		this.nomeundorgnz = nomeundorgnz;
	}

	public String getImunintlcmbio() {
		return imunintlcmbio;
	}
	public void setImunintlcmbio(String imunintlcmbio) {
		this.imunintlcmbio = imunintlcmbio;
	}
    
}