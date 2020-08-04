package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Npccwynerequest_lstvin extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-VIN.NPCCWYNE-NBLETO-NEGOC-VNCLO")
	private Long lstvin_nbletonegocvnclo = 0L;

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-VIN.NPCCWYNE-CINDCD-VNCLO-IMPOR")
	private String lstvin_cindcdvncloimpor = null;
	
	public Long getLstvin_nbletonegocvnclo() {
		return lstvin_nbletonegocvnclo;
	}
	public void setLstvin_nbletonegocvnclo(Long lstvin_nbletonegocvnclo) {
		this.lstvin_nbletonegocvnclo = lstvin_nbletonegocvnclo;
	}

	public String getLstvin_cindcdvncloimpor() {
		return lstvin_cindcdvncloimpor;
	}
	public void setLstvin_cindcdvncloimpor(String lstvin_cindcdvncloimpor) {
		this.lstvin_cindcdvncloimpor = lstvin_cindcdvncloimpor;
	}
    
}