package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/02/17 13:48
 */
public class Npccww8sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW8S-HEADER.NPCCWW8S-COD-LAYOUT")
	private String codlayout = "NPCCWW8S";

	@Adapter(transactionField = "NPCCWW8S-HEADER.NPCCWW8S-TAM-LAYOUT")
	private Integer tamlayout = 30;

	@Adapter(transactionField = "NPCCWW8S-REGISTRO.NPCCWW8S-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;
	
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

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}
    
}