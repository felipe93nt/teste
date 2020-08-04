package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoExcl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/12/15 16:51
 */
public class Npccwvqerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVQE-HEADER.NPCCWVQE-COD-LAYOUT")
	private String codlayout = "NPCCWVQE";

	@Adapter(transactionField = "NPCCWVQE-HEADER.NPCCWVQE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWVQE-REGISTRO.NPCCWVQE-CMOD-CONTR-CMBIO")
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