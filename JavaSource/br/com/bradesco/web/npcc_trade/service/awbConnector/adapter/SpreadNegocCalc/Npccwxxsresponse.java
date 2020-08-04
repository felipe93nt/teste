package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/03/17 09:38
 */
public class Npccwxxsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXXS-HEADER.NPCCWXXS-COD-LAYOUT")
	private String codlayout = "NPCCWXXS";

	@Adapter(transactionField = "NPCCWXXS-HEADER.NPCCWXXS-TAM-LAYOUT")
	private Integer tamlayout = 134;

	@Adapter(transactionField = "NPCCWXXS-REGISTRO.NPCCWXXS-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWXXS-REGISTRO.NPCCWXXS-PTX-FLAT-PNALT")
	private String ptxflatpnalt = null;

	@Adapter(transactionField = "NPCCWXXS-REGISTRO.NPCCWXXS-VLX-TOTAL-COMIS")
	private String vlxtotalcomis = null;

	@Adapter(transactionField = "NPCCWXXS-REGISTRO.NPCCWXXS-DSC-CUSTO-TOTAL")
	private String dsccustototal = null;

	@Adapter(transactionField = "NPCCWXXS-REGISTRO.NPCCWXXS-VTX-SPREAD-TOT")
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

	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}

	public String getPtxflatpnalt() {
		return ptxflatpnalt;
	}
	public void setPtxflatpnalt(String ptxflatpnalt) {
		this.ptxflatpnalt = ptxflatpnalt;
	}

	public String getVlxtotalcomis() {
		return vlxtotalcomis;
	}
	public void setVlxtotalcomis(String vlxtotalcomis) {
		this.vlxtotalcomis = vlxtotalcomis;
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