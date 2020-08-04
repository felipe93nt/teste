package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboMoedaOperacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 17/12/15 15:08
 */
public class Npccwh6sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWH6S-REGISTRO.NPCCWH6S-LISTA.NPCCWH6S-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWH6S-REGISTRO.NPCCWH6S-LISTA.NPCCWH6S-CINDCD-FONTE-CONS")
	private String lista_cindcdfontecons = null;

	@Adapter(transactionField = "NPCCWH6S-REGISTRO.NPCCWH6S-LISTA.NPCCWH6S-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;
	
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

	public String getLista_isglindcdfonte() {
		return lista_isglindcdfonte;
	}
	public void setLista_isglindcdfonte(String lista_isglindcdfonte) {
		this.lista_isglindcdfonte = lista_isglindcdfonte;
	}
    
}