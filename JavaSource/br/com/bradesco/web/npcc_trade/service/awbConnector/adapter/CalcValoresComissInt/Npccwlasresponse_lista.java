package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcValoresComissInt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/03/17 15:10
 */
public class Npccwlasresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-LISTA.NPCCWLAS-NPCELA-DSEMB-TRADE")
	private Integer lista_npceladsembtrade = 0;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-LISTA.NPCCWLAS-TDIA-NEGOC-PCELA")
	private Integer lista_tdianegocpcela = 0;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-LISTA.NPCCWLAS-DVCTO-PCELA-TRADE")
	private String lista_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWLAS-REGISTRO.NPCCWLAS-LISTA.NPCCWLAS-VPCELA-MESA-TRADE")
	private Double lista_vpcelamesatrade = 0D;
	
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

	public Double getLista_vpcelamesatrade() {
		return lista_vpcelamesatrade;
	}
	public void setLista_vpcelamesatrade(Double lista_vpcelamesatrade) {
		this.lista_vpcelamesatrade = lista_vpcelamesatrade;
	}
    
}