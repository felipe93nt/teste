package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 10/05/16 17:35
 */
public class Npccwwtsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWTS-HEADER.NPCCWWTS-COD-LAYOUT")
	private String codlayout = "NPCCWWTS";

	@Adapter(transactionField = "NPCCWWTS-HEADER.NPCCWWTS-TAM-LAYOUT")
	private Integer tamlayout = 8016;

	@Adapter(transactionField = "NPCCWWTS-REGISTRO.NPCCWWTS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWTS-REGISTRO.NPCCWWTS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador.Npccwwtsresponse_lista")
	private List<Npccwwtsresponse_lista> lista = null;
	
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

	public List<Npccwwtsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwtsresponse_lista> lista) {
		this.lista = lista;
	}
    
}