package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/06/16 12:08
 */
public class Npccwzkerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZKE-HEADER.NPCCWZKE-COD-LAYOUT")
	private String codlayout = "NPCCWZKE";

	@Adapter(transactionField = "NPCCWZKE-HEADER.NPCCWZKE-TAM-LAYOUT")
	private Integer tamlayout = 28;

	@Adapter(transactionField = "NPCCWZKE-REGISTRO.NPCCWZKE-TIPO-PESQUISA")
	private Integer tipopesquisa = 0;

	@Adapter(transactionField = "NPCCWZKE-REGISTRO.NPCCWZKE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWZKE-REGISTRO.NPCCWZKE-CRCONH-ORGNZ-M")
	private Integer crconhorgnzm = 0;
	
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

	public Integer getTipopesquisa() {
		return tipopesquisa;
	}
	public void setTipopesquisa(Integer tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public Integer getCrconhorgnzm() {
		return crconhorgnzm;
	}
	public void setCrconhorgnzm(Integer crconhorgnzm) {
		this.crconhorgnzm = crconhorgnzm;
	}
    
}