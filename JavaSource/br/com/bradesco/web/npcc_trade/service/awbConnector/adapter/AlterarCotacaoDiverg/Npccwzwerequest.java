package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarCotacaoDiverg;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/01/17 10:55
 */
public class Npccwzwerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZWE-HEADER.NPCCWZWE-COD-LAYOUT")
	private String codlayout = "NPCCWZWE";

	@Adapter(transactionField = "NPCCWZWE-HEADER.NPCCWZWE-TAM-LAYOUT")
	private Integer tamlayout = 562;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-CMOTVO-BLETO-CMBIO")
	private Integer cmotvobletocmbio = 0;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-ROBS-BLETO-CMBIO")
	private String robsbletocmbio = null;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-CTPO-OBS-BLETO")
	private Integer ctpoobsbleto = 0;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWZWE-REGISTRO.NPCCWZWE-CSIT-BLETO-APROV")
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