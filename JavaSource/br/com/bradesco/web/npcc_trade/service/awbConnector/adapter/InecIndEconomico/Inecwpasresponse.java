package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.InecIndEconomico;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/12/16 11:07
 */
public class Inecwpasresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "INECWPAS-HEADER.INECWPAS-COD-LAYOUT")
	private String codlayout = "INECWPAS";

	@Adapter(transactionField = "INECWPAS-HEADER.INECWPAS-TAM-LAYOUT")
	private Integer tamlayout = 76;

	@Adapter(transactionField = "INECWPAS-BLOCO-SAIDA.INECWPAS-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "INECWPAS-BLOCO-SAIDA.INECWPAS-IPAIS")
	private String ipais = null;
	
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

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getIpais() {
		return ipais;
	}
	public void setIpais(String ipais) {
		this.ipais = ipais;
	}
    
}