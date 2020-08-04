package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/08/18 16:26
 */
public class Npccwaterequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWATE-HEADER.NPCCWATE-COD-LAYOUT")
	private String codlayout = "NPCCWATE";

	@Adapter(transactionField = "NPCCWATE-HEADER.NPCCWATE-TAM-LAYOUT")
	private Integer tamlayout = 21;

	@Adapter(transactionField = "NPCCWATE-REGISTRO.NPCCWATE-E-CPRODT-SERVC")
	private Integer ecprodtservc = 0;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public Integer getEcprodtservc() {
		return ecprodtservc;
	}
	public void setEcprodtservc(Integer ecprodtservc) {
		this.ecprodtservc = ecprodtservc;
	}
    
}