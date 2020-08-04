package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SomaAboutValorLimite;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 09/02/17 13:48
 */
public class Npccww8erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWX2E-HEADER.NPCCWW8E-COD-LAYOUT")
	private String codlayout = "NPCCWW8E";

	@Adapter(transactionField = "NPCCWX2E-HEADER.NPCCWW8E-TAM-LAYOUT")
	private Integer tamlayout = 38;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWW8E-VNEGOC-MOEDA-ESTRG")
	private String vnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWX2E-REGISTRO.NPCCWW8E-PCOBER-VAR-PRODT")
	private String pcobervarprodt = null;
	
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

	public String getVnegocmoedaestrg() {
		return vnegocmoedaestrg;
	}
	public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
		this.vnegocmoedaestrg = vnegocmoedaestrg;
	}

	public String getPcobervarprodt() {
		return pcobervarprodt;
	}
	public void setPcobervarprodt(String pcobervarprodt) {
		this.pcobervarprodt = pcobervarprodt;
	}
    
}