package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CustoTotalForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:58
 */
public class Npccwzierequest_lstcadis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZIE-REGISTRO.NPCCWZIE-LST-CADIS.NPCCWZIE-VLR-COMIS-ADIC")
	private String lstcadis_vlrcomisadic = null;
	
	public String getLstcadis_vlrcomisadic() {
		return lstcadis_vlrcomisadic;
	}
	public void setLstcadis_vlrcomisadic(String lstcadis_vlrcomisadic) {
		this.lstcadis_vlrcomisadic = lstcadis_vlrcomisadic;
	}
    
}