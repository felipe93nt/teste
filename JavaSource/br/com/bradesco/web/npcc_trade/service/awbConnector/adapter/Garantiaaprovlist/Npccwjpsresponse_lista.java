package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaaprovlist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/09/18 19:00
 */
public class Npccwjpsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-CCATLG-GARNT")
	private Integer lista_ccatlggarnt = 0;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-ICARAC-TPO-GARNT")
	private String lista_icaractpogarnt = null;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-VTX-GARNT-CMBIO")
	private Double lista_vtxgarntcmbio = 0D;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-CINDCD-GARNT-PRINC")
	private String lista_cindcdgarntprinc = null;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-CIDTFD-GARNT-ADCIO")
	private Integer lista_cidtfdgarntadcio = 0;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-RCOMPL-GARNT-CMBIO")
	private String lista_rcomplgarntcmbio = null;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWJPS-REGISTRO.NPCCWJPS-LISTA.NPCCWJPS-CINDDS-ECONM-MOEDA")
	private String lista_cinddseconmmoeda = null;
	
	public Integer getLista_ccatlggarnt() {
		return lista_ccatlggarnt;
	}
	public void setLista_ccatlggarnt(Integer lista_ccatlggarnt) {
		this.lista_ccatlggarnt = lista_ccatlggarnt;
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

	public Integer getLista_cidtfdgarntadcio() {
		return lista_cidtfdgarntadcio;
	}
	public void setLista_cidtfdgarntadcio(Integer lista_cidtfdgarntadcio) {
		this.lista_cidtfdgarntadcio = lista_cidtfdgarntadcio;
	}

	public String getLista_rcomplgarntcmbio() {
		return lista_rcomplgarntcmbio;
	}
	public void setLista_rcomplgarntcmbio(String lista_rcomplgarntcmbio) {
		this.lista_rcomplgarntcmbio = lista_rcomplgarntcmbio;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_cinddseconmmoeda() {
		return lista_cinddseconmmoeda;
	}
	public void setLista_cinddseconmmoeda(String lista_cinddseconmmoeda) {
		this.lista_cinddseconmmoeda = lista_cinddseconmmoeda;
	}
    
}