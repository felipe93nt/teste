package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 13:33
 */
public class Npccwymerequest_lstlis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-LST-LIS.NPCCWYME-NPCELA-COMIS-EXTER")
	private Integer lstlis_npcelacomisexter = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-LST-LIS.NPCCWYME-DVCTO-PCELA-TRADE")
	private String lstlis_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-LST-LIS.NPCCWYME-VPCELA-COMIS-CMBIO")
	private String lstlis_vpcelacomiscmbio = null;
	
	public Integer getLstlis_npcelacomisexter() {
		return lstlis_npcelacomisexter;
	}
	public void setLstlis_npcelacomisexter(Integer lstlis_npcelacomisexter) {
		this.lstlis_npcelacomisexter = lstlis_npcelacomisexter;
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
    
}