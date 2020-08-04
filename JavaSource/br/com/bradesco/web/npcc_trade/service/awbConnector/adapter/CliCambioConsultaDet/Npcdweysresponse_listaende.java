package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweysresponse_listaende extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-CSEQ-ENDER-PSSOA")
	private Integer listaende_cseqenderpssoa = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-ELOGDR-PSSOA")
	private String listaende_elogdrpssoa = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-ELOGDR-NRO")
	private String listaende_elogdrnro = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-EBAIRO-ENDER")
	private String listaende_ebairoender = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-CCEP")
	private Integer listaende_ccep = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-CCEP-COMPL")
	private Integer listaende_ccepcompl = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-ICIDDE-ENDER")
	private String listaende_iciddeender = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-CSGL-UF")
	private String listaende_csgluf = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-IPAIS-GEOGR")
	private String listaende_ipaisgeogr = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE.NPCDWEYS-SEL-ENDER-GRID")
	private String listaende_selendergrid = null;
	
	public Integer getListaende_cseqenderpssoa() {
		return listaende_cseqenderpssoa;
	}
	public void setListaende_cseqenderpssoa(Integer listaende_cseqenderpssoa) {
		this.listaende_cseqenderpssoa = listaende_cseqenderpssoa;
	}

	public String getListaende_elogdrpssoa() {
		return listaende_elogdrpssoa;
	}
	public void setListaende_elogdrpssoa(String listaende_elogdrpssoa) {
		this.listaende_elogdrpssoa = listaende_elogdrpssoa;
	}

	public String getListaende_elogdrnro() {
		return listaende_elogdrnro;
	}
	public void setListaende_elogdrnro(String listaende_elogdrnro) {
		this.listaende_elogdrnro = listaende_elogdrnro;
	}

	public String getListaende_ebairoender() {
		return listaende_ebairoender;
	}
	public void setListaende_ebairoender(String listaende_ebairoender) {
		this.listaende_ebairoender = listaende_ebairoender;
	}

	public Integer getListaende_ccep() {
		return listaende_ccep;
	}
	public void setListaende_ccep(Integer listaende_ccep) {
		this.listaende_ccep = listaende_ccep;
	}

	public Integer getListaende_ccepcompl() {
		return listaende_ccepcompl;
	}
	public void setListaende_ccepcompl(Integer listaende_ccepcompl) {
		this.listaende_ccepcompl = listaende_ccepcompl;
	}

	public String getListaende_iciddeender() {
		return listaende_iciddeender;
	}
	public void setListaende_iciddeender(String listaende_iciddeender) {
		this.listaende_iciddeender = listaende_iciddeender;
	}

	public String getListaende_csgluf() {
		return listaende_csgluf;
	}
	public void setListaende_csgluf(String listaende_csgluf) {
		this.listaende_csgluf = listaende_csgluf;
	}

	public String getListaende_ipaisgeogr() {
		return listaende_ipaisgeogr;
	}
	public void setListaende_ipaisgeogr(String listaende_ipaisgeogr) {
		this.listaende_ipaisgeogr = listaende_ipaisgeogr;
	}

	public String getListaende_selendergrid() {
		return listaende_selendergrid;
	}
	public void setListaende_selendergrid(String listaende_selendergrid) {
		this.listaende_selendergrid = listaende_selendergrid;
	}
    
}