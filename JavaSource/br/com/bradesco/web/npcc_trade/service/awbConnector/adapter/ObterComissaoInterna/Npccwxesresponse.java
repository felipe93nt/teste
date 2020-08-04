package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 06/04/17 09:29
 */
public class Npccwxesresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXES-HEADER.NPCCWXES-COD-LAYOUT")
	private String codlayout = "NPCCWXES";

	@Adapter(transactionField = "NPCCWXES-HEADER.NPCCWXES-TAM-LAYOUT")
	private Integer tamlayout = 3913;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-VPREVT-COMIS-TOTAL")
	private String vprevtcomistotal = null;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWXES-REGISTRO.NPCCWXES-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterComissaoInterna.Npccwxesresponse_lista")
	private List<Npccwxesresponse_lista> lista = null;
	
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

	public String getVprevtcomistotal() {
		return vprevtcomistotal;
	}
	public void setVprevtcomistotal(String vprevtcomistotal) {
		this.vprevtcomistotal = vprevtcomistotal;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwxesresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwxesresponse_lista> lista) {
		this.lista = lista;
	}
    
}