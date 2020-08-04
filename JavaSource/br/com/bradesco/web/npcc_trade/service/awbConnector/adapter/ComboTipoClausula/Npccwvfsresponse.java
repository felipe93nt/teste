package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 05/01/16 16:05
 */
public class Npccwvfsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVFS-HEADER.NPCCWVFS-COD-LAYOUT")
	private String codlayout = "NPCCWVFS";

	@Adapter(transactionField = "NPCCWVFS-HEADER.NPCCWVFS-TAM-LAYOUT")
	private Integer tamlayout = 4266;

	@Adapter(transactionField = "NPCCWVFS-REGISTRO.NPCCWVFS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVFS-REGISTRO.NPCCWVFS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTipoClausula.Npccwvfsresponse_lista")
	private List<Npccwvfsresponse_lista> lista = null;
	
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

	public List<Npccwvfsresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvfsresponse_lista> lista) {
		this.lista = lista;
	}
    
}