package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiaadiclist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/04/18 11:48
 */
public class Npccwdgsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA.NPCCWDGS-CCATLG-GARNT")
	private Integer lista_ccatlggarnt = 0;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA.NPCCWDGS-NGARNT-CMBIO")
	private Integer lista_ngarntcmbio = 0;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA.NPCCWDGS-ICARAC-TPO-GARNT")
	private String lista_icaractpogarnt = null;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA.NPCCWDGS-VTX-GARNT-CMBIO")
	private Double lista_vtxgarntcmbio = 0D;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA.NPCCWDGS-RCOMPL-GARNT-CMBIO")
	private String lista_rcomplgarntcmbio = null;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA.NPCCWDGS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWDGS-REGISTRO.NPCCWDGS-LISTA.NPCCWDGS-CINDDS-ECONM-MOEDA")
	private String lista_cinddseconmmoeda = null;
	
	public Integer getLista_ccatlggarnt() {
		return lista_ccatlggarnt;
	}
	public void setLista_ccatlggarnt(Integer lista_ccatlggarnt) {
		this.lista_ccatlggarnt = lista_ccatlggarnt;
	}

	public Integer getLista_ngarntcmbio() {
		return lista_ngarntcmbio;
	}
	public void setLista_ngarntcmbio(Integer lista_ngarntcmbio) {
		this.lista_ngarntcmbio = lista_ngarntcmbio;
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