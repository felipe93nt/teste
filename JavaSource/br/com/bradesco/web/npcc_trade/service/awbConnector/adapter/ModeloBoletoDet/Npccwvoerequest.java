package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/07/18 11:13
 */
public class Npccwvoerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVOE-HEADER.NPCCWVOE-COD-LAYOUT")
	private String codlayout = "NPCCWVOE";

	@Adapter(transactionField = "NPCCWVOE-HEADER.NPCCWVOE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVOE-REGISTRO.NPCCWVOE-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;
	
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

	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}
    
}