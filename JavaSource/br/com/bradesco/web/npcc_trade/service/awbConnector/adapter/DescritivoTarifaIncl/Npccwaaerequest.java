package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DescritivoTarifaIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/08/18 11:13
 */
public class Npccwaaerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWAAE-HEADER.NPCCWAAE-COD-LAYOUT")
	private String codlayout = "NPCCWAAE";

	@Adapter(transactionField = "NPCCWAAE-HEADER.NPCCWAAE-TAM-LAYOUT")
	private Integer tamlayout = 203;

	@Adapter(transactionField = "NPCCWAAE-REGISTRO.NPCCWAAE-CCOND-ECONC")
	private Integer ccondeconc = 0;

	@Adapter(transactionField = "NPCCWAAE-REGISTRO.NPCCWAAE-RCONDC-ECONC-CMBIO")
	private String rcondceconccmbio = null;

	@Adapter(transactionField = "NPCCWAAE-REGISTRO.NPCCWAAE-CUSUAR-MANUT")
	private String cusuarmanut = null;

	@Adapter(transactionField = "NPCCWAAE-REGISTRO.NPCCWAAE-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWAAE-REGISTRO.NPCCWAAE-FILLER")
	private String filler = null;
	
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

	public Integer getCcondeconc() {
		return ccondeconc;
	}
	public void setCcondeconc(Integer ccondeconc) {
		this.ccondeconc = ccondeconc;
	}

	public String getRcondceconccmbio() {
		return rcondceconccmbio;
	}
	public void setRcondceconccmbio(String rcondceconccmbio) {
		this.rcondceconccmbio = rcondceconccmbio;
	}

	public String getCusuarmanut() {
		return cusuarmanut;
	}
	public void setCusuarmanut(String cusuarmanut) {
		this.cusuarmanut = cusuarmanut;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
    
}