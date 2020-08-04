package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacaoPpeIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/04/17 15:46
 */
public class Npccwv9sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWV9S-HEADER.NPCCWV9S-COD-LAYOUT")
	private String codlayout = "NPCCWV9S";

	@Adapter(transactionField = "NPCCWV9S-HEADER.NPCCWV9S-TAM-LAYOUT")
	private Integer tamlayout = 62;

	@Adapter(transactionField = "NPCCWV9S-REGISTRO.NPCCWV9S-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWV9S-REGISTRO.NPCCWV9S-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWV9S-REGISTRO.NPCCWV9S-NBLETO-CMBIO-ANO")
	private Integer nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWV9S-REGISTRO.NPCCWV9S-DANO-BASE")
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