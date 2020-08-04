package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Npccwmnerequest_listaspread extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMNE-REGISTRO.NPCCWMNE-LISTA-SPREAD.NPCCWMNE-SPREAD-DESEMB")
	private Double listaspread_spreaddesemb = 0D;
	
	public Double getListaspread_spreaddesemb() {
		return listaspread_spreaddesemb;
	}
	public void setListaspread_spreaddesemb(Double listaspread_spreaddesemb) {
		this.listaspread_spreaddesemb = listaspread_spreaddesemb;
	}
    
}