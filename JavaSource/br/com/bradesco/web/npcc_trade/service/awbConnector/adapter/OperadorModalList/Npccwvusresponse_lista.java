package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/03/20 15:27
 */
public class Npccwvusresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVUS-REGISTRO.NPCCWVUS-LISTA.NPCCWVUS-CUSUAR-INCL")
	private String lista_cusuarincl = null;

	@Adapter(transactionField = "NPCCWVUS-REGISTRO.NPCCWVUS-LISTA.NPCCWVUS-NM-USUAR-INC")
	private String lista_nmusuarinc = null;
	
	public String getLista_cusuarincl() {
		return lista_cusuarincl;
	}
	public void setLista_cusuarincl(String lista_cusuarincl) {
		this.lista_cusuarincl = lista_cusuarincl;
	}

	public String getLista_nmusuarinc() {
		return lista_nmusuarinc;
	}
	public void setLista_nmusuarinc(String lista_nmusuarinc) {
		this.lista_nmusuarinc = lista_nmusuarinc;
	}
    
}