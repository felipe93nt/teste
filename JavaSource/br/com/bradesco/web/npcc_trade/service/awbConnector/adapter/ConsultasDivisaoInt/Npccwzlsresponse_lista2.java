package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultasDivisaoInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/08/16 17:35
 */
public class Npccwzlsresponse_lista2 extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA2.NPCCWZLS-ISGL-INDCD-ECONM")
	private String lista2_isglindcdeconm = null;

	@Adapter(transactionField = "NPCCWZLS-REGISTRO.NPCCWZLS-LISTA2.NPCCWZLS-VNEGOC-MOEDA-TOT")
	private String lista2_vnegocmoedatot = null;
	
	public String getLista2_isglindcdeconm() {
		return lista2_isglindcdeconm;
	}
	public void setLista2_isglindcdeconm(String lista2_isglindcdeconm) {
		this.lista2_isglindcdeconm = lista2_isglindcdeconm;
	}

	public String getLista2_vnegocmoedatot() {
		return lista2_vnegocmoedatot;
	}
	public void setLista2_vnegocmoedatot(String lista2_vnegocmoedatot) {
		this.lista2_vnegocmoedatot = lista2_vnegocmoedatot;
	}
    
}