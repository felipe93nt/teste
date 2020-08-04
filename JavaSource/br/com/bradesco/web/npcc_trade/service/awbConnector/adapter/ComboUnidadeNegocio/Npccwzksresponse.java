package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 16/06/16 12:08
 */
public class Npccwzksresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZKS-HEADER.NPCCWZKS-COD-LAYOUT")
	private String codlayout = "NPCCWZKS";

	@Adapter(transactionField = "NPCCWZKS-HEADER.NPCCWZKS-TAM-LAYOUT")
	private Integer tamlayout = 11632;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-CPSSOA-JURID-SUPE")
	private Long cpssoajuridsupe = 0L;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-NSEQ-UND-SUPE")
	private Integer nsequndsupe = 0;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-CIDTFD-TPO-UND-SUPE")
	private Integer cidtfdtpoundsupe = 0;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-CRCONH-UND-SUPE-M")
	private Integer crconhundsupem = 0;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-CRCONH-UND-SUPE-F")
	private Integer crconhundsupef = 0;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-IRZ-SCIAL-SUPE")
	private String irzscialsupe = null;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-CTPO-UND-ORGNZ-SUPE")
	private Integer ctpoundorgnzsupe = 0;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-ITPO-UND-ORGNZ-SUPE")
	private String itpoundorgnzsupe = null;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCCWZKS-REGISTRO.NPCCWZKS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboUnidadeNegocio.Npccwzksresponse_lista")
	private List<Npccwzksresponse_lista> lista = null;
	
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

	public Long getCpssoajuridsupe() {
		return cpssoajuridsupe;
	}
	public void setCpssoajuridsupe(Long cpssoajuridsupe) {
		this.cpssoajuridsupe = cpssoajuridsupe;
	}

	public Integer getNsequndsupe() {
		return nsequndsupe;
	}
	public void setNsequndsupe(Integer nsequndsupe) {
		this.nsequndsupe = nsequndsupe;
	}

	public Integer getCidtfdtpoundsupe() {
		return cidtfdtpoundsupe;
	}
	public void setCidtfdtpoundsupe(Integer cidtfdtpoundsupe) {
		this.cidtfdtpoundsupe = cidtfdtpoundsupe;
	}

	public Integer getCrconhundsupem() {
		return crconhundsupem;
	}
	public void setCrconhundsupem(Integer crconhundsupem) {
		this.crconhundsupem = crconhundsupem;
	}

	public Integer getCrconhundsupef() {
		return crconhundsupef;
	}
	public void setCrconhundsupef(Integer crconhundsupef) {
		this.crconhundsupef = crconhundsupef;
	}

	public String getIrzscialsupe() {
		return irzscialsupe;
	}
	public void setIrzscialsupe(String irzscialsupe) {
		this.irzscialsupe = irzscialsupe;
	}

	public Integer getCtpoundorgnzsupe() {
		return ctpoundorgnzsupe;
	}
	public void setCtpoundorgnzsupe(Integer ctpoundorgnzsupe) {
		this.ctpoundorgnzsupe = ctpoundorgnzsupe;
	}

	public String getItpoundorgnzsupe() {
		return itpoundorgnzsupe;
	}
	public void setItpoundorgnzsupe(String itpoundorgnzsupe) {
		this.itpoundorgnzsupe = itpoundorgnzsupe;
	}

	public Integer getQtdeocorr() {
		return qtdeocorr;
	}
	public void setQtdeocorr(Integer qtdeocorr) {
		this.qtdeocorr = qtdeocorr;
	}

	public List<Npccwzksresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npccwzksresponse_lista> lista) {
		this.lista = lista;
	}
    
}