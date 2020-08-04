package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/11/16 16:03
 */
public class Npccww4erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW4E-HEADER.NPCCWW4E-COD-LAYOUT")
	private String codlayout = "NPCCWW4E";

	@Adapter(transactionField = "NPCCWW4E-HEADER.NPCCWW4E-TAM-LAYOUT")
	private Integer tamlayout = 34;

	@Adapter(transactionField = "NPCCWW4E-REGISTRO.NPCCWW4E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWW4E-REGISTRO.NPCCWW4E-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWW4E-REGISTRO.NPCCWW4E-CPRODT-SERVC")
	private Integer cprodtservc = 0;
	
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

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}
    
}