package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FLXPGTPRCJRSINCLFAKE;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/10/16 09:46
 */
public class Npccwwgerequest_lstlis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-LST-LIS.NPCCWWGE-TIPO-PCELA-TRADE")
	private String lstlis_tipopcelatrade = null;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-LST-LIS.NPCCWWGE-NPCELA-DSEMB-TRADE")
	private Integer lstlis_npceladsembtrade = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-LST-LIS.NPCCWWGE-TDIA-NEGOC-PCELA")
	private Integer lstlis_tdianegocpcela = 0;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-LST-LIS.NPCCWWGE-DVCTO-PCELA-TRADE")
	private String lstlis_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWWGE-REGISTRO.NPCCWWGE-LST-LIS.NPCCWWGE-VPCELA-MESA-TRADE")
	private String lstlis_vpcelamesatrade = null;
	
	public String getLstlis_tipopcelatrade() {
		return lstlis_tipopcelatrade;
	}
	public void setLstlis_tipopcelatrade(String lstlis_tipopcelatrade) {
		this.lstlis_tipopcelatrade = lstlis_tipopcelatrade;
	}

	public Integer getLstlis_npceladsembtrade() {
		return lstlis_npceladsembtrade;
	}
	public void setLstlis_npceladsembtrade(Integer lstlis_npceladsembtrade) {
		this.lstlis_npceladsembtrade = lstlis_npceladsembtrade;
	}

	public Integer getLstlis_tdianegocpcela() {
		return lstlis_tdianegocpcela;
	}
	public void setLstlis_tdianegocpcela(Integer lstlis_tdianegocpcela) {
		this.lstlis_tdianegocpcela = lstlis_tdianegocpcela;
	}

	public String getLstlis_dvctopcelatrade() {
		return lstlis_dvctopcelatrade;
	}
	public void setLstlis_dvctopcelatrade(String lstlis_dvctopcelatrade) {
		this.lstlis_dvctopcelatrade = lstlis_dvctopcelatrade;
	}

	public String getLstlis_vpcelamesatrade() {
		return lstlis_vpcelamesatrade;
	}
	public void setLstlis_vpcelamesatrade(String lstlis_vpcelamesatrade) {
		this.lstlis_vpcelamesatrade = lstlis_vpcelamesatrade;
	}
    
}