package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DesInclForFaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 17/05/16 09:25
 */
public class Npccwwxerequest_lstlis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-LST-LIS.NPCCWWXE-TIPO-PCELA-TRADE")
	private String lstlis_tipopcelatrade = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-LST-LIS.NPCCWWXE-NPCELA-DSEMB-TRADE")
	private Integer lstlis_npceladsembtrade = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-LST-LIS.NPCCWWXE-TDIA-NEGOC-PCELA")
	private Integer lstlis_tdianegocpcela = 0;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-LST-LIS.NPCCWWXE-DVCTO-PCELA-TRADE")
	private String lstlis_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWWXE-REGISTRO.NPCCWWXE-LST-LIS.NPCCWWXE-VPCELA-MESA-TRADE")
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