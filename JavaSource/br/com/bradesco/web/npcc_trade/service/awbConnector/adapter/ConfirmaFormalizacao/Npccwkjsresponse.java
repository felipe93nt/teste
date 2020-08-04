package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConfirmaFormalizacao;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:13
 */
public class Npccwkjsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWKJS-HEADER.NPCCWKJS-COD-LAYOUT")
	private String codlayout = "NPCCWKJS";

	@Adapter(transactionField = "NPCCWKJS-HEADER.NPCCWKJS-TAM-LAYOUT")
	private Integer tamlayout = 47;

	@Adapter(transactionField = "NPCCWKJS-REGISTRO.NPCCWKJS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWKJS-REGISTRO.NPCCWKJS-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWKJS-REGISTRO.NPCCWKJS-CMOTVO-BLETO-CMBIO")
	private Integer cmotvobletocmbio = 0;

	@Adapter(transactionField = "NPCCWKJS-REGISTRO.NPCCWKJS-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWKJS-REGISTRO.NPCCWKJS-DFCHTO-BLETO-CMBIO")
	private String dfchtobletocmbio = null;
	
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

	public Integer getCmotvobletocmbio() {
		return cmotvobletocmbio;
	}
	public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
		this.cmotvobletocmbio = cmotvobletocmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getDfchtobletocmbio() {
		return dfchtobletocmbio;
	}
	public void setDfchtobletocmbio(String dfchtobletocmbio) {
		this.dfchtobletocmbio = dfchtobletocmbio;
	}
    
}