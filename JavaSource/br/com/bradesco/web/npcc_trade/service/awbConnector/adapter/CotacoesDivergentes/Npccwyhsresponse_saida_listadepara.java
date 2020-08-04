package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 17/10/16 11:15
 */
public class Npccwyhsresponse_saida_listadepara extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYHS-REGISTRO.NPCCWYHS-SAIDA.NPCCWYHS-LISTA-DE-PARA.NPCCWYHS-NCAMPO")
	private String saida_listadepara_ncampo = null;

	@Adapter(transactionField = "NPCCWYHS-REGISTRO.NPCCWYHS-SAIDA.NPCCWYHS-LISTA-DE-PARA.NPCCWYHS-DCAMPO")
	private String saida_listadepara_dcampo = null;

	@Adapter(transactionField = "NPCCWYHS-REGISTRO.NPCCWYHS-SAIDA.NPCCWYHS-LISTA-DE-PARA.NPCCWYHS-PCAMPO")
	private String saida_listadepara_pcampo = null;
	
	public String getSaida_listadepara_ncampo() {
		return saida_listadepara_ncampo;
	}
	public void setSaida_listadepara_ncampo(String saida_listadepara_ncampo) {
		this.saida_listadepara_ncampo = saida_listadepara_ncampo;
	}

	public String getSaida_listadepara_dcampo() {
		return saida_listadepara_dcampo;
	}
	public void setSaida_listadepara_dcampo(String saida_listadepara_dcampo) {
		this.saida_listadepara_dcampo = saida_listadepara_dcampo;
	}

	public String getSaida_listadepara_pcampo() {
		return saida_listadepara_pcampo;
	}
	public void setSaida_listadepara_pcampo(String saida_listadepara_pcampo) {
		this.saida_listadepara_pcampo = saida_listadepara_pcampo;
	}
    
}