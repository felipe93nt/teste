package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/12/16 16:39
 */
public class Npccwnysresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWNYS-HEADER.NPCCWNYS-COD-LAYOUT")
	private String codlayout = "NPCCWNYS";

	@Adapter(transactionField = "NPCCWNYS-HEADER.NPCCWNYS-TAM-LAYOUT")
	private Integer tamlayout = 26;

	@Adapter(transactionField = "NPCCWNYS-REGISTRO.NPCCWNYS-DANO-BASE")
	private Integer danobase = 0;

	@Adapter(transactionField = "NPCCWNYS-REGISTRO.NPCCWNYS-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;
	
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

	public Integer getNbletocmbioano() {
		return nbletocmbioano;
	}
	public void setNbletocmbioano(Integer nbletocmbioano) {
		this.nbletocmbioano = nbletocmbioano;
	}
    
}