package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Fluxovalidacaopagame;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/10/16 11:28
 */
public class Npccwx8erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX8E-HEADER.NPCCWX8E-COD-LAYOUT")
	private String codlayout = "NPCCWX8E";

	@Adapter(transactionField = "NPCCWX8E-HEADER.NPCCWX8E-TAM-LAYOUT")
	private Integer tamlayout = 41;

	@Adapter(transactionField = "NPCCWX8E-REGISTRO.NPCCWX8E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWX8E-REGISTRO.NPCCWX8E-CMODLD-PRODT-CMBIO")
	private Integer cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWX8E-REGISTRO.NPCCWX8E-TDIA-OPER-CMBIO")
	private Integer tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWX8E-REGISTRO.NPCCWX8E-TDIA-CAREN-PRINC")
	private Integer tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWX8E-REGISTRO.NPCCWX8E-CINDCD-PCOBR-PRINC")
	private Integer cindcdpcobrprinc = 0;

	@Adapter(transactionField = "NPCCWX8E-REGISTRO.NPCCWX8E-QTDE-OCORR-PRINC")
	private Integer qtdeocorrprinc = 0;
	
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

	public Integer getCmodldprodtcmbio() {
		return cmodldprodtcmbio;
	}
	public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
		this.cmodldprodtcmbio = cmodldprodtcmbio;
	}

	public Integer getTdiaopercmbio() {
		return tdiaopercmbio;
	}
	public void setTdiaopercmbio(Integer tdiaopercmbio) {
		this.tdiaopercmbio = tdiaopercmbio;
	}

	public Integer getTdiacarenprinc() {
		return tdiacarenprinc;
	}
	public void setTdiacarenprinc(Integer tdiacarenprinc) {
		this.tdiacarenprinc = tdiacarenprinc;
	}

	public Integer getCindcdpcobrprinc() {
		return cindcdpcobrprinc;
	}
	public void setCindcdpcobrprinc(Integer cindcdpcobrprinc) {
		this.cindcdpcobrprinc = cindcdpcobrprinc;
	}

	public Integer getQtdeocorrprinc() {
		return qtdeocorrprinc;
	}
	public void setQtdeocorrprinc(Integer qtdeocorrprinc) {
		this.qtdeocorrprinc = qtdeocorrprinc;
	}
    
}