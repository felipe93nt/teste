package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/06/16 14:03
 */
public class Npccwigsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIGS-HEADER.NPCCWIGS-COD-LAYOUT")
	private String codlayout = "NPCCWIGS";

	@Adapter(transactionField = "NPCCWIGS-HEADER.NPCCWIGS-TAM-LAYOUT")
	private Integer tamlayout = 1416;

	@Adapter(transactionField = "NPCCWIGS-REGISTRO.NPCCWIGS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWIGS-REGISTRO.NPCCWIGS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoDespesas.Npccwigsresponse_lista")
	private List<Npccwigsresponse_lista> lista = null;
	
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

	public List<Npccwigsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwigsresponse_lista> lista) {
		this.lista = lista;
	}
    
}