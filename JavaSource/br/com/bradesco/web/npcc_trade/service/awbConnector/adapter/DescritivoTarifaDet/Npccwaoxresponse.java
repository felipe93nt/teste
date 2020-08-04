package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 10:05
 */
public class Npccwaoxresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWAOX-HEADER.NPCCWAOX-COD-LAYOUT")
	private String codlayout = "NPCCWAOX";

	@Adapter(transactionField = "NPCCWAOX-HEADER.NPCCWAOX-TAM-LAYOUT")
	private Integer tamlayout = 153;

	@Adapter(transactionField = "NPCCWAOX-REGISTRO.NPCCWAOX-S-CCOND-ECONC")
	private Integer sccondeconc = 0;

	@Adapter(transactionField = "NPCCWAOX-REGISTRO.NPCCWAOX-S-DCCOND-ECONC")
	private String sdccondeconc = null;

	@Adapter(transactionField = "NPCCWAOX-REGISTRO.NPCCWAOX-S-DALTER")
	private String sdalter = null;

	@Adapter(transactionField = "NPCCWAOX-REGISTRO.NPCCWAOX-S-CUSUAR")
	private String scusuar = null;

	@Adapter(transactionField = "NPCCWAOX-REGISTRO.NPCCWAOX-S-HMANUT")
	private String shmanut = null;
	
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

	public Integer getSccondeconc() {
		return sccondeconc;
	}
	public void setSccondeconc(Integer sccondeconc) {
		this.sccondeconc = sccondeconc;
	}

	public String getSdccondeconc() {
		return sdccondeconc;
	}
	public void setSdccondeconc(String sdccondeconc) {
		this.sdccondeconc = sdccondeconc;
	}

	public String getSdalter() {
		return sdalter;
	}
	public void setSdalter(String sdalter) {
		this.sdalter = sdalter;
	}

	public String getScusuar() {
		return scusuar;
	}
	public void setScusuar(String scusuar) {
		this.scusuar = scusuar;
	}

	public String getShmanut() {
		return shmanut;
	}
	public void setShmanut(String shmanut) {
		this.shmanut = shmanut;
	}
    
}