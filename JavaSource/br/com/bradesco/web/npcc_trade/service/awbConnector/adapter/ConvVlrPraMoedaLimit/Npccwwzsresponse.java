package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConvVlrPraMoedaLimit;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 11/01/16 14:08
 */
public class Npccwwzsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWZS-HEADER.NPCCWWZS-COD-LAYOUT")
	private String codlayout = "NPCCWWZS";

	@Adapter(transactionField = "NPCCWWZS-HEADER.NPCCWWZS-TAM-LAYOUT")
	private Integer tamlayout = 30;

	@Adapter(transactionField = "NPCCWWZS-REGISTRO.NPCCWWZS-S-VLIMIT")
	private String svlimit = null;
	
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

	public String getSvlimit() {
		return svlimit;
	}
	public void setSvlimit(String svlimit) {
		this.svlimit = svlimit;
	}
    
}