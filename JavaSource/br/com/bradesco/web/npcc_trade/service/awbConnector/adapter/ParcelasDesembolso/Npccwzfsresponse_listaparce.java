package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 27/10/16 10:41
 */
public class Npccwzfsresponse_listaparce extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-LISTA-PARCE.NPCCWZFS-NPCELA-DSEMB-CARTA")
	private Integer listaparce_npceladsembcarta = 0;

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-LISTA-PARCE.NPCCWZFS-VPCELA-CREDIT-PREVT")
	private String listaparce_vpcelacreditprevt = null;

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-LISTA-PARCE.NPCCWZFS-VPCELA-CARTA-PREVT")
	private String listaparce_vpcelacartaprevt = null;

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-LISTA-PARCE.NPCCWZFS-CPRZ-PCELA-CARTA")
	private Integer listaparce_cprzpcelacarta = 0;

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-LISTA-PARCE.NPCCWZFS-NPRZ-PCELA-CARTA")
	private String listaparce_nprzpcelacarta = null;

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-LISTA-PARCE.NPCCWZFS-TDIA-PGTO-CARTA")
	private Integer listaparce_tdiapgtocarta = 0;
	
	public Integer getListaparce_npceladsembcarta() {
		return listaparce_npceladsembcarta;
	}
	public void setListaparce_npceladsembcarta(Integer listaparce_npceladsembcarta) {
		this.listaparce_npceladsembcarta = listaparce_npceladsembcarta;
	}

	public String getListaparce_vpcelacreditprevt() {
		return listaparce_vpcelacreditprevt;
	}
	public void setListaparce_vpcelacreditprevt(String listaparce_vpcelacreditprevt) {
		this.listaparce_vpcelacreditprevt = listaparce_vpcelacreditprevt;
	}

	public String getListaparce_vpcelacartaprevt() {
		return listaparce_vpcelacartaprevt;
	}
	public void setListaparce_vpcelacartaprevt(String listaparce_vpcelacartaprevt) {
		this.listaparce_vpcelacartaprevt = listaparce_vpcelacartaprevt;
	}

	public Integer getListaparce_cprzpcelacarta() {
		return listaparce_cprzpcelacarta;
	}
	public void setListaparce_cprzpcelacarta(Integer listaparce_cprzpcelacarta) {
		this.listaparce_cprzpcelacarta = listaparce_cprzpcelacarta;
	}

	public String getListaparce_nprzpcelacarta() {
		return listaparce_nprzpcelacarta;
	}
	public void setListaparce_nprzpcelacarta(String listaparce_nprzpcelacarta) {
		this.listaparce_nprzpcelacarta = listaparce_nprzpcelacarta;
	}

	public Integer getListaparce_tdiapgtocarta() {
		return listaparce_tdiapgtocarta;
	}
	public void setListaparce_tdiapgtocarta(Integer listaparce_tdiapgtocarta) {
		this.listaparce_tdiapgtocarta = listaparce_tdiapgtocarta;
	}
    
}