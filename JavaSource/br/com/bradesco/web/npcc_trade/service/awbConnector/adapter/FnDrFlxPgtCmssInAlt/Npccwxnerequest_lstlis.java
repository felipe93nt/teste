package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:50
 */
public class Npccwxnerequest_lstlis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-LST-LIS.NPCCWXNE-NPCELA-COMIS-INTRN")
	private Integer lstlis_npcelacomisintrn = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-LST-LIS.NPCCWXNE-DVCTO-PCELA-TRADE")
	private String lstlis_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-LST-LIS.NPCCWXNE-VPCELA-COMIS-CMBIO")
	private String lstlis_vpcelacomiscmbio = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-LST-LIS.NPCCWXNE-VCUSTO-FINCR-CMBIO")
	private String lstlis_vcustofincrcmbio = null;
	
	public Integer getLstlis_npcelacomisintrn() {
		return lstlis_npcelacomisintrn;
	}
	public void setLstlis_npcelacomisintrn(Integer lstlis_npcelacomisintrn) {
		this.lstlis_npcelacomisintrn = lstlis_npcelacomisintrn;
	}

	public String getLstlis_dvctopcelatrade() {
		return lstlis_dvctopcelatrade;
	}
	public void setLstlis_dvctopcelatrade(String lstlis_dvctopcelatrade) {
		this.lstlis_dvctopcelatrade = lstlis_dvctopcelatrade;
	}
	public String getLstlis_vpcelacomiscmbio() {
		return lstlis_vpcelacomiscmbio;
	}
	public void setLstlis_vpcelacomiscmbio(String lstlis_vpcelacomiscmbio) {
		this.lstlis_vpcelacomiscmbio = lstlis_vpcelacomiscmbio;
	}
	public String getLstlis_vcustofincrcmbio() {
		return lstlis_vcustofincrcmbio;
	}
	public void setLstlis_vcustofincrcmbio(String lstlis_vcustofincrcmbio) {
		this.lstlis_vcustofincrcmbio = lstlis_vcustofincrcmbio;
	}
    
}