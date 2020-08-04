package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoComissoes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/06/16 17:47
 */
public class Npccwwssresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWSS-REGISTRO.NPCCWWSS-LISTA.NPCCWWSS-CCONDC-ECONC")
	private Integer lista_ccondceconc = 0;

	@Adapter(transactionField = "NPCCWWSS-REGISTRO.NPCCWWSS-LISTA.NPCCWWSS-ICONDC-ECONC")
	private String lista_icondceconc = null;
	
	public Integer getLista_ccondceconc() {
		return lista_ccondceconc;
	}
	public void setLista_ccondceconc(Integer lista_ccondceconc) {
		this.lista_ccondceconc = lista_ccondceconc;
	}

	public String getLista_icondceconc() {
		return lista_icondceconc;
	}
	public void setLista_icondceconc(String lista_icondceconc) {
		this.lista_icondceconc = lista_icondceconc;
	}
    
}