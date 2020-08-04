package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:10
 */
public class Npccwlaerequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-LISTA.NPCCWLAE-NPCELA-DSEMB-TRADE")
	private Integer lista_npceladsembtrade = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-LISTA.NPCCWLAE-TDIA-NEGOC-PCELA")
	private Integer lista_tdianegocpcela = 0;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-LISTA.NPCCWLAE-DVCTO-PCELA-TRADE")
	private String lista_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-LISTA.NPCCWLAE-VPCELA-MESA-TRADE")
	private String lista_vpcelamesatrade = null;

	@Adapter(transactionField = "NPCCWLAE-REGISTRO.NPCCWLAE-LISTA.NPCCWLAE-TP-PARCELA")
	private String lista_tpparcela = null;
	
	public Integer getLista_npceladsembtrade() {
		return lista_npceladsembtrade;
	}
	public void setLista_npceladsembtrade(Integer lista_npceladsembtrade) {
		this.lista_npceladsembtrade = lista_npceladsembtrade;
	}

	public Integer getLista_tdianegocpcela() {
		return lista_tdianegocpcela;
	}
	public void setLista_tdianegocpcela(Integer lista_tdianegocpcela) {
		this.lista_tdianegocpcela = lista_tdianegocpcela;
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

	public String getLista_tpparcela() {
		return lista_tpparcela;
	}
	public void setLista_tpparcela(String lista_tpparcela) {
		this.lista_tpparcela = lista_tpparcela;
	}
    
}