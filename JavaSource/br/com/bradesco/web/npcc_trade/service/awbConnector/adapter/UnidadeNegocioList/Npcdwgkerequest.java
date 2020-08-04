package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidadeNegocioList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/02/16 19:36
 */
public class Npcdwgkerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWGKE-HEADER.NPCDWGKE-COD-LAYOUT")
	private String codlayout = "NPCDWGKE";

	@Adapter(transactionField = "NPCDWGKE-HEADER.NPCDWGKE-TAM-LAYOUT")
	private Integer tamlayout = 28;

	@Adapter(transactionField = "NPCDWGKE-REGISTRO.NPCDWGKE-TIPO-PESQUISA")
	private Integer tipopesquisa = 0;

	@Adapter(transactionField = "NPCDWGKE-REGISTRO.NPCDWGKE-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCDWGKE-REGISTRO.NPCDWGKE-CRCONH-ORGNZ-M")
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