package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirProrrogacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:02
 */
public class Npccww5sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW5S-HEADER.NPCCWW5S-COD-LAYOUT")
	private String codlayout = "NPCCWW5S";

	@Adapter(transactionField = "NPCCWW5S-HEADER.NPCCWW5S-TAM-LAYOUT")
	private Integer tamlayout = 62;

	@Adapter(transactionField = "NPCCWW5S-REGISTRO.NPCCWW5S-SAIDA.NPCCWW5S-NBLETO-NEGOC-CMBIO")
	private Long saida_nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWW5S-REGISTRO.NPCCWW5S-SAIDA.NPCCWW5S-DANO-BASE")
	private Integer saida_danobase = 0;

	@Adapter(transactionField = "NPCCWW5S-REGISTRO.NPCCWW5S-SAIDA.NPCCWW5S-NBLETO-CMBIO-ANO")
	private Integer saida_nbletocmbioano = 0;

	@Adapter(transactionField = "NPCCWW5S-REGISTRO.NPCCWW5S-SAIDA.NPCCWW5S-HINCL-REG")
	private String saida_hinclreg = null;
	
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

	public Long getSaida_nbletonegoccmbio() {
		return saida_nbletonegoccmbio;
	}
	public void setSaida_nbletonegoccmbio(Long saida_nbletonegoccmbio) {
		this.saida_nbletonegoccmbio = saida_nbletonegoccmbio;
	}

	public Integer getSaida_danobase() {
		return saida_danobase;
	}
	public void setSaida_danobase(Integer saida_danobase) {
		this.saida_danobase = saida_danobase;
	}

	public Integer getSaida_nbletocmbioano() {
		return saida_nbletocmbioano;
	}
	public void setSaida_nbletocmbioano(Integer saida_nbletocmbioano) {
		this.saida_nbletocmbioano = saida_nbletocmbioano;
	}

	public String getSaida_hinclreg() {
		return saida_hinclreg;
	}
	public void setSaida_hinclreg(String saida_hinclreg) {
		this.saida_hinclreg = saida_hinclreg;
	}
    
}