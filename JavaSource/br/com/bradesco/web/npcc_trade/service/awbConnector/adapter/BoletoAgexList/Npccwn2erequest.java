package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BoletoAgexList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 01/12/16 12:15
 */
public class Npccwn2erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWN2E-HEADER.NPCCWN2E-COD-LAYOUT")
	private String codlayout = "NPCCWN2E";

	@Adapter(transactionField = "NPCCWN2E-HEADER.NPCCWN2E-TAM-LAYOUT")
	private Integer tamlayout = 68;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-STATUS")
	private Integer estatus = 0;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-CUNIC-CLI-CMBIO")
	private Long ecunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-CPRODT-SERVC")
	private Integer ecprodtservc = 0;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-DANO-BASE")
	private Integer edanobase = 0;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-NBLETO-CMBIO-ANO")
	private Integer enbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-DATA-INI")
	private String edataini = null;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-DATA-FIM")
	private String edatafim = null;

	@Adapter(transactionField = "NPCCWN2E-REGISTRO.NPCCWN2E-E-FLAG")
	private Integer eflag = 0;
	
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

	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Long getEcunicclicmbio() {
		return ecunicclicmbio;
	}
	public void setEcunicclicmbio(Long ecunicclicmbio) {
		this.ecunicclicmbio = ecunicclicmbio;
	}

	public Integer getEcprodtservc() {
		return ecprodtservc;
	}
	public void setEcprodtservc(Integer ecprodtservc) {
		this.ecprodtservc = ecprodtservc;
	}

	public Integer getEdanobase() {
		return edanobase;
	}
	public void setEdanobase(Integer edanobase) {
		this.edanobase = edanobase;
	}

	public Integer getEnbletocmbioano() {
		return enbletocmbioano;
	}
	public void setEnbletocmbioano(Integer enbletocmbioano) {
		this.enbletocmbioano = enbletocmbioano;
	}

	public String getEdataini() {
		return edataini;
	}
	public void setEdataini(String edataini) {
		this.edataini = edataini;
	}

	public String getEdatafim() {
		return edatafim;
	}
	public void setEdatafim(String edatafim) {
		this.edatafim = edatafim;
	}

	public Integer getEflag() {
		return eflag;
	}
	public void setEflag(Integer eflag) {
		this.eflag = eflag;
	}
    
}