package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/11/17 10:30
 */
public class Npccwx4sresponse_restricoes extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-RESTRICOES.NPCCWX4S-CREST-CLI")
	private Integer restricoes_crestcli = 0;

	@Adapter(transactionField = "NPCCWX4S-REGISTRO.NPCCWX4S-RESTRICOES.NPCCWX4S-RREST-CLI")
	private String restricoes_rrestcli = null;
	
	public Integer getRestricoes_crestcli() {
		return restricoes_crestcli;
	}
	public void setRestricoes_crestcli(Integer restricoes_crestcli) {
		this.restricoes_crestcli = restricoes_crestcli;
	}

	public String getRestricoes_rrestcli() {
		return restricoes_rrestcli;
	}
	public void setRestricoes_rrestcli(String restricoes_rrestcli) {
		this.restricoes_rrestcli = restricoes_rrestcli;
	}
    
}