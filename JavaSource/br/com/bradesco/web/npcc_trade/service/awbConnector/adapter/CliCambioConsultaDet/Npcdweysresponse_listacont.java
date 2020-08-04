package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweysresponse_listacont extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-CONT.NPCDWEYS-CDDI-FONE")
	private String listacont_cddifone = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-CONT.NPCDWEYS-CDDD-FONE")
	private String listacont_cdddfone = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-CONT.NPCDWEYS-NLIN-TFONI-REFT")
	private Long listacont_nlintfonireft = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-CONT.NPCDWEYS-ICNTAT-PSSOA-CMBIO")
	private String listacont_icntatpssoacmbio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-CONT.NPCDWEYS-EENDER-ELETR-CMBIO")
	private String listacont_eendereletrcmbio = null;
	
	public String getListacont_cddifone() {
		return listacont_cddifone;
	}
	public void setListacont_cddifone(String listacont_cddifone) {
		this.listacont_cddifone = listacont_cddifone;
	}

	public String getListacont_cdddfone() {
		return listacont_cdddfone;
	}
	public void setListacont_cdddfone(String listacont_cdddfone) {
		this.listacont_cdddfone = listacont_cdddfone;
	}

	public Long getListacont_nlintfonireft() {
		return listacont_nlintfonireft;
	}
	public void setListacont_nlintfonireft(Long listacont_nlintfonireft) {
		this.listacont_nlintfonireft = listacont_nlintfonireft;
	}

	public String getListacont_icntatpssoacmbio() {
		return listacont_icntatpssoacmbio;
	}
	public void setListacont_icntatpssoacmbio(String listacont_icntatpssoacmbio) {
		this.listacont_icntatpssoacmbio = listacont_icntatpssoacmbio;
	}

	public String getListacont_eendereletrcmbio() {
		return listacont_eendereletrcmbio;
	}
	public void setListacont_eendereletrcmbio(String listacont_eendereletrcmbio) {
		this.listacont_eendereletrcmbio = listacont_eendereletrcmbio;
	}
    
}