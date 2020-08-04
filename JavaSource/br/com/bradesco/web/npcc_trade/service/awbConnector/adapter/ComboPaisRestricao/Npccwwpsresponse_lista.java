package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPaisRestricao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 15:30
 */
public class Npccwwpsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWPS-REGISTRO.NPCCWWPS-LISTA.NPCCWWPS-COD-PAIS")
	private Integer lista_codpais = 0;

	@Adapter(transactionField = "NPCCWWPS-REGISTRO.NPCCWWPS-LISTA.NPCCWWPS-NOME-PAIS")
	private String lista_nomepais = null;
	
	public Integer getLista_codpais() {
		return lista_codpais;
	}
	public void setLista_codpais(Integer lista_codpais) {
		this.lista_codpais = lista_codpais;
	}

	public String getLista_nomepais() {
		return lista_nomepais;
	}
	public void setLista_nomepais(String lista_nomepais) {
		this.lista_nomepais = lista_nomepais;
	}
    
}