package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/12/16 11:07
 */
public class Inecwpaerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "INECWPAE-HEADER.INECWPAE-COD-LAYOUT")
	private String codlayout = "INECWPAE";

	@Adapter(transactionField = "INECWPAE-HEADER.INECWPAE-TAM-LAYOUT")
	private Integer tamlayout = 18;

	@Adapter(transactionField = "INECWPAE-BLOCO-ENTRADA.INECWPAE-E-CINDCD-ECONM")
	private Integer ecindcdeconm = 0;
	
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

	public Integer getEcindcdeconm() {
		return ecindcdeconm;
	}
	public void setEcindcdeconm(Integer ecindcdeconm) {
		this.ecindcdeconm = ecindcdeconm;
	}
    
}