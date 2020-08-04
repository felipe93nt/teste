package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/07/16 16:42
 */
public class Npccwzperequest_listapc extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PC.NPCCWZPE-NPCELA-DSEMB-TRADE")
	private Integer listapc_npceladsembtrade = 0;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PC.NPCCWZPE-TDIA-NEGOC-PCELA")
	private Integer listapc_tdianegocpcela = 0;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PC.NPCCWZPE-DVCTO-PCELA-TRADE")
	private String listapc_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PC.NPCCWZPE-VPCELA-MESA-TRADE")
	private String listapc_vpcelamesatrade = null;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PC.NPCCWZPE-TP-PARCELA")
	private String listapc_tpparcela = null;
	
	public Integer getListapc_npceladsembtrade() {
		return listapc_npceladsembtrade;
	}
	public void setListapc_npceladsembtrade(Integer listapc_npceladsembtrade) {
		this.listapc_npceladsembtrade = listapc_npceladsembtrade;
	}

	public Integer getListapc_tdianegocpcela() {
		return listapc_tdianegocpcela;
	}
	public void setListapc_tdianegocpcela(Integer listapc_tdianegocpcela) {
		this.listapc_tdianegocpcela = listapc_tdianegocpcela;
	}

	public String getListapc_dvctopcelatrade() {
		return listapc_dvctopcelatrade;
	}
	public void setListapc_dvctopcelatrade(String listapc_dvctopcelatrade) {
		this.listapc_dvctopcelatrade = listapc_dvctopcelatrade;
	}

	public String getListapc_vpcelamesatrade() {
		return listapc_vpcelamesatrade;
	}
	public void setListapc_vpcelamesatrade(String listapc_vpcelamesatrade) {
		this.listapc_vpcelamesatrade = listapc_vpcelamesatrade;
	}

	public String getListapc_tpparcela() {
		return listapc_tpparcela;
	}
	public void setListapc_tpparcela(String listapc_tpparcela) {
		this.listapc_tpparcela = listapc_tpparcela;
	}
    
}