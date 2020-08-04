package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 21/09/16 09:55
 */
public class Npccwzgerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZGE-HEADER.NPCCWZGE-COD-LAYOUT")
	private String codlayout = "NPCCWZGE";

	@Adapter(transactionField = "NPCCWZGE-HEADER.NPCCWZGE-TAM-LAYOUT")
	private Integer tamlayout = 17;

	@Adapter(transactionField = "NPCCWZGE-REGISTRO.NPCCWZGE-DANO-BASE")
	private Integer danobase = 0;
	
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

	public Integer getDanobase() {
		return danobase;
	}
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
	}
    
}