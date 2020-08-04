package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/04/18 15:27
 */
public class Npccwk7sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA.NPCCWK7S-CCARAC-TPO-GARNT")
	private Integer lista_ccaractpogarnt = 0;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA.NPCCWK7S-ICARAC-TPO-GARNT")
	private String lista_icaractpogarnt = null;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA.NPCCWK7S-VTX-GARNT-CMBIO")
	private Double lista_vtxgarntcmbio = 0D;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA.NPCCWK7S-CINDCD-GARNT-PRINC")
	private String lista_cindcdgarntprinc = null;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA.NPCCWK7S-CINDCD-ECONM-MOE-GAR")
	private Integer lista_cindcdeconmmoegar = 0;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA.NPCCWK7S-DVCTO-GARANT-CMBIO")
	private String lista_dvctogarantcmbio = null;

	@Adapter(transactionField = "NPCCWK7S-REGISTRO.NPCCWK7S-LISTA.NPCCWK7S-CINDCD-DESCR-MOE-GAR")
	private String lista_cindcddescrmoegar = null;
	
	public Integer getLista_ccaractpogarnt() {
		return lista_ccaractpogarnt;
	}
	public void setLista_ccaractpogarnt(Integer lista_ccaractpogarnt) {
		this.lista_ccaractpogarnt = lista_ccaractpogarnt;
	}

	public String getLista_icaractpogarnt() {
		return lista_icaractpogarnt;
	}
	public void setLista_icaractpogarnt(String lista_icaractpogarnt) {
		this.lista_icaractpogarnt = lista_icaractpogarnt;
	}

	public Double getLista_vtxgarntcmbio() {
		return lista_vtxgarntcmbio;
	}
	public void setLista_vtxgarntcmbio(Double lista_vtxgarntcmbio) {
		this.lista_vtxgarntcmbio = lista_vtxgarntcmbio;
	}

	public String getLista_cindcdgarntprinc() {
		return lista_cindcdgarntprinc;
	}
	public void setLista_cindcdgarntprinc(String lista_cindcdgarntprinc) {
		this.lista_cindcdgarntprinc = lista_cindcdgarntprinc;
	}

	public Integer getLista_cindcdeconmmoegar() {
		return lista_cindcdeconmmoegar;
	}
	public void setLista_cindcdeconmmoegar(Integer lista_cindcdeconmmoegar) {
		this.lista_cindcdeconmmoegar = lista_cindcdeconmmoegar;
	}

	public String getLista_dvctogarantcmbio() {
		return lista_dvctogarantcmbio;
	}
	public void setLista_dvctogarantcmbio(String lista_dvctogarantcmbio) {
		this.lista_dvctogarantcmbio = lista_dvctogarantcmbio;
	}

	public String getLista_cindcddescrmoegar() {
		return lista_cindcddescrmoegar;
	}
	public void setLista_cindcddescrmoegar(String lista_cindcddescrmoegar) {
		this.lista_cindcddescrmoegar = lista_cindcddescrmoegar;
	}
    
}