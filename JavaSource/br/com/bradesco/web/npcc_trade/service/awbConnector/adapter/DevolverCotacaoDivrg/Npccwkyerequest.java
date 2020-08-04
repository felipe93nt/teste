package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DevolverCotacaoDivrg;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 01/11/18 12:34
 */
public class Npccwkyerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWKYE-HEADER.NPCCWKYE-COD-LAYOUT")
	private String codlayout = "NPCCWKYE";

	@Adapter(transactionField = "NPCCWKYE-HEADER.NPCCWKYE-TAM-LAYOUT")
	private Integer tamlayout = 5062;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-CMOTVO-BLETO-CMBIO")
	private Integer cmotvobletocmbio = 0;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-ROBS-BLETO-CMBIO")
	private String robsbletocmbio = null;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-CTPO-OBS-BLETO")
	private Integer ctpoobsbleto = 0;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWKYE-REGISTRO.NPCCWKYE-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;
	
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

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public Integer getCmotvobletocmbio() {
		return cmotvobletocmbio;
	}
	public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
		this.cmotvobletocmbio = cmotvobletocmbio;
	}

	public String getRobsbletocmbio() {
		return robsbletocmbio;
	}
	public void setRobsbletocmbio(String robsbletocmbio) {
		this.robsbletocmbio = robsbletocmbio;
	}

	public Integer getCtpoobsbleto() {
		return ctpoobsbleto;
	}
	public void setCtpoobsbleto(Integer ctpoobsbleto) {
		this.ctpoobsbleto = ctpoobsbleto;
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

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}
    
}