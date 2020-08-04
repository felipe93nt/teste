package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarcustoExterno;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 11:39
 */
public class Npccwygsresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYGS-HEADER.NPCCWYGS-COD-LAYOUT")
	private String codlayout = "NPCCWYGS";

	@Adapter(transactionField = "NPCCWYGS-HEADER.NPCCWYGS-TAM-LAYOUT")
	private Integer tamlayout = 39;

	@Adapter(transactionField = "NPCCWYGS-REGISTRO.NPCCWYGS-S-HMANUT-REG")
	private String shmanutreg = null;
	
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

	public String getShmanutreg() {
		return shmanutreg;
	}
	public void setShmanutreg(String shmanutreg) {
		this.shmanutreg = shmanutreg;
	}
    
}