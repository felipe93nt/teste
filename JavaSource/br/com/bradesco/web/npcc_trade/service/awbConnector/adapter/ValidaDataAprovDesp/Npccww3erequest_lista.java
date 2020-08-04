package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidaDataAprovDesp;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/11/16 11:32
 */
public class Npccww3erequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW3E-REGISTRO.NPCCWW3E-LISTA.NPCCWW3E-DLIM-FNDNG-CMBIO")
	private String lista_dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWW3E-REGISTRO.NPCCWW3E-LISTA.NPCCWW3E-CINDCD-FNDNG-UTLZD")
	private String lista_cindcdfndngutlzd = null;
	
	public String getLista_dlimfndngcmbio() {
		return lista_dlimfndngcmbio;
	}
	public void setLista_dlimfndngcmbio(String lista_dlimfndngcmbio) {
		this.lista_dlimfndngcmbio = lista_dlimfndngcmbio;
	}

	public String getLista_cindcdfndngutlzd() {
		return lista_cindcdfndngutlzd;
	}
	public void setLista_cindcdfndngutlzd(String lista_cindcdfndngutlzd) {
		this.lista_cindcdfndngutlzd = lista_cindcdfndngutlzd;
	}
    
}