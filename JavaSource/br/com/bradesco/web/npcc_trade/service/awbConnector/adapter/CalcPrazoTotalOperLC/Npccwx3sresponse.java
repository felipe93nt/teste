package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/06/16 11:43
 */
public class Npccwx3sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX3S-HEADER.NPCCWX3S-COD-LAYOUT")
	private String codlayout = "NPCCWX3S";

	@Adapter(transactionField = "NPCCWX3S-HEADER.NPCCWX3S-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCCWX3S-REGISTRO.NPCCWX3S-S-TDIA-OPERD-CMBIO")
	private Integer stdiaoperdcmbio = 0;
	
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

	public Integer getStdiaoperdcmbio() {
		return stdiaoperdcmbio;
	}
	public void setStdiaoperdcmbio(Integer stdiaoperdcmbio) {
		this.stdiaoperdcmbio = stdiaoperdcmbio;
	}
    
}