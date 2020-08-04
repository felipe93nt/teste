package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 24/06/16 14:20
 */
public class Npccwzusresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZUS-HEADER.NPCCWZUS-COD-LAYOUT")
	private String codlayout = "NPCCWZUS";

	@Adapter(transactionField = "NPCCWZUS-HEADER.NPCCWZUS-TAM-LAYOUT")
	private Integer tamlayout = 5954;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-TOTUSD-DESP-TARF")
	private String totusddesptarf = null;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-TOTBRL-DESP-TARF")
	private String totbrldesptarf = null;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif.Npccwzusresponse_lista")
	private List<Npccwzusresponse_lista> lista = null;
	
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

	public String getTotusddesptarf() {
		return totusddesptarf;
	}
	public void setTotusddesptarf(String totusddesptarf) {
		this.totusddesptarf = totusddesptarf;
	}

	public String getTotbrldesptarf() {
		return totbrldesptarf;
	}
	public void setTotbrldesptarf(String totbrldesptarf) {
		this.totbrldesptarf = totbrldesptarf;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwzusresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwzusresponse_lista> lista) {
		this.lista = lista;
	}
    
}