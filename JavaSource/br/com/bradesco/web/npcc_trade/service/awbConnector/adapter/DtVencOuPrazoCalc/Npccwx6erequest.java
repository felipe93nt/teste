package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DtVencOuPrazoCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/08/16 10:24
 */
public class Npccwx6erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX6E-HEADER.NPCCWX6E-COD-LAYOUT")
	private String codlayout = "NPCCWX6E";

	@Adapter(transactionField = "NPCCWX6E-HEADER.NPCCWX6E-TAM-LAYOUT")
	private Integer tamlayout = 41;

	@Adapter(transactionField = "NPCCWX6E-REGISTRO.NPCCWX6E-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCCWX6E-REGISTRO.NPCCWX6E-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWX6E-REGISTRO.NPCCWX6E-DVCTO-PCELA-TRADE")
	private String dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWX6E-REGISTRO.NPCCWX6E-TDIA-PRZO-OPER")
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

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
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