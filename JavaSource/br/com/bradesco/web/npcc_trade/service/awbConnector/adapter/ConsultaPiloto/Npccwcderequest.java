package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaPiloto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 15/05/17 16:44
 */
public class Npccwcderequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWCDE-HEADER.NPCCWCDE-COD-LAYOUT")
	private String codlayout = "NPCCWCDE";

	@Adapter(transactionField = "NPCCWCDE-HEADER.NPCCWCDE-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCWCDE-REGISTRO.NPCCWCDE-CUNIC-CLI-CMBIO")
	private Long cunicclicmbio = 0L;
	
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

	public Long getCunicclicmbio() {
		return cunicclicmbio;
	}
	public void setCunicclicmbio(Long cunicclicmbio) {
		this.cunicclicmbio = cunicclicmbio;
	}
    
}