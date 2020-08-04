package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/06/18 09:46
 */
public class Npccwvmerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVME-HEADER.NPCCWVME-COD-LAYOUT")
	private String codlayout = "NPCCWVME";

	@Adapter(transactionField = "NPCCWVME-HEADER.NPCCWVME-TAM-LAYOUT")
	private Integer tamlayout = 71;

	@Adapter(transactionField = "NPCCWVME-REGISTRO.NPCCWVME-CPRODT-SERV")
	private Integer cprodtserv = 0;

	@Adapter(transactionField = "NPCCWVME-REGISTRO.NPCCWVME-IMOD-CONTR-CMBIO")
	private String imodcontrcmbio = null;
	
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

	public Integer getCprodtserv() {
		return cprodtserv;
	}
	public void setCprodtserv(Integer cprodtserv) {
		this.cprodtserv = cprodtserv;
	}

	public String getImodcontrcmbio() {
		return imodcontrcmbio;
	}
	public void setImodcontrcmbio(String imodcontrcmbio) {
		this.imodcontrcmbio = imodcontrcmbio;
	}
    
}