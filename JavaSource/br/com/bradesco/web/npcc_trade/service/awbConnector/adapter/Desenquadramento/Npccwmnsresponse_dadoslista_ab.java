package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/05/18 13:16
 */
public class Npccwmnsresponse_dadoslista_ab extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-AB.NPCCWMNS-DESC-ANY")
	private String dadoslista_ab_descany = null;

	@Adapter(transactionField = "NPCCWMNS-REGISTRO.NPCCWMNS-DADOS-LISTA.NPCCWMNS-AB.NPCCWMNS-CONDICAO")
	private String dadoslista_ab_condicao = null;
	
	public String getDadoslista_ab_descany() {
		return dadoslista_ab_descany;
	}
	public void setDadoslista_ab_descany(String dadoslista_ab_descany) {
		this.dadoslista_ab_descany = dadoslista_ab_descany;
	}

	public String getDadoslista_ab_condicao() {
		return dadoslista_ab_condicao;
	}
	public void setDadoslista_ab_condicao(String dadoslista_ab_condicao) {
		this.dadoslista_ab_condicao = dadoslista_ab_condicao;
	}
    
}