package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperVinculadaLcIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/11/16 15:10
 */
public class Npccww7erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWW7E-HEADER.NPCCWW7E-COD-LAYOUT")
	private String codlayout = "NPCCWW7E";

	@Adapter(transactionField = "NPCCWW7E-HEADER.NPCCWW7E-TAM-LAYOUT")
	private Integer tamlayout = 59;

	@Adapter(transactionField = "NPCCWW7E-REGISTRO.NPCCWW7E-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWW7E-REGISTRO.NPCCWW7E-NBLETO-VNCLO-IMPOR")
	private Long nbletovncloimpor = 0L;

	@Adapter(transactionField = "NPCCWW7E-REGISTRO.NPCCWW7E-HINCL-REG")
	private String hinclreg = null;
	
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

	public Long getNbletovncloimpor() {
		return nbletovncloimpor;
	}
	public void setNbletovncloimpor(Long nbletovncloimpor) {
		this.nbletovncloimpor = nbletovncloimpor;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}
    
}