package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 15/06/18 13:32
 */
public class Npccwvperequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVPE-HEADER.NPCCWVPE-COD-LAYOUT")
	private String codlayout = "NPCCWVPE";

	@Adapter(transactionField = "NPCCWVPE-HEADER.NPCCWVPE-TAM-LAYOUT")
	private Integer tamlayout = 480;

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-IMOD-CONTR-CMBIO")
	private String imodcontrcmbio = null;

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-CINDCD-MOD-PDRAO")
	private String cindcdmodpdrao = null;

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWVPE-REGISTRO.NPCCWVPE-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt.Npccwvperequest_lista")
	private List<Npccwvperequest_lista> lista = null;
	
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

	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}

	public String getImodcontrcmbio() {
		return imodcontrcmbio;
	}
	public void setImodcontrcmbio(String imodcontrcmbio) {
		this.imodcontrcmbio = imodcontrcmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getCindcdmodpdrao() {
		return cindcdmodpdrao;
	}
	public void setCindcdmodpdrao(String cindcdmodpdrao) {
		this.cindcdmodpdrao = cindcdmodpdrao;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwvperequest_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwvperequest_lista> lista) {
		this.lista = lista;
	}
    
}