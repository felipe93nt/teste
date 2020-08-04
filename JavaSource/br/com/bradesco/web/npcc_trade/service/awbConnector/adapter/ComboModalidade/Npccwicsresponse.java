package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 08/06/16 17:23
 */
public class Npccwicsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWICS-HEADER.NPCCWICS-COD-LAYOUT")
	private String codlayout = "NPCCWICS";

	@Adapter(transactionField = "NPCCWICS-HEADER.NPCCWICS-TAM-LAYOUT")
	private Integer tamlayout = 1456;

	@Adapter(transactionField = "NPCCWICS-REGISTRO.NPCCWICS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWICS-REGISTRO.NPCCWICS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboModalidade.Npccwicsresponse_lista")
	private List<Npccwicsresponse_lista> lista = null;
	
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

	public List<Npccwicsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwicsresponse_lista> lista) {
		this.lista = lista;
	}
    
}