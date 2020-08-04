package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboDataDesembolso;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/05/16 12:41
 */
public class Npccwx7sresponse_listadtdsemb extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX7S-SAIDA.NPCCWX7S-LISTA-DT-DSEMB.NPCCWX7S-NDSEMB-CMBIO-TRADE")
	private Integer listadtdsemb_ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWX7S-SAIDA.NPCCWX7S-LISTA-DT-DSEMB.NPCCWX7S-DPREVT-DSEMB-CMBIO")
	private String listadtdsemb_dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWX7S-SAIDA.NPCCWX7S-LISTA-DT-DSEMB.NPCCWX7S-TDIA-FINAN-DSEMB")
	private Integer listadtdsemb_tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWX7S-SAIDA.NPCCWX7S-LISTA-DT-DSEMB.NPCCWX7S-VPREVT-DSEMB-CMBIO")
	private String listadtdsemb_vprevtdsembcmbio = null;
	
	public Integer getListadtdsemb_ndsembcmbiotrade() {
		return listadtdsemb_ndsembcmbiotrade;
	}
	public void setListadtdsemb_ndsembcmbiotrade(Integer listadtdsemb_ndsembcmbiotrade) {
		this.listadtdsemb_ndsembcmbiotrade = listadtdsemb_ndsembcmbiotrade;
	}

	public String getListadtdsemb_dprevtdsembcmbio() {
		return listadtdsemb_dprevtdsembcmbio;
	}
	public void setListadtdsemb_dprevtdsembcmbio(String listadtdsemb_dprevtdsembcmbio) {
		this.listadtdsemb_dprevtdsembcmbio = listadtdsemb_dprevtdsembcmbio;
	}

	public Integer getListadtdsemb_tdiafinandsemb() {
		return listadtdsemb_tdiafinandsemb;
	}
	public void setListadtdsemb_tdiafinandsemb(Integer listadtdsemb_tdiafinandsemb) {
		this.listadtdsemb_tdiafinandsemb = listadtdsemb_tdiafinandsemb;
	}

	public String getListadtdsemb_vprevtdsembcmbio() {
		return listadtdsemb_vprevtdsembcmbio;
	}
	public void setListadtdsemb_vprevtdsembcmbio(String listadtdsemb_vprevtdsembcmbio) {
		this.listadtdsemb_vprevtdsembcmbio = listadtdsemb_vprevtdsembcmbio;
	}
    
}