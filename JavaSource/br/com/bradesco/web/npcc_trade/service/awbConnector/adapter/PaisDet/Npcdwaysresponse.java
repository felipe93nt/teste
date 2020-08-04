package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PaisDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/07/16 10:46
 */
public class Npcdwaysresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAYS-HEADER.NPCDWAYS-COD-LAYOUT")
	private String codlayout = "NPCDWAYS";

	@Adapter(transactionField = "NPCDWAYS-HEADER.NPCDWAYS-TAM-LAYOUT")
	private Integer tamlayout = 657;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CD-CNTTE")
	private String cdcntte = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-NOME-CNTTE")
	private String nomecntte = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CD-PAIS")
	private String cdpais = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-NOME-PAIS")
	private String nomepais = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-SGL-PAIS-ISO")
	private String sglpaisiso = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-NOME-PAIS-INGLES")
	private String nomepaisingles = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CINDCD-RISCO-ESTRG")
	private String cindcdriscoestrg = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CEXIGE-NRO-FINCR")
	private String cexigenrofincr = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CINDCD-LVGEM-DINHE")
	private String cindcdlvgemdinhe = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CINDCD-PRISO-FSCAL")
	private String cindcdprisofscal = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CBLOQ-PAIS-CMBIO")
	private String cbloqpaiscmbio = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-ISGL-INDCD-FONTE")
	private String isglindcdfonte = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CINDCD-FONTE-CONS")
	private String cindcdfontecons = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-NTPO-SIT-CMBIO")
	private Integer ntpositcmbio = 0;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-RJUSTF-SIT-CMBIO")
	private String rjustfsitcmbio = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CUSUAR-INCL")
	private String cusuarincl = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-IUSUAR-INCL")
	private String iusuarincl = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-CUSUAR-MANUT")
	private String cusuarmanut = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-IUSUAR-MANUT")
	private String iusuarmanut = null;

	@Adapter(transactionField = "NPCDWAYS-REGISTRO.NPCDWAYS-HMANUT-REG")
	private String hmanutreg = null;
	
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

	public String getCdcntte() {
		return cdcntte;
	}
	public void setCdcntte(String cdcntte) {
		this.cdcntte = cdcntte;
	}

	public String getNomecntte() {
		return nomecntte;
	}
	public void setNomecntte(String nomecntte) {
		this.nomecntte = nomecntte;
	}

	public String getCdpais() {
		return cdpais;
	}
	public void setCdpais(String cdpais) {
		this.cdpais = cdpais;
	}

	public String getNomepais() {
		return nomepais;
	}
	public void setNomepais(String nomepais) {
		this.nomepais = nomepais;
	}

	public String getSglpaisiso() {
		return sglpaisiso;
	}
	public void setSglpaisiso(String sglpaisiso) {
		this.sglpaisiso = sglpaisiso;
	}

	public String getNomepaisingles() {
		return nomepaisingles;
	}
	public void setNomepaisingles(String nomepaisingles) {
		this.nomepaisingles = nomepaisingles;
	}

	public String getCindcdriscoestrg() {
		return cindcdriscoestrg;
	}
	public void setCindcdriscoestrg(String cindcdriscoestrg) {
		this.cindcdriscoestrg = cindcdriscoestrg;
	}

	public String getCexigenrofincr() {
		return cexigenrofincr;
	}
	public void setCexigenrofincr(String cexigenrofincr) {
		this.cexigenrofincr = cexigenrofincr;
	}

	public String getCindcdlvgemdinhe() {
		return cindcdlvgemdinhe;
	}
	public void setCindcdlvgemdinhe(String cindcdlvgemdinhe) {
		this.cindcdlvgemdinhe = cindcdlvgemdinhe;
	}

	public String getCindcdprisofscal() {
		return cindcdprisofscal;
	}
	public void setCindcdprisofscal(String cindcdprisofscal) {
		this.cindcdprisofscal = cindcdprisofscal;
	}

	public String getCbloqpaiscmbio() {
		return cbloqpaiscmbio;
	}
	public void setCbloqpaiscmbio(String cbloqpaiscmbio) {
		this.cbloqpaiscmbio = cbloqpaiscmbio;
	}

	public String getIsglindcdfonte() {
		return isglindcdfonte;
	}
	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

	public String getCindcdfontecons() {
		return cindcdfontecons;
	}
	public void setCindcdfontecons(String cindcdfontecons) {
		this.cindcdfontecons = cindcdfontecons;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getNtpositcmbio() {
		return ntpositcmbio;
	}
	public void setNtpositcmbio(Integer ntpositcmbio) {
		this.ntpositcmbio = ntpositcmbio;
	}

	public String getRjustfsitcmbio() {
		return rjustfsitcmbio;
	}
	public void setRjustfsitcmbio(String rjustfsitcmbio) {
		this.rjustfsitcmbio = rjustfsitcmbio;
	}

	public String getCusuarincl() {
		return cusuarincl;
	}
	public void setCusuarincl(String cusuarincl) {
		this.cusuarincl = cusuarincl;
	}

	public String getIusuarincl() {
		return iusuarincl;
	}
	public void setIusuarincl(String iusuarincl) {
		this.iusuarincl = iusuarincl;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	public String getCusuarmanut() {
		return cusuarmanut;
	}
	public void setCusuarmanut(String cusuarmanut) {
		this.cusuarmanut = cusuarmanut;
	}

	public String getIusuarmanut() {
		return iusuarmanut;
	}
	public void setIusuarmanut(String iusuarmanut) {
		this.iusuarmanut = iusuarmanut;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}
    
}