package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/08/16 10:24
 */
public class Npccwx6sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX6S-HEADER.NPCCWX6S-COD-LAYOUT")
	private String codlayout = "NPCCWX6S";

	@Adapter(transactionField = "NPCCWX6S-HEADER.NPCCWX6S-TAM-LAYOUT")
	private Integer tamlayout = 28;

	@Adapter(transactionField = "NPCCWX6S-REGISTRO.NPCCWX6S-DVCTO-PCELA-TRADE")
	private String dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWX6S-REGISTRO.NPCCWX6S-TDIA-PRZO-OPER")
	private Integer tdiaprzooper = 0;
	
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

	public String getDvctopcelatrade() {
		return dvctopcelatrade;
	}
	public void setDvctopcelatrade(String dvctopcelatrade) {
		this.dvctopcelatrade = dvctopcelatrade;
	}

	public Integer getTdiaprzooper() {
		return tdiaprzooper;
	}
	public void setTdiaprzooper(Integer tdiaprzooper) {
		this.tdiaprzooper = tdiaprzooper;
	}
    
}