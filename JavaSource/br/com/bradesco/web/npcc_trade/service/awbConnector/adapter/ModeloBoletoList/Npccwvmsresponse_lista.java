package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/06/18 09:46
 */
public class Npccwvmsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVMS-REGISTRO.NPCCWVMS-LISTA.NPCCWVMS-CMOD-CONTR-CMBIO")
	private Integer lista_cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVMS-REGISTRO.NPCCWVMS-LISTA.NPCCWVMS-IMOD-CONTR-CMBIO")
	private String lista_imodcontrcmbio = null;

	@Adapter(transactionField = "NPCCWVMS-REGISTRO.NPCCWVMS-LISTA.NPCCWVMS-CINDCD-MOD-PDRAO")
	private String lista_cindcdmodpdrao = null;
	
	public Integer getLista_cmodcontrcmbio() {
		return lista_cmodcontrcmbio;
	}
	public void setLista_cmodcontrcmbio(Integer lista_cmodcontrcmbio) {
		this.lista_cmodcontrcmbio = lista_cmodcontrcmbio;
	}

	public String getLista_imodcontrcmbio() {
		return lista_imodcontrcmbio;
	}
	public void setLista_imodcontrcmbio(String lista_imodcontrcmbio) {
		this.lista_imodcontrcmbio = lista_imodcontrcmbio;
	}

	public String getLista_cindcdmodpdrao() {
		return lista_cindcdmodpdrao;
	}
	public void setLista_cindcdmodpdrao(String lista_cindcdmodpdrao) {
		this.lista_cindcdmodpdrao = lista_cindcdmodpdrao;
	}
    
}