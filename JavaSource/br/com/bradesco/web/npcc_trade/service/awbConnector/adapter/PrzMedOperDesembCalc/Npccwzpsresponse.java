package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/07/16 16:42
 */
public class Npccwzpsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZPS-HEADER.NPCCWZPS-COD-LAYOUT")
	private String codlayout = "NPCCWZPS";

	@Adapter(transactionField = "NPCCWZPS-HEADER.NPCCWZPS-TAM-LAYOUT")
	private Integer tamlayout = 38;

	@Adapter(transactionField = "NPCCWZPS-REGISTRO.NPCCWZPS-PRZO-MEDIO-OPER-D")
	private Integer przomediooperd = 0;

	@Adapter(transactionField = "NPCCWZPS-REGISTRO.NPCCWZPS-PRZO-MEDIO-OPER-A")
	private String przomedioopera = null;

	@Adapter(transactionField = "NPCCWZPS-REGISTRO.NPCCWZPS-PRZO-MEDIO-DSEMB")
	private Integer przomediodsemb = 0;

	@Adapter(transactionField = "NPCCWZPS-REGISTRO.NPCCWZPS-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;
	
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

	public Integer getPrzomediooperd() {
		return przomediooperd;
	}
	public void setPrzomediooperd(Integer przomediooperd) {
		this.przomediooperd = przomediooperd;
	}

	public String getPrzomedioopera() {
		return przomedioopera;
	}
	public void setPrzomedioopera(String przomedioopera) {
		this.przomedioopera = przomedioopera;
	}

	public Integer getPrzomediodsemb() {
		return przomediodsemb;
	}
	public void setPrzomediodsemb(Integer przomediodsemb) {
		this.przomediodsemb = przomediodsemb;
	}

	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}
    
}