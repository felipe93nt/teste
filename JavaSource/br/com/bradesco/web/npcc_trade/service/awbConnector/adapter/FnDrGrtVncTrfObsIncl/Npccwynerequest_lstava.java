package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/02/17 13:29
 */
public class Npccwynerequest_lstava extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYNE-REGISTRO.NPCCWYNE-LST-AVA.NPCCWYNE-CUNIC-PSSOA-CMBIO")
	private Long lstava_cunicpssoacmbio = 0L;
	
	public Long getLstava_cunicpssoacmbio() {
		return lstava_cunicpssoacmbio;
	}
	public void setLstava_cunicpssoacmbio(Long lstava_cunicpssoacmbio) {
		this.lstava_cunicpssoacmbio = lstava_cunicpssoacmbio;
	}
    
}