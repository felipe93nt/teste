package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PrevisaoProrrogacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/05/16 19:33
 */
public class Npccwx9sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX9S-HEADER.NPCCWX9S-COD-LAYOUT")
	private String codlayout = "NPCCWX9S";

	@Adapter(transactionField = "NPCCWX9S-HEADER.NPCCWX9S-TAM-LAYOUT")
	private Integer tamlayout = 23;

	@Adapter(transactionField = "NPCCWX9S-REGISTRO.NPCCWX9S-SAIDA.NPCCWX9S-DPREVT-PRORROG")
	private String saida_dprevtprorrog = null;
	
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

	public String getSaida_dprevtprorrog() {
		return saida_dprevtprorrog;
	}
	public void setSaida_dprevtprorrog(String saida_dprevtprorrog) {
		this.saida_dprevtprorrog = saida_dprevtprorrog;
	}
    
}