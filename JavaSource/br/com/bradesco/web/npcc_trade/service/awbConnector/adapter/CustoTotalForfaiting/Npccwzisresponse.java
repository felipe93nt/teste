package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:58
 */
public class Npccwzisresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZIS-HEADER.NPCCWZIS-COD-LAYOUT")
	private String codlayout = "NPCCWZIS";

	@Adapter(transactionField = "NPCCWZIS-HEADER.NPCCWZIS-TAM-LAYOUT")
	private Integer tamlayout = 101;

	@Adapter(transactionField = "NPCCWZIS-REGISTRO.NPCCWZIS-DSC-CUSTO-TOTAL")
	private String dsccustototal = null;

	@Adapter(transactionField = "NPCCWZIS-REGISTRO.NPCCWZIS-VTX-SPREAD-TOT")
	private String vtxspreadtot = null;
	
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

	public String getDsccustototal() {
		return dsccustototal;
	}
	public void setDsccustototal(String dsccustototal) {
		this.dsccustototal = dsccustototal;
	}

	public String getVtxspreadtot() {
		return vtxspreadtot;
	}
	public void setVtxspreadtot(String vtxspreadtot) {
		this.vtxspreadtot = vtxspreadtot;
	}
    
}