package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaLog;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/09/18 16:07
 */
public class Npccwaxerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWAXE-HEADER.NPCCWAXE-COD-LAYOUT")
	private String codlayout = "NPCCWAXE";

	@Adapter(transactionField = "NPCCWAXE-HEADER.NPCCWAXE-TAM-LAYOUT")
	private Integer tamlayout = 33;

	@Adapter(transactionField = "NPCCWAXE-REGISTRO.NPCCWAXE-E-DTINICI")
	private String edtinici = null;

	@Adapter(transactionField = "NPCCWAXE-REGISTRO.NPCCWAXE-E-DTFINAL")
	private String edtfinal = null;
	
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

	public String getEdtinici() {
		return edtinici;
	}
	public void setEdtinici(String edtinici) {
		this.edtinici = edtinici;
	}

	public String getEdtfinal() {
		return edtfinal;
	}
	public void setEdtfinal(String edtfinal) {
		this.edtfinal = edtfinal;
	}
    
}