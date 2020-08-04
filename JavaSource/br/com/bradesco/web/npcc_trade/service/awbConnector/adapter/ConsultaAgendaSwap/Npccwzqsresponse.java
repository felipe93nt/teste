package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 14/09/16 16:40
 */
public class Npccwzqsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZQS-HEADER.NPCCWZQS-COD-LAYOUT")
	private String codlayout = "NPCCWZQS";

	@Adapter(transactionField = "NPCCWZQS-HEADER.NPCCWZQS-TAM-LAYOUT")
	private Integer tamlayout = 13396;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap.Npccwzqsresponse_gride")
	private List<Npccwzqsresponse_gride> gride = null;
	
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

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwzqsresponse_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccwzqsresponse_gride> gride) {
		this.gride = gride;
	}
    
}