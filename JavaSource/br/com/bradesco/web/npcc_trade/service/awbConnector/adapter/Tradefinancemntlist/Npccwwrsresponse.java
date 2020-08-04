package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 27/07/16 15:26
 */
public class Npccwwrsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWRS-HEADER.NPCCWWRS-COD-LAYOUT")
	private String codlayout = "NPCCWWRS";

	@Adapter(transactionField = "NPCCWWRS-HEADER.NPCCWWRS-TAM-LAYOUT")
	private Integer tamlayout = 15296;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWWRS-REGISTRO.NPCCWWRS-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Tradefinancemntlist.Npccwwrsresponse_gride")
	private List<Npccwwrsresponse_gride> gride = null;
	
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

	public List<Npccwwrsresponse_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccwwrsresponse_gride> gride) {
		this.gride = gride;
	}
    
}