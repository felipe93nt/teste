package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 23/08/16 14:31
 */
public class Npccwzvsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZVS-HEADER.NPCCWZVS-COD-LAYOUT")
	private String codlayout = "NPCCWZVS";

	@Adapter(transactionField = "NPCCWZVS-HEADER.NPCCWZVS-TAM-LAYOUT")
	private Integer tamlayout = 19066;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas.Npccwzvsresponse_gride")
	private List<Npccwzvsresponse_gride> gride = null;
	
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

	public List<Npccwzvsresponse_gride> getGride() {
		return gride;
	}
	public void setGride( List<Npccwzvsresponse_gride> gride) {
		this.gride = gride;
	}
    
}