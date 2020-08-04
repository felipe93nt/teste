package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/04/16 15:38
 */
public class Npccwidsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIDS-HEADER.NPCCWIDS-COD-LAYOUT")
	private String codlayout = "NPCCWIDS";

	@Adapter(transactionField = "NPCCWIDS-HEADER.NPCCWIDS-TAM-LAYOUT")
	private Integer tamlayout = 126;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-CINDCD-DESP-TARF")
	private Integer cindcddesptarf = 0;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-DESCR-DESP-TARIF")
	private String descrdesptarif = null;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-CCONDC-ECONC")
	private Integer ccondceconc = 0;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-CTPO-DESP-CMBIO")
	private Integer ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-ITPO-DESP-CMBIO")
	private String itpodespcmbio = null;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-ISGL-INDCD-FONTE")
	private String isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWIDS-REGISTRO.NPCCWIDS-VDESP-BLETO-CMBIO")
	private Double vdespbletocmbio = 0D;
	
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

	public Integer getCindcddesptarf() {
		return cindcddesptarf;
	}
	public void setCindcddesptarf(Integer cindcddesptarf) {
		this.cindcddesptarf = cindcddesptarf;
	}

	public String getDescrdesptarif() {
		return descrdesptarif;
	}
	public void setDescrdesptarif(String descrdesptarif) {
		this.descrdesptarif = descrdesptarif;
	}

	public Integer getCcondceconc() {
		return ccondceconc;
	}
	public void setCcondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}

	public Integer getCtpodespcmbio() {
		return ctpodespcmbio;
	}
	public void setCtpodespcmbio(Integer ctpodespcmbio) {
		this.ctpodespcmbio = ctpodespcmbio;
	}

	public String getItpodespcmbio() {
		return itpodespcmbio;
	}
	public void setItpodespcmbio(String itpodespcmbio) {
		this.itpodespcmbio = itpodespcmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public String getIsglindcdfonte() {
		return isglindcdfonte;
	}
	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

	public Double getVdespbletocmbio() {
		return vdespbletocmbio;
	}
	public void setVdespbletocmbio(Double vdespbletocmbio) {
		this.vdespbletocmbio = vdespbletocmbio;
	}
    
}