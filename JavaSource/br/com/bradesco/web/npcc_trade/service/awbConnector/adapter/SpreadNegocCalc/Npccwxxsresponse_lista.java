package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 12:04
 */
public class Npccwxxsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXXS-REGISTRO.NPCCWXXS-LISTA.NPCCWXXS-VPREVT-COMIS-CMBIO")
	private String lista_vprevtcomiscmbio = null;
	
	public String getLista_vprevtcomiscmbio() {
		return lista_vprevtcomiscmbio;
	}
	public void setLista_vprevtcomiscmbio(String lista_vprevtcomiscmbio) {
		this.lista_vprevtcomiscmbio = lista_vprevtcomiscmbio;
	}
    
}