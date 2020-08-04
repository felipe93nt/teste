package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboTomador;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/05/16 17:35
 */
public class Npccwwterequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWTE-HEADER.NPCCWWTE-COD-LAYOUT")
	private String codlayout = "NPCCWWTE";

	@Adapter(transactionField = "NPCCWWTE-HEADER.NPCCWWTE-TAM-LAYOUT")
	private Integer tamlayout = 30;

	@Adapter(transactionField = "NPCCWWTE-REGISTRO.NPCCWWTE-NCONTR-LIM-GERC")
	private Long ncontrlimgerc = 0L;
	
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

	public Long getNcontrlimgerc() {
		return ncontrlimgerc;
	}
	public void setNcontrlimgerc(Long ncontrlimgerc) {
		this.ncontrlimgerc = ncontrlimgerc;
	}
    
}