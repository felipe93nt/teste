package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoeda;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 18:35
 */
public class Npcdwazsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWAZS-REGISTRO.NPCDWAZS-LISTA.NPCDWAZS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCDWAZS-REGISTRO.NPCDWAZS-LISTA.NPCDWAZS-CINDCD-FONTE-CONS")
	private String lista_cindcdfontecons = null;

	@Adapter(transactionField = "NPCDWAZS-REGISTRO.NPCDWAZS-LISTA.NPCDWAZS-ISGL-INDCD-ECONM")
	private String lista_isglindcdeconm = null;
	
	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_cindcdfontecons() {
		return lista_cindcdfontecons;
	}
	public void setLista_cindcdfontecons(String lista_cindcdfontecons) {
		this.lista_cindcdfontecons = lista_cindcdfontecons;
	}

	public String getLista_isglindcdeconm() {
		return lista_isglindcdeconm;
	}
	public void setLista_isglindcdeconm(String lista_isglindcdeconm) {
		this.lista_isglindcdeconm = lista_isglindcdeconm;
	}
    
}