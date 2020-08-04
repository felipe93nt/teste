package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidadeNegocioList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/02/16 19:36
 */
public class Npcdwgksresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-CPSSOA-JURID-SUBR")
	private Long lista_cpssoajuridsubr = 0L;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-NSEQ-UND-SUBR")
	private Integer lista_nsequndsubr = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-CIDTFD-TPO-UND-SUBR")
	private Integer lista_cidtfdtpoundsubr = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-CRCONH-UND-SUBR-M")
	private String lista_crconhundsubrm = null;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-CRCONH-UND-SUBR-F")
	private String lista_crconhundsubrf = null;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-IRZ-SCIAL-SUBR")
	private String lista_irzscialsubr = null;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-CTPO-UND-ORGNZ-SUBR")
	private Integer lista_ctpoundorgnzsubr = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA.NPCDWGKS-ITPO-UND-ORGNZ-SUBR")
	private String lista_itpoundorgnzsubr = null;
	
	public Long getLista_cpssoajuridsubr() {
		return lista_cpssoajuridsubr;
	}
	public void setLista_cpssoajuridsubr(Long lista_cpssoajuridsubr) {
		this.lista_cpssoajuridsubr = lista_cpssoajuridsubr;
	}

	public Integer getLista_nsequndsubr() {
		return lista_nsequndsubr;
	}
	public void setLista_nsequndsubr(Integer lista_nsequndsubr) {
		this.lista_nsequndsubr = lista_nsequndsubr;
	}

	public Integer getLista_cidtfdtpoundsubr() {
		return lista_cidtfdtpoundsubr;
	}
	public void setLista_cidtfdtpoundsubr(Integer lista_cidtfdtpoundsubr) {
		this.lista_cidtfdtpoundsubr = lista_cidtfdtpoundsubr;
	}

	public String getLista_crconhundsubrm() {
		return lista_crconhundsubrm;
	}
	public void setLista_crconhundsubrm(String lista_crconhundsubrm) {
		this.lista_crconhundsubrm = lista_crconhundsubrm;
	}

	public String getLista_crconhundsubrf() {
		return lista_crconhundsubrf;
	}
	public void setLista_crconhundsubrf(String lista_crconhundsubrf) {
		this.lista_crconhundsubrf = lista_crconhundsubrf;
	}

	public String getLista_irzscialsubr() {
		return lista_irzscialsubr;
	}
	public void setLista_irzscialsubr(String lista_irzscialsubr) {
		this.lista_irzscialsubr = lista_irzscialsubr;
	}

	public Integer getLista_ctpoundorgnzsubr() {
		return lista_ctpoundorgnzsubr;
	}
	public void setLista_ctpoundorgnzsubr(Integer lista_ctpoundorgnzsubr) {
		this.lista_ctpoundorgnzsubr = lista_ctpoundorgnzsubr;
	}

	public String getLista_itpoundorgnzsubr() {
		return lista_itpoundorgnzsubr;
	}
	public void setLista_itpoundorgnzsubr(String lista_itpoundorgnzsubr) {
		this.lista_itpoundorgnzsubr = lista_itpoundorgnzsubr;
	}
    
}