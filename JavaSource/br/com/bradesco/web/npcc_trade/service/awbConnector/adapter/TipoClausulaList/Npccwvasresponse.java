package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 09/12/15 15:47
 */
public class Npccwvasresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVAS-HEADER.NPCCWVAS-COD-LAYOUT")
	private String codlayout = "NPCCWVAS";

	@Adapter(transactionField = "NPCCWVAS-HEADER.NPCCWVAS-TAM-LAYOUT")
	private Integer tamlayout = 4266;

	@Adapter(transactionField = "NPCCWVAS-REGISTRO.NPCCWVAS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVAS-REGISTRO.NPCCWVAS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList.Npccwvasresponse_lista")
	private List<Npccwvasresponse_lista> lista = null;
	
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

	public List<Npccwvasresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvasresponse_lista> lista) {
		this.lista = lista;
	}
    
}