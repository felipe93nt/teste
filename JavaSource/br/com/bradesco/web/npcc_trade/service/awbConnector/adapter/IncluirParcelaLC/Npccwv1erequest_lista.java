package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirParcelaLC;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/06/16 11:10
 */
public class Npccwv1erequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-LISTA.NPCCWV1E-NPCELA-DSEMB-CARTA")
	private Integer lista_npceladsembcarta = 0;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-LISTA.NPCCWV1E-VPCELA-CARTA-PREVT")
	private String lista_vpcelacartaprevt = null;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-LISTA.NPCCWV1E-VPCELA-CREDT-PREVT")
	private String lista_vpcelacredtprevt = null;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-LISTA.NPCCWV1E-CPRZ-PCELA-CARTA")
	private Integer lista_cprzpcelacarta = 0;

	@Adapter(transactionField = "NPCCWV1E-REGISTRO.NPCCWV1E-LISTA.NPCCWV1E-TDIA-PGTO-CARTA")
	private Integer lista_tdiapgtocarta = 0;
	
	public Integer getLista_npceladsembcarta() {
		return lista_npceladsembcarta;
	}
	public void setLista_npceladsembcarta(Integer lista_npceladsembcarta) {
		this.lista_npceladsembcarta = lista_npceladsembcarta;
	}

	public String getLista_vpcelacartaprevt() {
		return lista_vpcelacartaprevt;
	}
	public void setLista_vpcelacartaprevt(String lista_vpcelacartaprevt) {
		this.lista_vpcelacartaprevt = lista_vpcelacartaprevt;
	}

	public String getLista_vpcelacredtprevt() {
		return lista_vpcelacredtprevt;
	}
	public void setLista_vpcelacredtprevt(String lista_vpcelacredtprevt) {
		this.lista_vpcelacredtprevt = lista_vpcelacredtprevt;
	}

	public Integer getLista_cprzpcelacarta() {
		return lista_cprzpcelacarta;
	}
	public void setLista_cprzpcelacarta(Integer lista_cprzpcelacarta) {
		this.lista_cprzpcelacarta = lista_cprzpcelacarta;
	}

	public Integer getLista_tdiapgtocarta() {
		return lista_tdiapgtocarta;
	}
	public void setLista_tdiapgtocarta(Integer lista_tdiapgtocarta) {
		this.lista_tdiapgtocarta = lista_tdiapgtocarta;
	}
    
}