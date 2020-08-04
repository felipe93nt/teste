package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 15:30
 */
public class Npccwwperequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWPE-HEADER.NPCCWWPE-COD-LAYOUT")
	private String codlayout = "NPCCWWPE";

	@Adapter(transactionField = "NPCCWWPE-HEADER.NPCCWWPE-TAM-LAYOUT")
	private Integer tamlayout = 16;

	@Adapter(transactionField = "NPCCWWPE-REGISTRO.NPCCWWPE-COD-PAIS")
	private Integer codpais = 0;
	
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

	public Integer getCodpais() {
		return codpais;
	}
	public void setCodpais(Integer codpais) {
		this.codpais = codpais;
	}
    
}