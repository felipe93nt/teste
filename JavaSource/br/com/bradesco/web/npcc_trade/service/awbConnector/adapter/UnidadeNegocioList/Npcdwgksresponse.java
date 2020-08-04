package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidadeNegocioList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 29/02/16 19:36
 */
public class Npcdwgksresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWGKS-HEADER.NPCDWGKS-COD-LAYOUT")
	private String codlayout = "NPCDWGKS";

	@Adapter(transactionField = "NPCDWGKS-HEADER.NPCDWGKS-TAM-LAYOUT")
	private Integer tamlayout = 8992;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-CPSSOA-JURID-SUPE")
	private Long cpssoajuridsupe = 0L;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-NSEQ-UND-SUPE")
	private Integer nsequndsupe = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-CIDTFD-TPO-UND-SUPE")
	private Integer cidtfdtpoundsupe = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-CRCONH-UND-SUPE-M")
	private Integer crconhundsupem = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-CRCONH-UND-SUPE-F")
	private Integer crconhundsupef = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-IRZ-SCIAL-SUPE")
	private String irzscialsupe = null;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-CTPO-UND-ORGNZ-SUPE")
	private Integer ctpoundorgnzsupe = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-ITPO-UND-ORGNZ-SUPE")
	private String itpoundorgnzsupe = null;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-QTDE-OCORR")
	private Integer qtdeocorr = 0;

	@Adapter(transactionField = "NPCDWGKS-REGISTRO.NPCDWGKS-LISTA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.UnidadeNegocioList.Npcdwgksresponse_lista")
	private List<Npcdwgksresponse_lista> lista = null;
	
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

	public List<Npcdwgksresponse_lista> getLista() {
		return lista;
	}
	public void setLista( List<Npcdwgksresponse_lista> lista) {
		this.lista = lista;
	}
    
}