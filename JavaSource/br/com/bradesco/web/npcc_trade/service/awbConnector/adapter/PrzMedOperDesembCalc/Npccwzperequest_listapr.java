package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/07/16 16:42
 */
public class Npccwzperequest_listapr extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PR.NPCCWZPE-PRZO-MEDIO-DSEMB")
	private Integer listapr_przomediodsemb = 0;
	
	public Integer getListapr_przomediodsemb() {
		return listapr_przomediodsemb;
	}
	public void setListapr_przomediodsemb(Integer listapr_przomediodsemb) {
		this.listapr_przomediodsemb = listapr_przomediodsemb;
	}
    
}