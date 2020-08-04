package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesFechadas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/08/16 14:31
 */
public class Npccwzvsresponse_gride extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-DT-FECHAMENTO")
	private String gride_sdtfechamento = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-NBLETO-NEGOC-CMBIO")
	private Long gride_snbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-NBLETO-CMBIO-ANO")
	private Long gride_snbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-DIVERGENTE")
	private String gride_sdivergente = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-CUNIC-CLI-CMBIO")
	private Long gride_scunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-NCUNIC-CLI-CMBIO")
	private String gride_sncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-CINDCD-ECONM-MOEDA")
	private Integer gride_scindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-SIMBL-ECONM-MOEDA")
	private String gride_ssimbleconmmoeda = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-VLR-MOEDA-ESTRANG")
	private String gride_svlrmoedaestrang = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-CPRODT-SERVC")
	private Integer gride_scprodtservc = 0;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-DPRODT-SERVC")
	private String gride_sdprodtservc = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-CMODLD-PRODT-CMBIO")
	private Integer gride_scmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-CMODLD-PRODT-DESC")
	private String gride_scmodldprodtdesc = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-CUSUAR-INCLT")
	private String gride_scusuarinclt = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-NUSUAR-INCLT")
	private String gride_snusuarinclt = null;

	@Adapter(transactionField = "NPCCWZVS-REGISTRO.NPCCWZVS-GRIDE.NPCCWZVS-S-CSIT-BLETO-APROV")
	private Integer gride_scsitbletoaprov = 0;
	
	public String getGride_sdtfechamento() {
		return gride_sdtfechamento;
	}
	public void setGride_sdtfechamento(String gride_sdtfechamento) {
		this.gride_sdtfechamento = gride_sdtfechamento;
	}

	public Long getGride_snbletonegoccmbio() {
		return gride_snbletonegoccmbio;
	}
	public void setGride_snbletonegoccmbio(Long gride_snbletonegoccmbio) {
		this.gride_snbletonegoccmbio = gride_snbletonegoccmbio;
	}

	public Long getGride_snbletocmbioano() {
		return gride_snbletocmbioano;
	}
	public void setGride_snbletocmbioano(Long gride_snbletocmbioano) {
		this.gride_snbletocmbioano = gride_snbletocmbioano;
	}

	public String getGride_sdivergente() {
		return gride_sdivergente;
	}
	public void setGride_sdivergente(String gride_sdivergente) {
		this.gride_sdivergente = gride_sdivergente;
	}

	public Long getGride_scunicclicmbio() {
		return gride_scunicclicmbio;
	}
	public void setGride_scunicclicmbio(Long gride_scunicclicmbio) {
		this.gride_scunicclicmbio = gride_scunicclicmbio;
	}

	public String getGride_sncunicclicmbio() {
		return gride_sncunicclicmbio;
	}
	public void setGride_sncunicclicmbio(String gride_sncunicclicmbio) {
		this.gride_sncunicclicmbio = gride_sncunicclicmbio;
	}

	public Integer getGride_scindcdeconmmoeda() {
		return gride_scindcdeconmmoeda;
	}
	public void setGride_scindcdeconmmoeda(Integer gride_scindcdeconmmoeda) {
		this.gride_scindcdeconmmoeda = gride_scindcdeconmmoeda;
	}

	public String getGride_ssimbleconmmoeda() {
		return gride_ssimbleconmmoeda;
	}
	public void setGride_ssimbleconmmoeda(String gride_ssimbleconmmoeda) {
		this.gride_ssimbleconmmoeda = gride_ssimbleconmmoeda;
	}

	public String getGride_svlrmoedaestrang() {
		return gride_svlrmoedaestrang;
	}
	public void setGride_svlrmoedaestrang(String gride_svlrmoedaestrang) {
		this.gride_svlrmoedaestrang = gride_svlrmoedaestrang;
	}

	public Integer getGride_scprodtservc() {
		return gride_scprodtservc;
	}
	public void setGride_scprodtservc(Integer gride_scprodtservc) {
		this.gride_scprodtservc = gride_scprodtservc;
	}

	public String getGride_sdprodtservc() {
		return gride_sdprodtservc;
	}
	public void setGride_sdprodtservc(String gride_sdprodtservc) {
		this.gride_sdprodtservc = gride_sdprodtservc;
	}

	public Integer getGride_scmodldprodtcmbio() {
		return gride_scmodldprodtcmbio;
	}
	public void setGride_scmodldprodtcmbio(Integer gride_scmodldprodtcmbio) {
		this.gride_scmodldprodtcmbio = gride_scmodldprodtcmbio;
	}

	public String getGride_scmodldprodtdesc() {
		return gride_scmodldprodtdesc;
	}
	public void setGride_scmodldprodtdesc(String gride_scmodldprodtdesc) {
		this.gride_scmodldprodtdesc = gride_scmodldprodtdesc;
	}

	public String getGride_scusuarinclt() {
		return gride_scusuarinclt;
	}
	public void setGride_scusuarinclt(String gride_scusuarinclt) {
		this.gride_scusuarinclt = gride_scusuarinclt;
	}

	public String getGride_snusuarinclt() {
		return gride_snusuarinclt;
	}
	public void setGride_snusuarinclt(String gride_snusuarinclt) {
		this.gride_snusuarinclt = gride_snusuarinclt;
	}

	public Integer getGride_scsitbletoaprov() {
		return gride_scsitbletoaprov;
	}
	public void setGride_scsitbletoaprov(Integer gride_scsitbletoaprov) {
		this.gride_scsitbletoaprov = gride_scsitbletoaprov;
	}
    
}