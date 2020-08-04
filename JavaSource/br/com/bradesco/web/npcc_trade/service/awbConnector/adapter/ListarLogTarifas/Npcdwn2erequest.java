package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarLogTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 10:48
 */
public class Npcdwn2erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWN2E-HEADER.NPCDWN2E-COD-LAYOUT")
	private String codlayout = "NPCDWN2E";

	@Adapter(transactionField = "NPCDWN2E-HEADER.NPCDWN2E-TAM-LAYOUT")
	private Integer tamlayout = 46;

	@Adapter(transactionField = "NPCDWN2E-REGISTRO.NPCDWN2E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCDWN2E-REGISTRO.NPCDWN2E-COPER")
	private Integer coper = 0;

	@Adapter(transactionField = "NPCDWN2E-REGISTRO.NPCDWN2E-PERIODO-INI")
	private String periodoini = null;

	@Adapter(transactionField = "NPCDWN2E-REGISTRO.NPCDWN2E-PERIODO-FIM")
	private String periodofim = null;

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

	public Integer getCprodtservc() {
		return cprodtservc;
	}

	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCoper() {
		return coper;
	}

	public void setCoper(Integer coper) {
		this.coper = coper;
	}

	public String getPeriodoini() {
		return periodoini;
	}

	public void setPeriodoini(String periodoini) {
		this.periodoini = periodoini;
	}

	public String getPeriodofim() {
		return periodofim;
	}

	public void setPeriodofim(String periodofim) {
		this.periodofim = periodofim;
	}

}