package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 22/03/16 08:12
 */
public class Npccwypsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYPS-HEADER.NPCCWYPS-COD-LAYOUT")
	private String codlayout = "NPCCWYPS";

	@Adapter(transactionField = "NPCCWYPS-HEADER.NPCCWYPS-TAM-LAYOUT")
	private Integer tamlayout = 976;

	@Adapter(transactionField = "NPCCWYPS-REGISTRO.NPCCWYPS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYPS-REGISTRO.NPCCWYPS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons.Npccwypsresponse_lista")
	private List<Npccwypsresponse_lista> lista = null;
	
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

	public List<Npccwypsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwypsresponse_lista> lista) {
		this.lista = lista;
	}
    
}