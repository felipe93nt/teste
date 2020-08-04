package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesPendCompl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 07/07/16 15:14
 */
public class Npccwyjsresponse_gride extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-NBLETO-CMBIO-ANO")
	private Long gride_snbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-DT-COTACAO")
	private String gride_sdtcotacao = null;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-CUNIC-CLI-CMBIO")
	private Long gride_scunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-NCUNIC-CLI-CMBIO")
	private String gride_sncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-CINDCD-ECONM-MOEDA")
	private Integer gride_scindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-SIMBL-ECONM-MOEDA")
	private String gride_ssimbleconmmoeda = null;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-VNEGOC-MOEDA-ESTRG")
	private String gride_svnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-CPRODT-SERVC")
	private Integer gride_scprodtservc = 0;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-DPRODT-SERVC")
	private String gride_sdprodtservc = null;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-CMODLD-PRODT-CMBIO")
	private Integer gride_scmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-DMODLD-PRODT-CMBIO")
	private String gride_sdmodldprodtcmbio = null;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-CSIT-BLETO-CMBIO")
	private Integer gride_scsitbletocmbio = 0;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-DSIT-BLETO-CMBIO")
	private String gride_sdsitbletocmbio = null;

	@Adapter(transactionField = "NPCCWYJS-REGISTRO.NPCCWYJS-GRIDE.NPCCWYJS-S-NBLETO-NEGOC-CMBIO")
	private Long gride_snbletonegoccmbio = 0L;
	
	public Long getGride_snbletocmbioano() {
		return gride_snbletocmbioano;
	}
	public void setGride_snbletocmbioano(Long gride_snbletocmbioano) {
		this.gride_snbletocmbioano = gride_snbletocmbioano;
	}

	public String getGride_sdtcotacao() {
		return gride_sdtcotacao;
	}
	public void setGride_sdtcotacao(String gride_sdtcotacao) {
		this.gride_sdtcotacao = gride_sdtcotacao;
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

	public String getGride_svnegocmoedaestrg() {
		return gride_svnegocmoedaestrg;
	}
	public void setGride_svnegocmoedaestrg(String gride_svnegocmoedaestrg) {
		this.gride_svnegocmoedaestrg = gride_svnegocmoedaestrg;
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

	public String getGride_sdmodldprodtcmbio() {
		return gride_sdmodldprodtcmbio;
	}
	public void setGride_sdmodldprodtcmbio(String gride_sdmodldprodtcmbio) {
		this.gride_sdmodldprodtcmbio = gride_sdmodldprodtcmbio;
	}

	public Integer getGride_scsitbletocmbio() {
		return gride_scsitbletocmbio;
	}
	public void setGride_scsitbletocmbio(Integer gride_scsitbletocmbio) {
		this.gride_scsitbletocmbio = gride_scsitbletocmbio;
	}

	public String getGride_sdsitbletocmbio() {
		return gride_sdsitbletocmbio;
	}
	public void setGride_sdsitbletocmbio(String gride_sdsitbletocmbio) {
		this.gride_sdsitbletocmbio = gride_sdsitbletocmbio;
	}

	public Long getGride_snbletonegoccmbio() {
		return gride_snbletonegoccmbio;
	}
	public void setGride_snbletonegoccmbio(Long gride_snbletonegoccmbio) {
		this.gride_snbletonegoccmbio = gride_snbletonegoccmbio;
	}
    
}