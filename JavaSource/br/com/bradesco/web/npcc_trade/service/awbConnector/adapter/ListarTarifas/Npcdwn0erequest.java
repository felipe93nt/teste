package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 18:02
 */
public class Npcdwn0erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWN0E-HEADER.NPCDWN0E-COD-LAYOUT")
	private String codlayout = "NPCDWN0E";

	@Adapter(transactionField = "NPCDWN0E-HEADER.NPCDWN0E-TAM-LAYOUT")
	private Integer tamlayout = 186;

	@Adapter(transactionField = "NPCDWN0E-REGISTRO.NPCDWN0E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCDWN0E-REGISTRO.NPCDWN0E-RPRODT-SERVC")
	private String rprodtservc = null;

	@Adapter(transactionField = "NPCDWN0E-REGISTRO.NPCDWN0E-COPER")
	private Integer coper = 0;

	@Adapter(transactionField = "NPCDWN0E-REGISTRO.NPCDWN0E-ROPER")
	private String roper = null;
	
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

	public String getRprodtservc() {
		return rprodtservc;
	}
	public void setRprodtservc(String rprodtservc) {
		this.rprodtservc = rprodtservc;
	}

	public Integer getCoper() {
		return coper;
	}
	public void setCoper(Integer coper) {
		this.coper = coper;
	}

	public String getRoper() {
		return roper;
	}
	public void setRoper(String roper) {
		this.roper = roper;
	}
    
}