package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterConfirmarPerda;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/03/17 14:09
 */
public class Npccwxqsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXQS-HEADER.NPCCWXQS-COD-LAYOUT")
	private String codlayout = "NPCCWXQS";

	@Adapter(transactionField = "NPCCWXQS-HEADER.NPCCWXQS-TAM-LAYOUT")
	private Integer tamlayout = 47;

	@Adapter(transactionField = "NPCCWXQS-REGISTRO.NPCCWXQS-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXQS-REGISTRO.NPCCWXQS-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWXQS-REGISTRO.NPCCWXQS-CMOTVO-BLETO-CMBIO")
	private Integer cmotvobletocmbio = 0;

	@Adapter(transactionField = "NPCCWXQS-REGISTRO.NPCCWXQS-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWXQS-REGISTRO.NPCCWXQS-DFCHTO-BLETO-CMBIO")
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