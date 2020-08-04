package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.DetalharTarifaDespes;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 06/04/16 15:38
 */
public class Npccwiderequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWIDE-HEADER.NPCCWIDE-COD-LAYOUT")
	private String codlayout = "NPCCWIDE";

	@Adapter(transactionField = "NPCCWIDE-HEADER.NPCCWIDE-TAM-LAYOUT")
	private Integer tamlayout = 89;

	@Adapter(transactionField = "NPCCWIDE-REGISTRO.NPCCWIDE-CUSUAR-LIM-CMBIO")
	private Long cusuarlimcmbio = 0L;

	@Adapter(transactionField = "NPCCWIDE-REGISTRO.NPCCWIDE-CTPO-DESP-CMBIO")
	private Integer ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWIDE-REGISTRO.NPCCWIDE-DTPO-DESP-CMBIO")
	private String dtpodespcmbio = null;

	@Adapter(transactionField = "NPCCWIDE-REGISTRO.NPCCWIDE-NTPO-SIT-CMBIO")
	private String ntpositcmbio = null;
	
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

	public Long getCusuarlimcmbio() {
		return cusuarlimcmbio;
	}
	public void setCusuarlimcmbio(Long cusuarlimcmbio) {
		this.cusuarlimcmbio = cusuarlimcmbio;
	}

	public Integer getCtpodespcmbio() {
		return ctpodespcmbio;
	}
	public void setCtpodespcmbio(Integer ctpodespcmbio) {
		this.ctpodespcmbio = ctpodespcmbio;
	}

	public String getDtpodespcmbio() {
		return dtpodespcmbio;
	}
	public void setDtpodespcmbio(String dtpodespcmbio) {
		this.dtpodespcmbio = dtpodespcmbio;
	}

	public String getNtpositcmbio() {
		return ntpositcmbio;
	}
	public void setNtpositcmbio(String ntpositcmbio) {
		this.ntpositcmbio = ntpositcmbio;
	}
    
}