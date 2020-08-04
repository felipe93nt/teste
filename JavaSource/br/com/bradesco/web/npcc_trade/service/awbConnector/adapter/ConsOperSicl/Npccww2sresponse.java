package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 30/09/16 11:12
 */
public class Npccww2sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW2S-HEADER.NPCCWW2S-COD-LAYOUT")
	private String codlayout = "NPCCWW2S";

	@Adapter(transactionField = "NPCCWW2S-HEADER.NPCCWW2S-TAM-LAYOUT")
	private Integer tamlayout = 1236;

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWW2S-REGISTRO.NPCCWW2S-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl.Npccww2sresponse_gride")
	private List<Npccww2sresponse_gride> gride = null;
	
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

	public List<Npccww2sresponse_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccww2sresponse_gride> gride) {
		this.gride = gride;
	}
    
}