package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 06/04/16 08:46
 */
public class Npcdwfgsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWFGS-HEADER.NPCDWFGS-COD-LAYOUT")
	private String codlayout = "NPCDWFGS";

	@Adapter(transactionField = "NPCDWFGS-HEADER.NPCDWFGS-TAM-LAYOUT")
	private Integer tamlayout = 8256;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWFGS-REGISTRO.NPCDWFGS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidExtModalList.Npcdwfgsresponse_lista")
	private List<Npcdwfgsresponse_lista> lista = null;
	
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

	public List<Npcdwfgsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwfgsresponse_lista> lista) {
		this.lista = lista;
	}
    
}