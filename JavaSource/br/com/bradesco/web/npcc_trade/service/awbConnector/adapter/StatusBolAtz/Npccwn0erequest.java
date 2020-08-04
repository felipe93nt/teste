package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.StatusBolAtz;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/10/16 10:26
 */
public class Npccwn0erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWN0E-HEADER.NPCCWN0E-COD-LAYOUT")
	private String codlayout = "NPCCWN0E";

	@Adapter(transactionField = "NPCCWN0E-HEADER.NPCCWN0E-TAM-LAYOUT")
	private Integer tamlayout = 73;

	@Adapter(transactionField = "NPCCWN0E-REGISTRO.NPCCWN0E-E-NBLETO-NEGOC-CMBIO")
	private Long enbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWN0E-REGISTRO.NPCCWN0E-E-STATUS-BLETO-CMBIO")
	private Integer estatusbletocmbio = 0;

	@Adapter(transactionField = "NPCCWN0E-REGISTRO.NPCCWN0E-E-STATUS-BLETO-ANTER")
	private Integer estatusbletoanter = 0;

	@Adapter(transactionField = "NPCCWN0E-REGISTRO.NPCCWN0E-E-VULT-ESTRN-BAIXA")
	private String evultestrnbaixa = null;

	@Adapter(transactionField = "NPCCWN0E-REGISTRO.NPCCWN0E-E-SALD-BLETO-CMBIO")
	private String esaldbletocmbio = null;

	@Adapter(transactionField = "NPCCWN0E-REGISTRO.NPCCWN0E-E-CINDCD-MOEDA-UTLZD")
	private Integer ecindcdmoedautlzd = 0;

	@Adapter(transactionField = "NPCCWN0E-REGISTRO.NPCCWN0E-E-TMAX-CONTR-PRODT")
	private Integer etmaxcontrprodt = 0;
	
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

	public Long getEnbletonegoccmbio() {
		return enbletonegoccmbio;
	}
	public void setEnbletonegoccmbio(Long enbletonegoccmbio) {
		this.enbletonegoccmbio = enbletonegoccmbio;
	}

	public Integer getEstatusbletocmbio() {
		return estatusbletocmbio;
	}
	public void setEstatusbletocmbio(Integer estatusbletocmbio) {
		this.estatusbletocmbio = estatusbletocmbio;
	}

	public Integer getEstatusbletoanter() {
		return estatusbletoanter;
	}
	public void setEstatusbletoanter(Integer estatusbletoanter) {
		this.estatusbletoanter = estatusbletoanter;
	}

	public String getEvultestrnbaixa() {
		return evultestrnbaixa;
	}
	public void setEvultestrnbaixa(String evultestrnbaixa) {
		this.evultestrnbaixa = evultestrnbaixa;
	}

	public String getEsaldbletocmbio() {
		return esaldbletocmbio;
	}
	public void setEsaldbletocmbio(String esaldbletocmbio) {
		this.esaldbletocmbio = esaldbletocmbio;
	}

	public Integer getEcindcdmoedautlzd() {
		return ecindcdmoedautlzd;
	}
	public void setEcindcdmoedautlzd(Integer ecindcdmoedautlzd) {
		this.ecindcdmoedautlzd = ecindcdmoedautlzd;
	}

	public Integer getEtmaxcontrprodt() {
		return etmaxcontrprodt;
	}
	public void setEtmaxcontrprodt(Integer etmaxcontrprodt) {
		this.etmaxcontrprodt = etmaxcontrprodt;
	}
    
}