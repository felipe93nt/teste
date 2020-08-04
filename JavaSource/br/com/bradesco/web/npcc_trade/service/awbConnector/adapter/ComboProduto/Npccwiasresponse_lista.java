package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/02/16 14:44
 */
public class Npccwiasresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIAS-REGISTRO.NPCCWIAS-LISTA.NPCCWIAS-CPRODT-SERVC")
	private Integer lista_cprodtservc = 0;

	@Adapter(transactionField = "NPCCWIAS-REGISTRO.NPCCWIAS-LISTA.NPCCWIAS-RPRODT-SERVC")
	private String lista_rprodtservc = null;
	
	public Integer getLista_cprodtservc() {
		return lista_cprodtservc;
	}
	public void setLista_cprodtservc(Integer lista_cprodtservc) {
		this.lista_cprodtservc = lista_cprodtservc;
	}

	public String getLista_rprodtservc() {
		return lista_rprodtservc;
	}
	public void setLista_rprodtservc(String lista_rprodtservc) {
		this.lista_rprodtservc = lista_rprodtservc;
	}
    
}