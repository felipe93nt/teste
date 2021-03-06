package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:41
 */
public class Npccwylerequest_lstlis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-LST-LIS.NPCCWYLE-NPCELA-COMIS-INTRN")
	private Integer lstlis_npcelacomisintrn = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-LST-LIS.NPCCWYLE-DVCTO-PCELA-TRADE")
	private String lstlis_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-LST-LIS.NPCCWYLE-VPCELA-COMIS-CMBIO")
	private String lstlis_vpcelacomiscmbio = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-LST-LIS.NPCCWYLE-VCUSTO-FINCR-CMBIO")
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