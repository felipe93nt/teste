package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesDivergentes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 17/10/16 11:15
 */
public class Npccwyherequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYHE-HEADER.NPCCWYHE-COD-LAYOUT")
	private String codlayout = "NPCCWYHE";

	@Adapter(transactionField = "NPCCWYHE-HEADER.NPCCWYHE-TAM-LAYOUT")
	private Integer tamlayout = 26;

	@Adapter(transactionField = "NPCCWYHE-REGISTRO.NPCCWYHE-ENTRADA.NPCCWYHE-NBLETO-NEGOC-CMBIO")
	private Long entrada_nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYHE-REGISTRO.NPCCWYHE-ENTRADA.NPCCWYHE-CSIT-BLETO-APROV")
	private Integer entrada_csitbletoaprov = 0;
	
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

	public Long getEntrada_nbletonegoccmbio() {
		return entrada_nbletonegoccmbio;
	}
	public void setEntrada_nbletonegoccmbio(Long entrada_nbletonegoccmbio) {
		this.entrada_nbletonegoccmbio = entrada_nbletonegoccmbio;
	}

	public Integer getEntrada_csitbletoaprov() {
		return entrada_csitbletoaprov;
	}
	public void setEntrada_csitbletoaprov(Integer entrada_csitbletoaprov) {
		this.entrada_csitbletoaprov = entrada_csitbletoaprov;
	}
    
}