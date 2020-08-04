package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DadosBasicos;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 31/07/18 09:11
 */
public class Npccwx1erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX1E-HEADER.NPCCWX1E-COD-LAYOUT")
	private String codlayout = "NPCCWX1E";

	@Adapter(transactionField = "NPCCWX1E-HEADER.NPCCWX1E-TAM-LAYOUT")
	private Integer tamlayout = 70;

	@Adapter(transactionField = "NPCCWX1E-REGISTRO.NPCCWX1E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWX1E-REGISTRO.NPCCWX1E-FUNCAO")
	private Integer funcao = 0;

	@Adapter(transactionField = "NPCCWX1E-REGISTRO.NPCCWX1E-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWX1E-REGISTRO.NPCCWX1E-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWX1E-REGISTRO.NPCCWX1E-HINCL-REG-HIST")
	private String hinclreghist = null;

	@Adapter(transactionField = "NPCCWX1E-REGISTRO.NPCCWX1E-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWX1E-REGISTRO.NPCCWX1E-CMOD-CONTR-CMBIO")
	private Integer cmodcontrcmbio = 0;
	
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

	public String getHinclreghist() {
		return hinclreghist;
	}
	public void setHinclreghist(String hinclreghist) {
		this.hinclreghist = hinclreghist;
	}

	public Integer getCsitbletoaprov() {
		return csitbletoaprov;
	}
	public void setCsitbletoaprov(Integer csitbletoaprov) {
		this.csitbletoaprov = csitbletoaprov;
	}

	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}
    
}