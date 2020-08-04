package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TaxasForfaitingCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/05/16 20:29
 */
public class Npccwzcsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZCS-HEADER.NPCCWZCS-COD-LAYOUT")
	private String codlayout = "NPCCWZCS";

	@Adapter(transactionField = "NPCCWZCS-HEADER.NPCCWZCS-TAM-LAYOUT")
	private Integer tamlayout = 63;

	@Adapter(transactionField = "NPCCWZCS-REGISTRO.NPCCWZCS-TAXA-JUROS")
	private String taxajuros = null;

	@Adapter(transactionField = "NPCCWZCS-REGISTRO.NPCCWZCS-TAXA-DESCONTADA")
	private String taxadescontada = null;

	@Adapter(transactionField = "NPCCWZCS-REGISTRO.NPCCWZCS-VALOR-JUROS")
	private String valorjuros = null;

	@Adapter(transactionField = "NPCCWZCS-REGISTRO.NPCCWZCS-VALOR-SAQUE")
	private String valorsaque = null;
	
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

	public String getTaxajuros() {
		return taxajuros;
	}
	public void setTaxajuros(String taxajuros) {
		this.taxajuros = taxajuros;
	}

	public String getTaxadescontada() {
		return taxadescontada;
	}
	public void setTaxadescontada(String taxadescontada) {
		this.taxadescontada = taxadescontada;
	}

	public String getValorjuros() {
		return valorjuros;
	}
	public void setValorjuros(String valorjuros) {
		this.valorjuros = valorjuros;
	}

	public String getValorsaque() {
		return valorsaque;
	}
	public void setValorsaque(String valorsaque) {
		this.valorsaque = valorsaque;
	}
    
}