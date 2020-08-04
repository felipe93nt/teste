package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboProduto;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/02/16 14:44
 */
public class Npccwiaerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIAE-HEADER.NPCCWIAE-COD-LAYOUT")
	private String codlayout = "NPCCWIAE";

	@Adapter(transactionField = "NPCCWIAE-HEADER.NPCCWIAE-TAM-LAYOUT")
	private Integer tamlayout = 16;

	@Adapter(transactionField = "NPCCWIAE-REGISTRO.NPCCWIAE-CIDTFD-MESA-CMBIO")
	private Integer cidtfdmesacmbio = 0;

	@Adapter(transactionField = "NPCCWIAE-REGISTRO.NPCCWIAE-CCMBIO-PRODT-FUTUR")
	private Integer ccmbioprodtfutur = 0;

	@Adapter(transactionField = "NPCCWIAE-REGISTRO.NPCCWIAE-CCOMCZ-PRODT-CMBIO")
	private Integer ccomczprodtcmbio = 0;
	
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

	public Integer getCidtfdmesacmbio() {
		return cidtfdmesacmbio;
	}
	public void setCidtfdmesacmbio(Integer cidtfdmesacmbio) {
		this.cidtfdmesacmbio = cidtfdmesacmbio;
	}

	public Integer getCcmbioprodtfutur() {
		return ccmbioprodtfutur;
	}
	public void setCcmbioprodtfutur(Integer ccmbioprodtfutur) {
		this.ccmbioprodtfutur = ccmbioprodtfutur;
	}

	public Integer getCcomczprodtcmbio() {
		return ccomczprodtcmbio;
	}
	public void setCcomczprodtcmbio(Integer ccomczprodtcmbio) {
		this.ccomczprodtcmbio = ccomczprodtcmbio;
	}
    
}