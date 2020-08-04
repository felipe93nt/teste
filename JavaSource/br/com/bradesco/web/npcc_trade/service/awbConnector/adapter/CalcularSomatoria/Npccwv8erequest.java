package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CalcularSomatoria;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/06/16 15:09
 */
public class Npccwv8erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV8E-HEADER.NPCCWV8E-COD-LAYOUT")
	private String codlayout = "NPCCWV8E";

	@Adapter(transactionField = "NPCCWV8E-HEADER.NPCCWV8E-TAM-LAYOUT")
	private Integer tamlayout = 39;

	@Adapter(transactionField = "NPCCWV8E-REGISTRO.NPCCWV8E-PJURO-NEGOC-CMBIO")
	private Double pjuronegoccmbio = 0D;

	@Adapter(transactionField = "NPCCWV8E-REGISTRO.NPCCWV8E-PAGTE-FINCR-CMBIO")
	private Double pagtefincrcmbio = 0D;
	
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

	public Double getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(Double pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public Double getPagtefincrcmbio() {
		return pagtefincrcmbio;
	}
	public void setPagtefincrcmbio(Double pagtefincrcmbio) {
		this.pagtefincrcmbio = pagtefincrcmbio;
	}
    
}