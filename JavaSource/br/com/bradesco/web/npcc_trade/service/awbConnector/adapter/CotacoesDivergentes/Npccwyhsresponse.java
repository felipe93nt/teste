package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 17/10/16 11:15
 */
public class Npccwyhsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYHS-HEADER.NPCCWYHS-COD-LAYOUT")
	private String codlayout = "NPCCWYHS";

	@Adapter(transactionField = "NPCCWYHS-HEADER.NPCCWYHS-TAM-LAYOUT")
	private Integer tamlayout = 14736;

	@Adapter(transactionField = "NPCCWYHS-REGISTRO.NPCCWYHS-SAIDA.NPCCWYHS-QTDE-OCORR")
	private Integer saida_qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYHS-REGISTRO.NPCCWYHS-SAIDA.NPCCWYHS-LISTA-DE-PARA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes.Npccwyhsresponse_saida_listadepara")
	private List<Npccwyhsresponse_saida_listadepara> saida_listadepara = null;
	
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

	public Integer getSaida_qtdeocorr() {
		return saida_qtdeocorr;
	}
	public void setSaida_qtdeocorr(Integer saida_qtdeocorr) {
		this.saida_qtdeocorr = saida_qtdeocorr;
	}

	public List<Npccwyhsresponse_saida_listadepara> getSaida_listadepara() {
		return saida_listadepara;
	}
	public void setSaida_listadepara( List<Npccwyhsresponse_saida_listadepara> saida_listadepara) {
		this.saida_listadepara = saida_listadepara;
	}
    
}