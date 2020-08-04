package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Npccwmnsresponse_dadoslista_pa extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-PA.NPCCWMNS-DESC-PGTO")
	private String dadoslista_pa_descpgto = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-PA.NPCCWMNS-DPREVT-DSEMB")
	private String dadoslista_pa_dprevtdsemb = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-PA.NPCCWMNS-DPREVT-EMBRQ")
	private String dadoslista_pa_dprevtembrq = null;
	
	public String getDadoslista_pa_descpgto() {
		return dadoslista_pa_descpgto;
	}
	public void setDadoslista_pa_descpgto(String dadoslista_pa_descpgto) {
		this.dadoslista_pa_descpgto = dadoslista_pa_descpgto;
	}

	public String getDadoslista_pa_dprevtdsemb() {
		return dadoslista_pa_dprevtdsemb;
	}
	public void setDadoslista_pa_dprevtdsemb(String dadoslista_pa_dprevtdsemb) {
		this.dadoslista_pa_dprevtdsemb = dadoslista_pa_dprevtdsemb;
	}

	public String getDadoslista_pa_dprevtembrq() {
		return dadoslista_pa_dprevtembrq;
	}
	public void setDadoslista_pa_dprevtembrq(String dadoslista_pa_dprevtembrq) {
		this.dadoslista_pa_dprevtembrq = dadoslista_pa_dprevtembrq;
	}
    
}