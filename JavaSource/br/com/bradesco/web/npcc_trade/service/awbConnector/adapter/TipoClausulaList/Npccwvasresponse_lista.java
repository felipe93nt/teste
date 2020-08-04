package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/12/15 15:47
 */
public class Npccwvasresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVAS-REGISTRO.NPCCWVAS-LISTA.NPCCWVAS-CTPO-CLAUS-CMBIO")
	private Integer lista_ctpoclauscmbio = 0;

	@Adapter(transactionField = "NPCCWVAS-REGISTRO.NPCCWVAS-LISTA.NPCCWVAS-ITPO-CLAUS-CMBIO")
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