package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 20/09/16 16:13
 */
public class Npccwwusresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWUS-HEADER.NPCCWWUS-COD-LAYOUT")
	private String codlayout = "NPCCWWUS";

	@Adapter(transactionField = "NPCCWWUS-HEADER.NPCCWWUS-TAM-LAYOUT")
	private Integer tamlayout = 2736;

	@Adapter(transactionField = "NPCCWWUS-REGISTRO.NPCCWWUS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWUS-REGISTRO.NPCCWWUS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPeriodicidade.Npccwwusresponse_lista")
	private List<Npccwwusresponse_lista> lista = null;
	
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

	public List<Npccwwusresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwwusresponse_lista> lista) {
		this.lista = lista;
	}
    
}