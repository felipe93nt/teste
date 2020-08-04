package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcPrazoTotalOperLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/06/16 11:43
 */
public class Npccwx3erequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX3E-REGISTRO.NPCCWX3E-LISTA.NPCCWX3E-TDIA-PGTO-CARTA")
	private Integer lista_tdiapgtocarta = 0;
	
	public Integer getLista_tdiapgtocarta() {
		return lista_tdiapgtocarta;
	}
	public void setLista_tdiapgtocarta(Integer lista_tdiapgtocarta) {
		this.lista_tdiapgtocarta = lista_tdiapgtocarta;
	}
    
}