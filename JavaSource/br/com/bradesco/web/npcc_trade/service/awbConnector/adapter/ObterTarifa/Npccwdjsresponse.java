package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 16/08/16 16:41
 */
public class Npccwdjsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWDJS-HEADER.NPCCWDJS-COD-LAYOUT")
	private String codlayout = "NPCCWDJS";

	@Adapter(transactionField = "NPCCWDJS-HEADER.NPCCWDJS-TAM-LAYOUT")
	private Integer tamlayout = 6004;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-TOTUSD-DESP-TARF")
	private String totusddesptarf = null;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-TOTBRL-DESP-TARF")
	private String totbrldesptarf = null;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa.Npccwdjsresponse_lista")
	private List<Npccwdjsresponse_lista> lista = null;
	
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

	public List<Npccwdjsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwdjsresponse_lista> lista) {
		this.lista = lista;
	}
    
}