package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 18:35
 */
public class Npcdwazerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAZE-HEADER.NPCDWAZE-COD-LAYOUT")
	private String codlayout = "NPCDWAZE";

	@Adapter(transactionField = "NPCDWAZE-HEADER.NPCDWAZE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "NPCDWAZE-REGISTRO.NPCDWAZE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;
	
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

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}
    
}