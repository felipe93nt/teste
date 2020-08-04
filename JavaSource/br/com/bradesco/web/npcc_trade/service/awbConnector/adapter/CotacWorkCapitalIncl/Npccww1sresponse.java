package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacWorkCapitalIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 07/04/17 11:44
 */
public class Npccww1sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW1S-HEADER.NPCCWW1S-COD-LAYOUT")
	private String codlayout = "NPCCWW1S";

	@Adapter(transactionField = "NPCCWW1S-HEADER.NPCCWW1S-TAM-LAYOUT")
	private Integer tamlayout = 62;

	@Adapter(transactionField = "NPCCWW1S-REGISTRO.NPCCWW1S-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWW1S-REGISTRO.NPCCWW1S-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWW1S-REGISTRO.NPCCWW1S-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWW1S-REGISTRO.NPCCWW1S-DANO-BASE")
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
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