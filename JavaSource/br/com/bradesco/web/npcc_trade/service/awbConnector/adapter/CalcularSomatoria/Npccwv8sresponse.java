package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/06/16 15:09
 */
public class Npccwv8sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV8S-HEADER.NPCCWV8S-COD-LAYOUT")
	private String codlayout = "NPCCWV8S";

	@Adapter(transactionField = "NPCCWV8S-HEADER.NPCCWV8S-TAM-LAYOUT")
	private Integer tamlayout = 26;

	@Adapter(transactionField = "NPCCWV8S-REGISTRO.NPCCWV8S-PTOT-JURO-CMBIO")
	private Double ptotjurocmbio = 0D;
	
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

	public Double getPtotjurocmbio() {
		return ptotjurocmbio;
	}
	public void setPtotjurocmbio(Double ptotjurocmbio) {
		this.ptotjurocmbio = ptotjurocmbio;
	}
    
}