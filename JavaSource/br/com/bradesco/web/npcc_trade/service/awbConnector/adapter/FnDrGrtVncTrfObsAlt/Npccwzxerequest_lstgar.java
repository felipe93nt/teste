package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 16:40
 */
public class Npccwzxerequest_lstgar extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-NGARNT-CMBIO")
	private Integer lstgar_ngarntcmbio = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-CCATLG-GARNT")
	private Integer lstgar_ccatlggarnt = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-CINDCD-ECONM-MOE-GAR")
	private Integer lstgar_cindcdeconmmoegar = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-VTX-GARNT-CMBIO")
	private String lstgar_vtxgarntcmbio = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-DVCTO-GARNT-CMBIO")
	private String lstgar_dvctogarntcmbio = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-CINDCD-GARNT-PRINC")
	private String lstgar_cindcdgarntprinc = null;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-CIDTFD-GARNT-ADCIO")
	private Integer lstgar_cidtfdgarntadcio = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-GAR.NPCCWZXE-RCOMPL-GARNT-CMBIO")
	private String lstgar_rcomplgarntcmbio = null;
	
	public Integer getLstgar_ngarntcmbio() {
		return lstgar_ngarntcmbio;
	}
	public void setLstgar_ngarntcmbio(Integer lstgar_ngarntcmbio) {
		this.lstgar_ngarntcmbio = lstgar_ngarntcmbio;
	}

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