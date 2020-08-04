package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 18/12/15 15:53
 */
public class Npcdwa3sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWA3S-HEADER.NPCDWA3S-COD-LAYOUT")
	private String codlayout = "NPCDWA3S";

	@Adapter(transactionField = "NPCDWA3S-HEADER.NPCDWA3S-TAM-LAYOUT")
	private Integer tamlayout = 3666;

	@Adapter(transactionField = "NPCDWA3S-REGISTRO.NPCDWA3S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWA3S-REGISTRO.NPCDWA3S-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais.Npcdwa3sresponse_lista")
	private List<Npcdwa3sresponse_lista> lista = null;
	
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

	public List<Npcdwa3sresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwa3sresponse_lista> lista) {
		this.lista = lista;
	}
    
}