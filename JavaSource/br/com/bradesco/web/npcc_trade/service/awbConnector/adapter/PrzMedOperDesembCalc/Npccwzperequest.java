package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 10/07/16 16:42
 */
public class Npccwzperequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZPE-HEADER.NPCCWZPE-COD-LAYOUT")
	private String codlayout = "NPCCWZPE";

	@Adapter(transactionField = "NPCCWZPE-HEADER.NPCCWZPE-TAM-LAYOUT")
	private Integer tamlayout = 9650;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-QTDE-OCORR-PCELA")
	private Integer qtdeocorrpcela = 0;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-QTDE-OCORR-PRZOM")
	private Integer qtdeocorrprzom = 0;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PC", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Npccwzperequest_listapc")
	private List<Npccwzperequest_listapc> listapc = null;

	@Adapter(transactionField = "NPCCWZPE-REGISTRO.NPCCWZPE-LISTA-PR", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrzMedOperDesembCalc.Npccwzperequest_listapr")
	private List<Npccwzperequest_listapr> listapr = null;
	
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

	public Integer getQtdeocorrpcela() {
		return qtdeocorrpcela;
	}
	public void setQtdeocorrpcela(Integer qtdeocorrpcela) {
		this.qtdeocorrpcela = qtdeocorrpcela;
	}

	public Integer getQtdeocorrprzom() {
		return qtdeocorrprzom;
	}
	public void setQtdeocorrprzom(Integer qtdeocorrprzom) {
		this.qtdeocorrprzom = qtdeocorrprzom;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public List<Npccwzperequest_listapc> getListapc() {
		return listapc;
	}
	public void setListapc( List<Npccwzperequest_listapc> listapc) {
		this.listapc = listapc;
	}

	public List<Npccwzperequest_listapr> getListapr() {
		return listapr;
	}
	public void setListapr( List<Npccwzperequest_listapr> listapr) {
		this.listapr = listapr;
	}
    
}