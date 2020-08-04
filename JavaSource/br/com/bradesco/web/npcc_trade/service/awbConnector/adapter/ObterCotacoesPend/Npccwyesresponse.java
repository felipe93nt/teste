package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/08/16 12:50
 */
public class Npccwyesresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYES-HEADER.NPCCWYES-COD-LAYOUT")
	private String codlayout = "NPCCWYES";

	@Adapter(transactionField = "NPCCWYES-HEADER.NPCCWYES-TAM-LAYOUT")
	private Integer tamlayout = 16966;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYES-REGISTRO.NPCCWYES-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterCotacoesPend.Npccwyesresponse_gride")
	private List<Npccwyesresponse_gride> gride = null;
	
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

	public List<Npccwyesresponse_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccwyesresponse_gride> gride) {
		this.gride = gride;
	}
    
}