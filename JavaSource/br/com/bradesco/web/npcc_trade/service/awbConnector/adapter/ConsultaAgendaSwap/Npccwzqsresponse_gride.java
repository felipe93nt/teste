package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultaAgendaSwap;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 14/09/16 16:40
 */
public class Npccwzqsresponse_gride extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-CUNIC-CLI-CMBIO")
	private Long gride_cunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NCUNIC-CLI-CMBIO")
	private String gride_ncunicclicmbio = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NSEQ-UND-ORGNZ")
	private Integer gride_nsequndorgnz = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NOME-UND-ORGNZ")
	private String gride_nomeundorgnz = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-DVCTO-PCELA-TRADE")
	private String gride_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-CTPO-COTAC-TX")
	private Integer gride_ctpocotactx = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-VPCELA-PRNC-TRADE")
	private String gride_vpcelaprnctrade = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-VPCELA-JURO-TRADE")
	private String gride_vpcelajurotrade = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-CPRODT-SERVC")
	private Integer gride_cprodtservc = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-DPRODT-SERVC")
	private String gride_dprodtservc = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-CMODLD-PRODT-CMBIO")
	private Integer gride_cmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-CMODLD-PRODT-DESC")
	private String gride_cmodldprodtdesc = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-TDIA-OPER-CMBIO")
	private Integer gride_tdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NOME-ROF")
	private String gride_nomerof = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NBLETO-CMBIO-ANO")
	private Long gride_nbletocmbioano = 0L;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-CADITV-BLETO-CMBIO")
	private Integer gride_caditvbletocmbio = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-CINDCD-LIQDC-SWAP")
	private String gride_cindcdliqdcswap = null;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NBLETO-NEGOC-CMBIO")
	private Long gride_nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NDSEMB-CMBIO-P")
	private Integer gride_ndsembcmbiop = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NPCELA-DSEMB-P")
	private Integer gride_npceladsembp = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NDSEMB-CMBIO-J")
	private Integer gride_ndsembcmbioj = 0;

	@Adapter(transactionField = "NPCCWZQS-REGISTRO.NPCCWZQS-GRIDE.NPCCWZQS-NPCELA-DSEMB-J")
	private Integer gride_npceladsembj = 0;
	
	public Long getGride_cunicclicmbio() {
		return gride_cunicclicmbio;
	}
	public void setGride_cunicclicmbio(Long gride_cunicclicmbio) {
		this.gride_cunicclicmbio = gride_cunicclicmbio;
	}

	public String getGride_ncunicclicmbio() {
		return gride_ncunicclicmbio;
	}
	public void setGride_ncunicclicmbio(String gride_ncunicclicmbio) {
		this.gride_ncunicclicmbio = gride_ncunicclicmbio;
	}

	public Integer getGride_nsequndorgnz() {
		return gride_nsequndorgnz;
	}
	public void setGride_nsequndorgnz(Integer gride_nsequndorgnz) {
		this.gride_nsequndorgnz = gride_nsequndorgnz;
	}

	public String getGride_nomeundorgnz() {
		return gride_nomeundorgnz;
	}
	public void setGride_nomeundorgnz(String gride_nomeundorgnz) {
		this.gride_nomeundorgnz = gride_nomeundorgnz;
	}

	public String getGride_dvctopcelatrade() {
		return gride_dvctopcelatrade;
	}
	public void setGride_dvctopcelatrade(String gride_dvctopcelatrade) {
		this.gride_dvctopcelatrade = gride_dvctopcelatrade;
	}

	public Integer getGride_ctpocotactx() {
		return gride_ctpocotactx;
	}
	public void setGride_ctpocotactx(Integer gride_ctpocotactx) {
		this.gride_ctpocotactx = gride_ctpocotactx;
	}

	public String getGride_vpcelaprnctrade() {
		return gride_vpcelaprnctrade;
	}
	public void setGride_vpcelaprnctrade(String gride_vpcelaprnctrade) {
		this.gride_vpcelaprnctrade = gride_vpcelaprnctrade;
	}

	public String getGride_vpcelajurotrade() {
		return gride_vpcelajurotrade;
	}
	public void setGride_vpcelajurotrade(String gride_vpcelajurotrade) {
		this.gride_vpcelajurotrade = gride_vpcelajurotrade;
	}

	public Integer getGride_cprodtservc() {
		return gride_cprodtservc;
	}
	public void setGride_cprodtservc(Integer gride_cprodtservc) {
		this.gride_cprodtservc = gride_cprodtservc;
	}

	public String getGride_dprodtservc() {
		return gride_dprodtservc;
	}
	public void setGride_dprodtservc(String gride_dprodtservc) {
		this.gride_dprodtservc = gride_dprodtservc;
	}

	public Integer getGride_cmodldprodtcmbio() {
		return gride_cmodldprodtcmbio;
	}
	public void setGride_cmodldprodtcmbio(Integer gride_cmodldprodtcmbio) {
		this.gride_cmodldprodtcmbio = gride_cmodldprodtcmbio;
	}

	public String getGride_cmodldprodtdesc() {
		return gride_cmodldprodtdesc;
	}
	public void setGride_cmodldprodtdesc(String gride_cmodldprodtdesc) {
		this.gride_cmodldprodtdesc = gride_cmodldprodtdesc;
	}

	public Integer getGride_tdiaopercmbio() {
		return gride_tdiaopercmbio;
	}
	public void setGride_tdiaopercmbio(Integer gride_tdiaopercmbio) {
		this.gride_tdiaopercmbio = gride_tdiaopercmbio;
	}

	public String getGride_nomerof() {
		return gride_nomerof;
	}
	public void setGride_nomerof(String gride_nomerof) {
		this.gride_nomerof = gride_nomerof;
	}

	public Long getGride_nbletocmbioano() {
		return gride_nbletocmbioano;
	}
	public void setGride_nbletocmbioano(Long gride_nbletocmbioano) {
		this.gride_nbletocmbioano = gride_nbletocmbioano;
	}

	public Integer getGride_caditvbletocmbio() {
		return gride_caditvbletocmbio;
	}
	public void setGride_caditvbletocmbio(Integer gride_caditvbletocmbio) {
		this.gride_caditvbletocmbio = gride_caditvbletocmbio;
	}

	public String getGride_cindcdliqdcswap() {
		return gride_cindcdliqdcswap;
	}
	public void setGride_cindcdliqdcswap(String gride_cindcdliqdcswap) {
		this.gride_cindcdliqdcswap = gride_cindcdliqdcswap;
	}

	public Long getGride_nbletonegoccmbio() {
		return gride_nbletonegoccmbio;
	}
	public void setGride_nbletonegoccmbio(Long gride_nbletonegoccmbio) {
		this.gride_nbletonegoccmbio = gride_nbletonegoccmbio;
	}

	public Integer getGride_ndsembcmbiop() {
		return gride_ndsembcmbiop;
	}
	public void setGride_ndsembcmbiop(Integer gride_ndsembcmbiop) {
		this.gride_ndsembcmbiop = gride_ndsembcmbiop;
	}

	public Integer getGride_npceladsembp() {
		return gride_npceladsembp;
	}
	public void setGride_npceladsembp(Integer gride_npceladsembp) {
		this.gride_npceladsembp = gride_npceladsembp;
	}

	public Integer getGride_ndsembcmbioj() {
		return gride_ndsembcmbioj;
	}
	public void setGride_ndsembcmbioj(Integer gride_ndsembcmbioj) {
		this.gride_ndsembcmbioj = gride_ndsembcmbioj;
	}

	public Integer getGride_npceladsembj() {
		return gride_npceladsembj;
	}
	public void setGride_npceladsembj(Integer gride_npceladsembj) {
		this.gride_npceladsembj = gride_npceladsembj;
	}
    
}