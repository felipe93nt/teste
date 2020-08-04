package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweysresponse_listaout extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CBCO-O")
	private Integer listaout_cbcoo = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CAG-BCRIA-O")
	private Integer listaout_cagbcriao = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CCTA-BCRIA-CLI-O")
	private Long listaout_cctabcriaclio = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CDIG-BCRIA-CLI-O")
	private String listaout_cdigbcriaclio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CTPO-CTA-EXTER-O")
	private Integer listaout_ctpoctaextero = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-BCO-NOME-FANTAS-O")
	private String listaout_bconomefantaso = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CINDCD-FCHTO-AUT-O")
	private Integer listaout_cindcdfchtoauto = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CCONVE-OPER-CMBIO-O")
	private Integer listaout_cconveopercmbioo = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CID-BNEFC-CMBIO-O")
	private String listaout_cidbnefccmbioo = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CFATO-BACEN-CONVE-O")
	private Integer listaout_cfatobacenconveo = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CCLI-BACEN-CONVE-O")
	private Integer listaout_cclibacenconveo = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CINDCD-AVALS-BACEN-O")
	private String listaout_cindcdavalsbaceno = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CPGDOR-RCDOR-CONVE-O")
	private Integer listaout_cpgdorrcdorconveo = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CGRP-BACEN-CONVE-O")
	private Integer listaout_cgrpbacenconveo = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT.NPCDWEYS-CVNCLO-PGDOR-RCDOR-O")
	private Integer listaout_cvnclopgdorrcdoro = 0;
	
	public Integer getListaout_cbcoo() {
		return listaout_cbcoo;
	}
	public void setListaout_cbcoo(Integer listaout_cbcoo) {
		this.listaout_cbcoo = listaout_cbcoo;
	}

	public Integer getListaout_cagbcriao() {
		return listaout_cagbcriao;
	}
	public void setListaout_cagbcriao(Integer listaout_cagbcriao) {
		this.listaout_cagbcriao = listaout_cagbcriao;
	}

	public Long getListaout_cctabcriaclio() {
		return listaout_cctabcriaclio;
	}
	public void setListaout_cctabcriaclio(Long listaout_cctabcriaclio) {
		this.listaout_cctabcriaclio = listaout_cctabcriaclio;
	}

	public String getListaout_cdigbcriaclio() {
		return listaout_cdigbcriaclio;
	}
	public void setListaout_cdigbcriaclio(String listaout_cdigbcriaclio) {
		this.listaout_cdigbcriaclio = listaout_cdigbcriaclio;
	}

	public Integer getListaout_ctpoctaextero() {
		return listaout_ctpoctaextero;
	}
	public void setListaout_ctpoctaextero(Integer listaout_ctpoctaextero) {
		this.listaout_ctpoctaextero = listaout_ctpoctaextero;
	}

	public String getListaout_bconomefantaso() {
		return listaout_bconomefantaso;
	}
	public void setListaout_bconomefantaso(String listaout_bconomefantaso) {
		this.listaout_bconomefantaso = listaout_bconomefantaso;
	}

	public Integer getListaout_cindcdfchtoauto() {
		return listaout_cindcdfchtoauto;
	}
	public void setListaout_cindcdfchtoauto(Integer listaout_cindcdfchtoauto) {
		this.listaout_cindcdfchtoauto = listaout_cindcdfchtoauto;
	}

	public Integer getListaout_cconveopercmbioo() {
		return listaout_cconveopercmbioo;
	}
	public void setListaout_cconveopercmbioo(Integer listaout_cconveopercmbioo) {
		this.listaout_cconveopercmbioo = listaout_cconveopercmbioo;
	}

	public String getListaout_cidbnefccmbioo() {
		return listaout_cidbnefccmbioo;
	}
	public void setListaout_cidbnefccmbioo(String listaout_cidbnefccmbioo) {
		this.listaout_cidbnefccmbioo = listaout_cidbnefccmbioo;
	}

	public Integer getListaout_cfatobacenconveo() {
		return listaout_cfatobacenconveo;
	}
	public void setListaout_cfatobacenconveo(Integer listaout_cfatobacenconveo) {
		this.listaout_cfatobacenconveo = listaout_cfatobacenconveo;
	}

	public Integer getListaout_cclibacenconveo() {
		return listaout_cclibacenconveo;
	}
	public void setListaout_cclibacenconveo(Integer listaout_cclibacenconveo) {
		this.listaout_cclibacenconveo = listaout_cclibacenconveo;
	}

	public String getListaout_cindcdavalsbaceno() {
		return listaout_cindcdavalsbaceno;
	}
	public void setListaout_cindcdavalsbaceno(String listaout_cindcdavalsbaceno) {
		this.listaout_cindcdavalsbaceno = listaout_cindcdavalsbaceno;
	}

	public Integer getListaout_cpgdorrcdorconveo() {
		return listaout_cpgdorrcdorconveo;
	}
	public void setListaout_cpgdorrcdorconveo(Integer listaout_cpgdorrcdorconveo) {
		this.listaout_cpgdorrcdorconveo = listaout_cpgdorrcdorconveo;
	}

	public Integer getListaout_cgrpbacenconveo() {
		return listaout_cgrpbacenconveo;
	}
	public void setListaout_cgrpbacenconveo(Integer listaout_cgrpbacenconveo) {
		this.listaout_cgrpbacenconveo = listaout_cgrpbacenconveo;
	}

	public Integer getListaout_cvnclopgdorrcdoro() {
		return listaout_cvnclopgdorrcdoro;
	}
	public void setListaout_cvnclopgdorrcdoro(Integer listaout_cvnclopgdorrcdoro) {
		this.listaout_cvnclopgdorrcdoro = listaout_cvnclopgdorrcdoro;
	}
    
}