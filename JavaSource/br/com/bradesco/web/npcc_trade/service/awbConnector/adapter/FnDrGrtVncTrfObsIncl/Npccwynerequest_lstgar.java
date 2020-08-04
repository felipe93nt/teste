package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Npccwynerequest_lstgar extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR.NPCCWYNE-CCATLG-GARNT")
	private Integer lstgar_ccatlggarnt = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR.NPCCWYNE-CINDCD-ECONM-MOE-GAR")
	private Integer lstgar_cindcdeconmmoegar = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR.NPCCWYNE-VTX-GARNT-CMBIO")
	private String lstgar_vtxgarntcmbio = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR.NPCCWYNE-DVCTO-GARNT-CMBIO")
	private String lstgar_dvctogarntcmbio = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR.NPCCWYNE-CINDCD-GARNT-PRINC")
	private String lstgar_cindcdgarntprinc = null;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR.NPCCWYNE-CIDTFD-GARNT-ADCIO")
	private Integer lstgar_cidtfdgarntadcio = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-GAR.NPCCWYNE-RCOMPL-GARNT-CMBIO")
	private String lstgar_rcomplgarntcmbio = null;
	
	public Integer getLstgar_ccatlggarnt() {
		return lstgar_ccatlggarnt;
	}
	public void setLstgar_ccatlggarnt(Integer lstgar_ccatlggarnt) {
		this.lstgar_ccatlggarnt = lstgar_ccatlggarnt;
	}

	public Integer getLstgar_cindcdeconmmoegar() {
		return lstgar_cindcdeconmmoegar;
	}
	public void setLstgar_cindcdeconmmoegar(Integer lstgar_cindcdeconmmoegar) {
		this.lstgar_cindcdeconmmoegar = lstgar_cindcdeconmmoegar;
	}

	public String getLstgar_vtxgarntcmbio() {
		return lstgar_vtxgarntcmbio;
	}
	public void setLstgar_vtxgarntcmbio(String lstgar_vtxgarntcmbio) {
		this.lstgar_vtxgarntcmbio = lstgar_vtxgarntcmbio;
	}

	public String getLstgar_dvctogarntcmbio() {
		return lstgar_dvctogarntcmbio;
	}
	public void setLstgar_dvctogarntcmbio(String lstgar_dvctogarntcmbio) {
		this.lstgar_dvctogarntcmbio = lstgar_dvctogarntcmbio;
	}

	public String getLstgar_cindcdgarntprinc() {
		return lstgar_cindcdgarntprinc;
	}
	public void setLstgar_cindcdgarntprinc(String lstgar_cindcdgarntprinc) {
		this.lstgar_cindcdgarntprinc = lstgar_cindcdgarntprinc;
	}

	public Integer getLstgar_cidtfdgarntadcio() {
		return lstgar_cidtfdgarntadcio;
	}
	public void setLstgar_cidtfdgarntadcio(Integer lstgar_cidtfdgarntadcio) {
		this.lstgar_cidtfdgarntadcio = lstgar_cidtfdgarntadcio;
	}

	public String getLstgar_rcomplgarntcmbio() {
		return lstgar_rcomplgarntcmbio;
	}
	public void setLstgar_rcomplgarntcmbio(String lstgar_rcomplgarntcmbio) {
		this.lstgar_rcomplgarntcmbio = lstgar_rcomplgarntcmbio;
	}
    
}