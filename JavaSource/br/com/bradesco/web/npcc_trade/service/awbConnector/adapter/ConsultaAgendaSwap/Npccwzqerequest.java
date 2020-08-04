package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/09/16 16:40
 */
public class Npccwzqerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWZQE-COD-LAYOUT")
	private String codlayout = "NPCCWZQE";

	@Adapter(transactionField = "NPCCWZVE-HEADER.NPCCWZQE-TAM-LAYOUT")
	private Integer tamlayout = 93;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-DVCTO-PCELA-TRADE-I")
	private String dvctopcelatradei = null;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-DVCTO-PCELA-TRADE-F")
	private String dvctopcelatradef = null;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-DFCHTO-BLETO-I")
	private String dfchtobletoi = null;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-DFCHTO-BLETO-F")
	private String dfchtobletof = null;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-CINDCD-LIQDC-SWAP")
	private String cindcdliqdcswap = null;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-CTPO-SGMTO-CLI")
	private Integer ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWZQE-REGISTRO.NPCCWZQE-CBANQR-CMBIO-FNDNG")
	private Long cbanqrcmbiofndng = 0L;
	
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

	public String getDvctopcelatradei() {
		return dvctopcelatradei;
	}
	public void setDvctopcelatradei(String dvctopcelatradei) {
		this.dvctopcelatradei = dvctopcelatradei;
	}

	public String getDvctopcelatradef() {
		return dvctopcelatradef;
	}
	public void setDvctopcelatradef(String dvctopcelatradef) {
		this.dvctopcelatradef = dvctopcelatradef;
	}

	public String getDfchtobletoi() {
		return dfchtobletoi;
	}
	public void setDfchtobletoi(String dfchtobletoi) {
		this.dfchtobletoi = dfchtobletoi;
	}

	public String getDfchtobletof() {
		return dfchtobletof;
	}
	public void setDfchtobletof(String dfchtobletof) {
		this.dfchtobletof = dfchtobletof;
	}

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}

	public String getCindcdliqdcswap() {
		return cindcdliqdcswap;
	}
	public void setCindcdliqdcswap(String cindcdliqdcswap) {
		this.cindcdliqdcswap = cindcdliqdcswap;
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

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public Long getCbanqrcmbiofndng() {
		return cbanqrcmbiofndng;
	}
	public void setCbanqrcmbiofndng(Long cbanqrcmbiofndng) {
		this.cbanqrcmbiofndng = cbanqrcmbiofndng;
	}
    
}