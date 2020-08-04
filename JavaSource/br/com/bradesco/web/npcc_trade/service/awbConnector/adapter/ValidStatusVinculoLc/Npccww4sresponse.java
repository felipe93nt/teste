package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ValidStatusVinculoLc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/11/16 16:03
 */
public class Npccww4sresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW4S-HEADER.NPCCWW4S-COD-LAYOUT")
	private String codlayout = "NPCCWW4S";

	@Adapter(transactionField = "NPCCWW4S-HEADER.NPCCWW4S-TAM-LAYOUT")
	private Integer tamlayout = 69;

	@Adapter(transactionField = "NPCCWW4S-REGISTRO.NPCCWW4S-CSIT-EQUAL")
	private Integer csitequal = 0;

	@Adapter(transactionField = "NPCCWW4S-REGISTRO.NPCCWW4S-NBLETO-VNCLO-IMPOR")
	private Long nbletovncloimpor = 0L;

	@Adapter(transactionField = "NPCCWW4S-REGISTRO.NPCCWW4S-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWW4S-REGISTRO.NPCCWW4S-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWW4S-REGISTRO.NPCCWW4S-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWW4S-REGISTRO.NPCCWW4S-CSIT-BLETO-APROV")
	private Integer csitbletoaprov = 0;

	@Adapter(transactionField = "NPCCWW4S-REGISTRO.NPCCWW4S-CMOD-CONTR-CMBIO")
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

	public Integer getCsitequal() {
		return csitequal;
	}
	public void setCsitequal(Integer csitequal) {
		this.csitequal = csitequal;
	}

	public Long getNbletovncloimpor() {
		return nbletovncloimpor;
	}
	public void setNbletovncloimpor(Long nbletovncloimpor) {
		this.nbletovncloimpor = nbletovncloimpor;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
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