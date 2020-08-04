package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/03/16 14:37
 */
public class Npccwieerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIEE-HEADER.NPCCWIEE-COD-LAYOUT")
	private String codlayout = "NPCCWIEE";

	@Adapter(transactionField = "NPCCWIEE-HEADER.NPCCWIEE-TAM-LAYOUT")
	private Integer tamlayout = 22;

	@Adapter(transactionField = "NPCCWIEE-REGISTRO.NPCCWIEE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWIEE-REGISTRO.NPCCWIEE-FILTRO")
	private String filtro = null;
	
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

	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
    
}