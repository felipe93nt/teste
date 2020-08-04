package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboSegmento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 26/02/16 10:29
 */
public class Npccwh8sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWH8S-REGISTRO.NPCCWH8S-LISTA.NPCCWH8S-CTPO-SGMTO-CLI")
	private Integer lista_ctposgmtocli = 0;

	@Adapter(transactionField = "NPCCWH8S-REGISTRO.NPCCWH8S-LISTA.NPCCWH8S-ITPO-SSGTO-UND")
	private String lista_itpossgtound = null;
	
	public Integer getLista_ctposgmtocli() {
		return lista_ctposgmtocli;
	}
	public void setLista_ctposgmtocli(Integer lista_ctposgmtocli) {
		this.lista_ctposgmtocli = lista_ctposgmtocli;
	}

	public String getLista_itpossgtound() {
		return lista_itpossgtound;
	}
	public void setLista_itpossgtound(String lista_itpossgtound) {
		this.lista_itpossgtound = lista_itpossgtound;
	}
    
}