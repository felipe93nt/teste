package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 27/10/16 10:41
 */
public class Npccwzfsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZFS-HEADER.NPCCWZFS-COD-LAYOUT")
	private String codlayout = "NPCCWZFS";

	@Adapter(transactionField = "NPCCWZFS-HEADER.NPCCWZFS-TAM-LAYOUT")
	private Integer tamlayout = 1036;

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZFS-SAIDA.NPCCWZFS-LISTA-PARCE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ParcelasDesembolso.Npccwzfsresponse_listaparce")
	private List<Npccwzfsresponse_listaparce> listaparce = null;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwzfsresponse_listaparce> getListaparce() {
		return listaparce;
	}
	public void setListaparce( List<Npccwzfsresponse_listaparce> listaparce) {
		this.listaparce = listaparce;
	}
    
}