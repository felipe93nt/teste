package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Listasituacaobolagex;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/05/16 14:07
 */
public class Npccwnzsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWNZS-REGISTRO.NPCCWNZS-LISTA.NPCCWNZS-CSIT-BLETO-CMBIO")
	private Integer lista_csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWNZS-REGISTRO.NPCCWNZS-LISTA.NPCCWNZS-ISIT-BLETO-CMBIO")
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