package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 15/08/16 18:41
 */
public class Npccwztsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZTS-HEADER.NPCCWZTS-COD-LAYOUT")
	private String codlayout = "NPCCWZTS";

	@Adapter(transactionField = "NPCCWZTS-HEADER.NPCCWZTS-TAM-LAYOUT")
	private Integer tamlayout = 18046;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZTS-REGISTRO.NPCCWZTS-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinanceLogPesq.Npccwztsresponse_gride")
	private List<Npccwztsresponse_gride> gride = null;
	
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

	public List<Npccwztsresponse_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccwztsresponse_gride> gride) {
		this.gride = gride;
	}
    
}