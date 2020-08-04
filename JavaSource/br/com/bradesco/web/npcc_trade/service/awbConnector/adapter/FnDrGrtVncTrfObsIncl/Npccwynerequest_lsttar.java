package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Npccwynerequest_lsttar extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-TAR.NPCCWYNE-CINDCD-ECONM-MOE-TAR")
	private Integer lsttar_cindcdeconmmoetar = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-TAR.NPCCWYNE-CCONDC-ECONC")
	private Integer lsttar_ccondceconc = 0;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-TAR.NPCCWYNE-VTARIF-OPER-CMBIO")
	private String lsttar_vtarifopercmbio = null;
	
	public Integer getLsttar_cindcdeconmmoetar() {
		return lsttar_cindcdeconmmoetar;
	}
	public void setLsttar_cindcdeconmmoetar(Integer lsttar_cindcdeconmmoetar) {
		this.lsttar_cindcdeconmmoetar = lsttar_cindcdeconmmoetar;
	}

	public Integer getLsttar_ccondceconc() {
		return lsttar_ccondceconc;
	}
	public void setLsttar_ccondceconc(Integer lsttar_ccondceconc) {
		this.lsttar_ccondceconc = lsttar_ccondceconc;
	}

	public String getLsttar_vtarifopercmbio() {
		return lsttar_vtarifopercmbio;
	}
	public void setLsttar_vtarifopercmbio(String lsttar_vtarifopercmbio) {
		this.lsttar_vtarifopercmbio = lsttar_vtarifopercmbio;
	}
    
}