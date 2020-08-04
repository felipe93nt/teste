package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 21/09/16 09:55
 */
public class Npccwzgsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZGS-HEADER.NPCCWZGS-COD-LAYOUT")
	private String codlayout = "NPCCWZGS";

	@Adapter(transactionField = "NPCCWZGS-HEADER.NPCCWZGS-TAM-LAYOUT")
	private Integer tamlayout = 1004;

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList.Npccwzgsresponse_lista")
	private List<Npccwzgsresponse_lista> lista = null;
	
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

	public List<Npccwzgsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwzgsresponse_lista> lista) {
		this.lista = lista;
	}
    
}