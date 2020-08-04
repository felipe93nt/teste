package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrGrtVncTrfObsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/11/16 16:40
 */
public class Npccwzxerequest_lstava extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZXE-REGISTRO.NPCCWZXE-LST-AVA.NPCCWZXE-CUNIC-PSSOA-CMBIO")
	private Long lstava_cunicpssoacmbio = 0L;
	
	public Long getLstava_cunicpssoacmbio() {
		return lstava_cunicpssoacmbio;
	}
	public void setLstava_cunicpssoacmbio(Long lstava_cunicpssoacmbio) {
		this.lstava_cunicpssoacmbio = lstava_cunicpssoacmbio;
	}
    
}