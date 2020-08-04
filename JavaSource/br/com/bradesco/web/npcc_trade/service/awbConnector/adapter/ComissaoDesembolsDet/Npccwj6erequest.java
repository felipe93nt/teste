package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoDesembolsDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/11/18 16:58
 */
public class Npccwj6erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJ6E-HEADER.NPCCWJ6E-COD-LAYOUT")
	private String codlayout = "NPCCWJ6E";

	@Adapter(transactionField = "NPCCWJ6E-HEADER.NPCCWJ6E-TAM-LAYOUT")
	private Integer tamlayout = 27;

	@Adapter(transactionField = "NPCCWJ6E-REGISTRO.NPCCWJ6E-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJ6E-REGISTRO.NPCCWJ6E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWJ6E-REGISTRO.NPCCWJ6E-TIPO-ACESSO")
	private Integer tipoacesso = 0;
	
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

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getTipoacesso() {
		return tipoacesso;
	}
	public void setTipoacesso(Integer tipoacesso) {
		this.tipoacesso = tipoacesso;
	}
    
}