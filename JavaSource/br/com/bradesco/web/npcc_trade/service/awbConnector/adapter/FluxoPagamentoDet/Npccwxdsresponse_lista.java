package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FluxoPagamentoDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/08/16 14:53
 */
public class Npccwxdsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-LISTA.NPCCWXDS-TIPO-JUROS")
	private String lista_tipojuros = null;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-LISTA.NPCCWXDS-NPCELA-DSEMB-TRADE")
	private Integer lista_npceladsembtrade = 0;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-LISTA.NPCCWXDS-DVCTO-PCELA-TRADE")
	private String lista_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-LISTA.NPCCWXDS-VPCELA-MESA-TRADE")
	private String lista_vpcelamesatrade = null;

	@Adapter(transactionField = "NPCCWXDS-REGISTRO.NPCCWXDS-LISTA.NPCCWXDS-TDIA-NEGOC-PCELA")
	private Integer lista_tdianegocpcela = 0;
	
	public String getLista_tipojuros() {
		return lista_tipojuros;
	}
	public void setLista_tipojuros(String lista_tipojuros) {
		this.lista_tipojuros = lista_tipojuros;
	}

	public Integer getLista_npceladsembtrade() {
		return lista_npceladsembtrade;
	}
	public void setLista_npceladsembtrade(Integer lista_npceladsembtrade) {
		this.lista_npceladsembtrade = lista_npceladsembtrade;
	}

	public String getLista_dvctopcelatrade() {
		return lista_dvctopcelatrade;
	}
	public void setLista_dvctopcelatrade(String lista_dvctopcelatrade) {
		this.lista_dvctopcelatrade = lista_dvctopcelatrade;
	}

	public String getLista_vpcelamesatrade() {
		return lista_vpcelamesatrade;
	}
	public void setLista_vpcelamesatrade(String lista_vpcelamesatrade) {
		this.lista_vpcelamesatrade = lista_vpcelamesatrade;
	}

	public Integer getLista_tdianegocpcela() {
		return lista_tdianegocpcela;
	}
	public void setLista_tdianegocpcela(Integer lista_tdianegocpcela) {
		this.lista_tdianegocpcela = lista_tdianegocpcela;
	}
    
}