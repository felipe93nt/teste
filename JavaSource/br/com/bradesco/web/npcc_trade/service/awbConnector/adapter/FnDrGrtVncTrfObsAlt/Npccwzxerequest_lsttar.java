package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 16:40
 */
public class Npccwzxerequest_lsttar extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-TAR.NPCCWZXE-CINDCD-ECONM-MOE-TAR")
	private Integer lsttar_cindcdeconmmoetar = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-TAR.NPCCWZXE-CCONDC-ECONC")
	private Integer lsttar_ccondceconc = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-TAR.NPCCWZXE-NTARIF-BLETO-CMBIO")
	private Integer lsttar_ntarifbletocmbio = 0;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-TAR.NPCCWZXE-VTARIF-OPER-CMBIO")
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

	public Integer getLsttar_ntarifbletocmbio() {
		return lsttar_ntarifbletocmbio;
	}
	public void setLsttar_ntarifbletocmbio(Integer lsttar_ntarifbletocmbio) {
		this.lsttar_ntarifbletocmbio = lsttar_ntarifbletocmbio;
	}

	public String getLsttar_vtarifopercmbio() {
		return lsttar_vtarifopercmbio;
	}
	public void setLsttar_vtarifopercmbio(String lsttar_vtarifopercmbio) {
		this.lsttar_vtarifopercmbio = lsttar_vtarifopercmbio;
	}
    
}