package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 26/09/16 10:15
 */
public class Npccwyosresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYOS-HEADER.NPCCWYOS-COD-LAYOUT")
	private String codlayout = "NPCCWYOS";

	@Adapter(transactionField = "NPCCWYOS-HEADER.NPCCWYOS-TAM-LAYOUT")
	private Integer tamlayout = 1993;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOC-S-VALOR-A-DSEMB")
	private String svaloradsemb = null;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYOS-REGISTRO.NPCCWYOS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoForfaiting.Npccwyosresponse_lista")
	private List<Npccwyosresponse_lista> lista = null;
	
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

	public String getSvaloradsemb() {
		return svaloradsemb;
	}
	public void setSvaloradsemb(String svaloradsemb) {
		this.svaloradsemb = svaloradsemb;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwyosresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwyosresponse_lista> lista) {
		this.lista = lista;
	}
    
}