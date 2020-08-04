package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweysresponse_listabra extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CAG-BCRIA-B")
	private Integer listabra_cagbcriab = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CCTA-BCRIA-CLI-B")
	private Long listabra_cctabcriaclib = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CDIG-BCRIA-CLI-B")
	private String listabra_cdigbcriaclib = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-RAZAO-B")
	private String listabra_razaob = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CPSSOA-JURID-CTA-B")
	private Long listabra_cpssoajuridctab = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CTPO-NEGOC-CTA-B")
	private Integer listabra_ctponegocctab = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-NSEQ-NEGOC-CTA-B")
	private Long listabra_nseqnegocctab = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CINDCD-FCHTO-AUT-B")
	private Integer listabra_cindcdfchtoautb = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CCONVE-OPER-CMBIO-B")
	private Integer listabra_cconveopercmbiob = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CID-BNEFC-CMBIO-B")
	private String listabra_cidbnefccmbiob = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CFATO-BACEN-CONVE-B")
	private Integer listabra_cfatobacenconveb = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CCLI-BACEN-CONVE-B")
	private Integer listabra_cclibacenconveb = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CINDCD-AVALS-BACEN-B")
	private String listabra_cindcdavalsbacenb = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CPGDOR-RCDOR-CONVE-B")
	private Integer listabra_cpgdorrcdorconveb = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CGRP-BACEN-CONVE-B")
	private Integer listabra_cgrpbacenconveb = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA.NPCDWEYS-CVNCLO-PGDOR-RCDOR-B")
	private Integer listabra_cvnclopgdorrcdorb = 0;
	
	public Integer getListabra_cagbcriab() {
		return listabra_cagbcriab;
	}
	public void setListabra_cagbcriab(Integer listabra_cagbcriab) {
		this.listabra_cagbcriab = listabra_cagbcriab;
	}

	public Long getListabra_cctabcriaclib() {
		return listabra_cctabcriaclib;
	}
	public void setListabra_cctabcriaclib(Long listabra_cctabcriaclib) {
		this.listabra_cctabcriaclib = listabra_cctabcriaclib;
	}

	public String getListabra_cdigbcriaclib() {
		return listabra_cdigbcriaclib;
	}
	public void setListabra_cdigbcriaclib(String listabra_cdigbcriaclib) {
		this.listabra_cdigbcriaclib = listabra_cdigbcriaclib;
	}

	public String getListabra_razaob() {
		return listabra_razaob;
	}
	public void setListabra_razaob(String listabra_razaob) {
		this.listabra_razaob = listabra_razaob;
	}

	public Long getListabra_cpssoajuridctab() {
		return listabra_cpssoajuridctab;
	}
	public void setListabra_cpssoajuridctab(Long listabra_cpssoajuridctab) {
		this.listabra_cpssoajuridctab = listabra_cpssoajuridctab;
	}

	public Integer getListabra_ctponegocctab() {
		return listabra_ctponegocctab;
	}
	public void setListabra_ctponegocctab(Integer listabra_ctponegocctab) {
		this.listabra_ctponegocctab = listabra_ctponegocctab;
	}

	public Long getListabra_nseqnegocctab() {
		return listabra_nseqnegocctab;
	}
	public void setListabra_nseqnegocctab(Long listabra_nseqnegocctab) {
		this.listabra_nseqnegocctab = listabra_nseqnegocctab;
	}

	public Integer getListabra_cindcdfchtoautb() {
		return listabra_cindcdfchtoautb;
	}
	public void setListabra_cindcdfchtoautb(Integer listabra_cindcdfchtoautb) {
		this.listabra_cindcdfchtoautb = listabra_cindcdfchtoautb;
	}

	public Integer getListabra_cconveopercmbiob() {
		return listabra_cconveopercmbiob;
	}
	public void setListabra_cconveopercmbiob(Integer listabra_cconveopercmbiob) {
		this.listabra_cconveopercmbiob = listabra_cconveopercmbiob;
	}

	public String getListabra_cidbnefccmbiob() {
		return listabra_cidbnefccmbiob;
	}
	public void setListabra_cidbnefccmbiob(String listabra_cidbnefccmbiob) {
		this.listabra_cidbnefccmbiob = listabra_cidbnefccmbiob;
	}

	public Integer getListabra_cfatobacenconveb() {
		return listabra_cfatobacenconveb;
	}
	public void setListabra_cfatobacenconveb(Integer listabra_cfatobacenconveb) {
		this.listabra_cfatobacenconveb = listabra_cfatobacenconveb;
	}

	public Integer getListabra_cclibacenconveb() {
		return listabra_cclibacenconveb;
	}
	public void setListabra_cclibacenconveb(Integer listabra_cclibacenconveb) {
		this.listabra_cclibacenconveb = listabra_cclibacenconveb;
	}

	public String getListabra_cindcdavalsbacenb() {
		return listabra_cindcdavalsbacenb;
	}
	public void setListabra_cindcdavalsbacenb(String listabra_cindcdavalsbacenb) {
		this.listabra_cindcdavalsbacenb = listabra_cindcdavalsbacenb;
	}

	public Integer getListabra_cpgdorrcdorconveb() {
		return listabra_cpgdorrcdorconveb;
	}
	public void setListabra_cpgdorrcdorconveb(Integer listabra_cpgdorrcdorconveb) {
		this.listabra_cpgdorrcdorconveb = listabra_cpgdorrcdorconveb;
	}

	public Integer getListabra_cgrpbacenconveb() {
		return listabra_cgrpbacenconveb;
	}
	public void setListabra_cgrpbacenconveb(Integer listabra_cgrpbacenconveb) {
		this.listabra_cgrpbacenconveb = listabra_cgrpbacenconveb;
	}

	public Integer getListabra_cvnclopgdorrcdorb() {
		return listabra_cvnclopgdorrcdorb;
	}
	public void setListabra_cvnclopgdorrcdorb(Integer listabra_cvnclopgdorrcdorb) {
		this.listabra_cvnclopgdorrcdorb = listabra_cvnclopgdorrcdorb;
	}
    
}