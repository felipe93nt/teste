package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 04/05/16 12:41
 */
public class Npccwx7sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX7S-HEADER.NPCCWX7S-COD-LAYOUT")
	private String codlayout = "NPCCWX7S";

	@Adapter(transactionField = "NPCCWX7S-HEADER.NPCCWX7S-TAM-LAYOUT")
	private Integer tamlayout = 756;

	@Adapter(transactionField = "NPCCWX7S-SAIDA.NPCCWX7S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWX7S-SAIDA.NPCCWX7S-LISTA-DT-DSEMB", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso.Npccwx7sresponse_listadtdsemb")
	private List<Npccwx7sresponse_listadtdsemb> listadtdsemb = null;
	
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

	public List<Npccwx7sresponse_listadtdsemb> getListadtdsemb() {
		return listadtdsemb;
	}
	public void setListadtdsemb( List<Npccwx7sresponse_listadtdsemb> listadtdsemb) {
		this.listadtdsemb = listadtdsemb;
	}
    
}