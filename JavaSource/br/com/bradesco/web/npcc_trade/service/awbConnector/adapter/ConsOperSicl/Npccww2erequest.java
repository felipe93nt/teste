package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsOperSicl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 30/09/16 11:12
 */
public class Npccww2erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW2E-HEADER.NPCCWW2E-COD-LAYOUT")
	private String codlayout = "NPCCWW2E";

	@Adapter(transactionField = "NPCCWW2E-HEADER.NPCCWW2E-TAM-LAYOUT")
	private Integer tamlayout = 26;

	@Adapter(transactionField = "NPCCWW2E-REGISTRO.NPCCWW2E-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWW2E-REGISTRO.NPCCWW2E-DANO-BASE")
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

	public Integer getNbletocmbioano() {
		return nbletocmbioano;
	}
	public void setNbletocmbioano(Integer nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}

	public Integer getDanobase() {
		return danobase;
	}
	public void setDanobase(Integer danobase) {
		this.danobase = danobase;
	}
    
}