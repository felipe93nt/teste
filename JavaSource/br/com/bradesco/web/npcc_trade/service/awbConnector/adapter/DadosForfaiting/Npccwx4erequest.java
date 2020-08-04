package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosForfaiting;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/11/17 10:30
 */
public class Npccwx4erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX4E-HEADER.NPCCWX4E-COD-LAYOUT")
	private String codlayout = "NPCCWX4E";

	@Adapter(transactionField = "NPCCWX4E-HEADER.NPCCWX4E-TAM-LAYOUT")
	private Integer tamlayout = 65;

	@Adapter(transactionField = "NPCCWX4E-REGISTRO.NPCCWX4E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWX4E-REGISTRO.NPCCWX4E-FUNCAO")
	private Integer funcao = 0;

	@Adapter(transactionField = "NPCCWX4E-REGISTRO.NPCCWX4E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWX4E-REGISTRO.NPCCWX4E-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWX4E-REGISTRO.NPCCWX4E-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWX4E-REGISTRO.NPCCWX4E-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;
	
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

	public Integer getFuncao() {
		return funcao;
	}
	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}
    
}