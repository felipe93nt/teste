package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 27/06/16 11:43
 */
public class Npccwx3erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX3E-HEADER.NPCCWX3E-COD-LAYOUT")
	private String codlayout = "NPCCWX3E";

	@Adapter(transactionField = "NPCCWX3E-HEADER.NPCCWX3E-TAM-LAYOUT")
	private Integer tamlayout = 287;

	@Adapter(transactionField = "NPCCWX3E-REGISTRO.NPCCWX3E-DLIM-EMBRQ-CMBIO")
	private String dlimembrqcmbio = null;

	@Adapter(transactionField = "NPCCWX3E-REGISTRO.NPCCWX3E-CPRZ-NEGOC-CMBIO")
	private String cprznegoccmbio = null;

	@Adapter(transactionField = "NPCCWX3E-REGISTRO.NPCCWX3E-TDIA-VALDD-CARTA")
	private Integer tdiavalddcarta = 0;

	@Adapter(transactionField = "NPCCWX3E-REGISTRO.NPCCWX3E-TDIA-VALDD-LETRA")
	private Integer tdiavalddletra = 0;

	@Adapter(transactionField = "NPCCWX3E-REGISTRO.NPCCWX3E-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWX3E-REGISTRO.NPCCWX3E-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC.Npccwx3erequest_lista")
	private List<Npccwx3erequest_lista> lista = null;
	
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

	public String getDlimembrqcmbio() {
		return dlimembrqcmbio;
	}
	public void setDlimembrqcmbio(String dlimembrqcmbio) {
		this.dlimembrqcmbio = dlimembrqcmbio;
	}

	public String getCprznegoccmbio() {
		return cprznegoccmbio;
	}
	public void setCprznegoccmbio(String cprznegoccmbio) {
		this.cprznegoccmbio = cprznegoccmbio;
	}

	public Integer getTdiavalddcarta() {
		return tdiavalddcarta;
	}
	public void setTdiavalddcarta(Integer tdiavalddcarta) {
		this.tdiavalddcarta = tdiavalddcarta;
	}

	public Integer getTdiavalddletra() {
		return tdiavalddletra;
	}
	public void setTdiavalddletra(Integer tdiavalddletra) {
		this.tdiavalddletra = tdiavalddletra;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwx3erequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwx3erequest_lista> lista) {
		this.lista = lista;
	}
    
}