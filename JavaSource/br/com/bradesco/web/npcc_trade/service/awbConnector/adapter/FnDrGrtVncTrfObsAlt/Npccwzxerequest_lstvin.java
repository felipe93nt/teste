package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 16:40
 */
public class Npccwzxerequest_lstvin extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-VIN.NPCCWZXE-NBLETO-NEGOC-VNCLO")
	private Long lstvin_nbletonegocvnclo = 0L;

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-VIN.NPCCWZXE-CINDCD-VNCLO-IMPOR")
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