package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/01/16 16:05
 */
public class Npccwvfsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVFS-REGISTRO.NPCCWVFS-LISTA.NPCCWVFS-CTPO-CLAUS-CMBIO")
	private Integer lista_ctpoclauscmbio = 0;

	@Adapter(transactionField = "NPCCWVFS-REGISTRO.NPCCWVFS-LISTA.NPCCWVFS-ITPO-CLAUS-CMBIO")
	private String lista_itpoclauscmbio = null;
	
	public Integer getLista_ctpoclauscmbio() {
		return lista_ctpoclauscmbio;
	}
	public void setLista_ctpoclauscmbio(Integer lista_ctpoclauscmbio) {
		this.lista_ctpoclauscmbio = lista_ctpoclauscmbio;
	}

	public String getLista_itpoclauscmbio() {
		return lista_itpoclauscmbio;
	}
	public void setLista_itpoclauscmbio(String lista_itpoclauscmbio) {
		this.lista_itpoclauscmbio = lista_itpoclauscmbio;
	}
    
}