package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/03/17 09:38
 */
public class Npccwxxerequest_lstcadis extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXXE-REGISTRO.NPCCWXXE-LST-CADIS.NPCCWXXE-VLR-COMIS-ADIC")
	private String lstcadis_vlrcomisadic = null;
	
	public String getLstcadis_vlrcomisadic() {
		return lstcadis_vlrcomisadic;
	}
	public void setLstcadis_vlrcomisadic(String lstcadis_vlrcomisadic) {
		this.lstcadis_vlrcomisadic = lstcadis_vlrcomisadic;
	}
    
}