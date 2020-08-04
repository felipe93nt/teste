package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListaSituacaoBoleto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 18:08
 */
public class Npccwjxsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJXS-REGISTRO.NPCCWJXS-LISTA.NPCCWJXS-CSIT-BLETO-CMBIO")
	private Integer lista_csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWJXS-REGISTRO.NPCCWJXS-LISTA.NPCCWJXS-ISIT-BLETO-CMBIO")
	private String lista_isitbletocmbio = null;
	
	public Integer getLista_csitbletocmbio() {
		return lista_csitbletocmbio;
	}
	public void setLista_csitbletocmbio(Integer lista_csitbletocmbio) {
		this.lista_csitbletocmbio = lista_csitbletocmbio;
	}

	public String getLista_isitbletocmbio() {
		return lista_isitbletocmbio;
	}
	public void setLista_isitbletocmbio(String lista_isitbletocmbio) {
		this.lista_isitbletocmbio = lista_isitbletocmbio;
	}
    
}