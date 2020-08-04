package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/07/16 15:39
 */
public class Npccwmperequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMPE-HEADER.NPCCWMPE-COD-LAYOUT")
	private String codlayout = "NPCCWMPE";

	@Adapter(transactionField = "NPCCWMPE-HEADER.NPCCWMPE-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCWMPE-REGISTRO.NPCCWMPE-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;
	
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

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}
    
}