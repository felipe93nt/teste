package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarOperacoes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/07/18 17:40
 */
public class Npcdwnzsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWNZS-REGISTRO.NPCDWNZS-LISTA.NPCDWNZS-COPER")
	private Integer lista_coper = 0;

	@Adapter(transactionField = "NPCDWNZS-REGISTRO.NPCDWNZS-LISTA.NPCDWNZS-ROPER")
	private String lista_roper = null;
	
	public Integer getLista_coper() {
		return lista_coper;
	}
	public void setLista_coper(Integer lista_coper) {
		this.lista_coper = lista_coper;
	}

	public String getLista_roper() {
		return lista_roper;
	}
	public void setLista_roper(String lista_roper) {
		this.lista_roper = lista_roper;
	}
    
}