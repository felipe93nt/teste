package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/09/16 16:13
 */
public class Npccwwusresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWUS-REGISTRO.NPCCWWUS-LISTA.NPCCWWUS-CFLUXO-PERDC-CMBIO")
	private Integer lista_cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWWUS-REGISTRO.NPCCWWUS-LISTA.NPCCWWUS-IFLUXO-PERDC-CMBIO")
	private String lista_ifluxoperdccmbio = null;

	@Adapter(transactionField = "NPCCWWUS-REGISTRO.NPCCWWUS-LISTA.NPCCWWUS-PERDC-PRZO-MES")
	private Integer lista_perdcprzomes = 0;
	
	public Integer getLista_cfluxoperdccmbio() {
		return lista_cfluxoperdccmbio;
	}
	public void setLista_cfluxoperdccmbio(Integer lista_cfluxoperdccmbio) {
		this.lista_cfluxoperdccmbio = lista_cfluxoperdccmbio;
	}

	public String getLista_ifluxoperdccmbio() {
		return lista_ifluxoperdccmbio;
	}
	public void setLista_ifluxoperdccmbio(String lista_ifluxoperdccmbio) {
		this.lista_ifluxoperdccmbio = lista_ifluxoperdccmbio;
	}

	public Integer getLista_perdcprzomes() {
		return lista_perdcprzomes;
	}
	public void setLista_perdcprzomes(Integer lista_perdcprzomes) {
		this.lista_perdcprzomes = lista_perdcprzomes;
	}
    
}