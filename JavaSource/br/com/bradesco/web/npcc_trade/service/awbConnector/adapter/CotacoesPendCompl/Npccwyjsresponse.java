package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 07/07/16 15:14
 */
public class Npccwyjsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYJS-HEADER.NPCCWYJS-COD-LAYOUT")
	private String codlayout = "NPCCWYJS";

	@Adapter(transactionField = "NPCCWYJS-HEADER.NPCCWYJS-TAM-LAYOUT")
	private Integer tamlayout = 9886;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl.Npccwyjsresponse_gride")
	private List<Npccwyjsresponse_gride> gride = null;
	
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

	public List<Npccwyjsresponse_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccwyjsresponse_gride> gride) {
		this.gride = gride;
	}
    
}