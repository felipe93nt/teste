package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/05/16 17:35
 */
public class Npccwwtsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWTS-REGISTRO.NPCCWWTS-LISTA.NPCCWWTS-CPSSOA")
	private Long lista_cpssoa = 0L;

	@Adapter(transactionField = "NPCCWWTS-REGISTRO.NPCCWWTS-LISTA.NPCCWWTS-NM-BNEFC")
	private String lista_nmbnefc = null;
	
	public Long getLista_cpssoa() {
		return lista_cpssoa;
	}
	public void setLista_cpssoa(Long lista_cpssoa) {
		this.lista_cpssoa = lista_cpssoa;
	}

	public String getLista_nmbnefc() {
		return lista_nmbnefc;
	}
	public void setLista_nmbnefc(String lista_nmbnefc) {
		this.lista_nmbnefc = lista_nmbnefc;
	}
    
}