package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/03/17 09:38
 */
public class Npccwxxerequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-LISTA.NPCCWXXE-VPREVT-COMIS-CMBIO")
	private String lista_vprevtcomiscmbio = null;
	
	public String getLista_vprevtcomiscmbio() {
		return lista_vprevtcomiscmbio;
	}
	public void setLista_vprevtcomiscmbio(String lista_vprevtcomiscmbio) {
		this.lista_vprevtcomiscmbio = lista_vprevtcomiscmbio;
	}
    
}