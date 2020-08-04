package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BaixaSaldoForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 11:32
 */
public class Npccww6erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW6E-HEADER.NPCCWW6E-COD-LAYOUT")
	private String codlayout = "NPCCWW6E";

	@Adapter(transactionField = "NPCCWW6E-HEADER.NPCCWW6E-TAM-LAYOUT")
	private Integer tamlayout = 78;

	@Adapter(transactionField = "NPCCWW6E-REGISTRO.NPCCWW6E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWW6E-REGISTRO.NPCCWW6E-SALDO-A-DSEMBOLSAR")
	private String saldoadsembolsar = null;

	@Adapter(transactionField = "NPCCWW6E-REGISTRO.NPCCWW6E-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWW6E-REGISTRO.NPCCWW6E-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWW6E-REGISTRO.NPCCWW6E-CECONM-MOEDA-LIM")
	private Integer ceconmmoedalim = 0;

	@Adapter(transactionField = "NPCCWW6E-REGISTRO.NPCCWW6E-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;
	
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

	public String getSaldoadsembolsar() {
		return saldoadsembolsar;
	}
	public void setSaldoadsembolsar(String saldoadsembolsar) {
		this.saldoadsembolsar = saldoadsembolsar;
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

	public Integer getCeconmmoedalim() {
		return ceconmmoedalim;
	}
	public void setCeconmmoedalim(Integer ceconmmoedalim) {
		this.ceconmmoedalim = ceconmmoedalim;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}
    
}