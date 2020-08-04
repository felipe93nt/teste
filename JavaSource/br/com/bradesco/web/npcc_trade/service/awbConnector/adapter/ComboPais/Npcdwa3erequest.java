package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 15:53
 */
public class Npcdwa3erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWA3E-HEADER.NPCDWA3E-COD-LAYOUT")
	private String codlayout = "NPCDWA3E";

	@Adapter(transactionField = "NPCDWA3E-HEADER.NPCDWA3E-TAM-LAYOUT")
	private Integer tamlayout = 17;

	@Adapter(transactionField = "NPCDWA3E-REGISTRO.NPCDWA3E-CPAIS")
	private Integer cpais = 0;

	@Adapter(transactionField = "NPCDWA3E-REGISTRO.NPCDWA3E-TIPO-COMBO")
	private String tipocombo = null;
	
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

	public Integer getCpais() {
		return cpais;
	}
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getTipocombo() {
		return tipocombo;
	}
	public void setTipocombo(String tipocombo) {
		this.tipocombo = tipocombo;
	}
    
}