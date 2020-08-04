package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:43
 */
public class Npccwxserequest_lstlis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-LST-LIS.NPCCWXSE-NPCELA-COMIS-EXTER")
	private Integer lstlis_npcelacomisexter = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-LST-LIS.NPCCWXSE-DVCTO-PCELA-TRADE")
	private String lstlis_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-LST-LIS.NPCCWXSE-VPCELA-COMIS-CMBIO")
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
    /**
     * @return o valor do lstlis_vpcelacomiscmbio
     */
    public String getLstlis_vpcelacomiscmbio() {
        return lstlis_vpcelacomiscmbio;
    }
    /**
     * @param lstlis_vpcelacomiscmbio seta o novo valor para o campo lstlis_vpcelacomiscmbio
     */
    public void setLstlis_vpcelacomiscmbio(String lstlis_vpcelacomiscmbio) {
        this.lstlis_vpcelacomiscmbio = lstlis_vpcelacomiscmbio;
    }

}