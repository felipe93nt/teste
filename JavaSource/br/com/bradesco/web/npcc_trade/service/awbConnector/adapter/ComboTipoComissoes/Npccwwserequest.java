package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/06/16 17:47
 */
public class Npccwwserequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWSE-HEADER.NPCCWWSE-COD-LAYOUT")
	private String codlayout = "NPCCWWSE";

	@Adapter(transactionField = "NPCCWWSE-HEADER.NPCCWWSE-TAM-LAYOUT")
	private Integer tamlayout = 22;

	@Adapter(transactionField = "NPCCWWSE-REGISTRO.NPCCWWSE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWWSE-REGISTRO.NPCCWWSE-CINDC-TELA")
	private Integer cindctela = 0;
	
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

	public Integer getCindctela() {
		return cindctela;
	}
	public void setCindctela(Integer cindctela) {
		this.cindctela = cindctela;
	}
    
}