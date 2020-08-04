package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FinimpDiretoIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 13:31
 */
public class Npccwv3sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV3S-HEADER.NPCCWV3S-COD-LAYOUT")
	private String codlayout = "NPCCWV3S";

	@Adapter(transactionField = "NPCCWV3S-HEADER.NPCCWV3S-TAM-LAYOUT")
	private Integer tamlayout = 62;

	@Adapter(transactionField = "NPCCWV3S-REGISTRO.NPCCWV3S-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWV3S-REGISTRO.NPCCWV3S-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWV3S-REGISTRO.NPCCWV3S-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWV3S-REGISTRO.NPCCWV3S-DANO-BASE")
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